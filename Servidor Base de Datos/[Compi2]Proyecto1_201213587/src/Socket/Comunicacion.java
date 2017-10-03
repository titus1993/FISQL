/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Analisis.Usql.ParseException;
import Analisis.Usql.usqlGrammar;
import Analisis.XML.Paquetes.paquetesGrammar;
import EjecucionUsql.EjecucionUsql;
import EjecucionUsql.TablaSeleccionar;
import Funciones.XML.Paquete;
import Static.Tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Antonio
 */
public class Comunicacion extends Thread implements Runnable {

    private static Comunicacion comunicacion = null;
    int contador;

    public static Comunicacion getInstance() {
        if (comunicacion == null) {
            comunicacion = new Comunicacion();
        }
        return comunicacion;
    }

    private Comunicacion() {
    }

    public void resetear() {
        this.contador = 0;
    }

    @Override
    public void run() {
        PrintWriter pw = null;
        //REVISAR SI HAY CLIENTES QUE NO HAN PAGADO DOS (Cada 6 de Mes)
        while (true) {
            ServerSocket s = null;
            try {
                s = new ServerSocket(5000);
                Socket ss = s.accept();
                pw = new PrintWriter(ss.getOutputStream(), true);
                // Mensaje del cliente!
                byte[] bytes = new byte[100000];
                ss.getInputStream().read(bytes);
                String str = new String(bytes, StandardCharsets.UTF_8);
                System.out.println(str);

                //ejecutamos el usql
                String texto = str.trim();

                paquetesGrammar paquete = new paquetesGrammar(new java.io.StringReader(texto));

                try {
                    Paquete instruccion = paquete.S();
                    instruccion.Ejecutar();

                    // Envia servidor al cliente
                    String paqueteMensaje = "[paquete:usql mensaje:§" + Tools.Imprimir + Tools.CadenaErrores + "§]";
                    pw.println(paqueteMensaje);
                    //pw.println(Tools.CadenaErrores);
                    
                    for(TablaSeleccionar t : Tools.ResultadosRetorno){
                        String cadena = "[paquete:reporte mensaje:§" + t.GetHtml() + "§]";
                        pw.println(cadena);
                    }
                    
                    if(Tools.Bacup != ""){
                        String cadena = "[paquete:bacup mensaje:§" + Tools.Bacup + "§]";
                        pw.println(cadena);
                    }
                    
                    if(!Tools.ReporteHtml.equals("")){
                        String reporteHtml = "[paquete:reporte mensaje:§" + Tools.ReporteHtml + "§]";
                        pw.println(reporteHtml);
                    }
                    
                    String plan = "[paquete:ejecucion mensaje:§" + Tools.Consola.getText() + "§]";
                    pw.println(plan);
                    

                } catch (Analisis.XML.Paquetes.ParseException ex) {
                    Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
                }

                Thread.sleep(500);
            } catch (IOException ex) {
                Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    pw.println("[paquete:fin]");
                    s.close();
                } catch (IOException ex) {
                    Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
