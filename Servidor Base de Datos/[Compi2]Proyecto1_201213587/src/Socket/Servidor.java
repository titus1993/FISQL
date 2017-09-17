/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Analisis.Usql.usqlGrammar;
import EjecucionUsql.EjecucionUsql;
import Static.Tools;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    public void run() {
        Socket socket = new Socket();
        while (true) {
            System.out.println("Entra Hilo...");
            try {
                ServerSocket serverSo = new ServerSocket(9770);
                socket = new Socket();
                System.out.println("Esperando una conexion...");

                /*Recibe Mensaje*/
                socket = serverSo.accept();
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

                System.out.println("Conexion con Cliente");

                String readLine = "";
                String codigo = "";
                while ((readLine = entrada.readLine()) != null) {
                    if (readLine.equals("§§§")) {
                        break;
                    }
                    codigo += readLine + "\n";
                }

                //Aqui mandar a analizar el mensaje recibido en la variable mensajeRecibido
                usqlGrammar procDatos = new usqlGrammar(new java.io.StringReader(codigo));
                EjecucionUsql datos = procDatos.S();

                datos = datos;
                datos.Ejecutar();
                //Luego la respuesta del analisis enviarla de regreso

                /*Envía Mensaje*/
                
                DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
                mensaje.writeUTF(Tools.CadenaErrores + "\n");
                System.out.println("Respuesta enviada");

                serverSo.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
