/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.Usql.ParseException;
import Analisis.Usql.usqlGrammar;
import EjecucionUsql.EjecucionUsql;
import EjecucionUsql.TablaSeleccionar;
import Funciones.Usql.FSeleccionar;
import Funciones.Usql.FUsarBaseDatos;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Etiqueta {

    ArrayList<Etiqueta> Hijos;

    String Tipo;
    String Atributo;
    String Cuerpo;

    public Etiqueta(String Tipo, String Atributo, String Cuerpo) {
        this.Tipo = Tipo;
        this.Atributo = Atributo;
        this.Cuerpo = Cuerpo;
        this.Hijos = new ArrayList<>();
    }

    public Etiqueta(String Tipo, String Atributo, String Cuerpo, ArrayList<Etiqueta> Hijos) {
        this.Tipo = Tipo;
        this.Atributo = Atributo;
        this.Cuerpo = Cuerpo;
        this.Hijos = Hijos;
    }

    public void Ejecutar() {
        String cadena = generarHTML(this);
        
        Tools.ReporteHtml = cadena;       
        
    }

    public String generarHTML(Etiqueta etq) {
        String cadena = "";
        switch (etq.Tipo) {
            case "html":
                cadena = "<html>\n";

                for (Etiqueta e : etq.Hijos) {
                    cadena += "\t" + generarHTML(e);
                }

                cadena += "</html>\n";
                break;

            case "head":
                cadena += "<head></head>\n";
                break;
                
            case "h1":
                cadena += "<h1>" + etq.Cuerpo  + "</h1>\n";
                break;

            case "body":
                cadena += "<body>\n";
                for (Etiqueta e : etq.Hijos) {
                    cadena += "\t" + generarHTML(e);
                }
                cadena += "</body>\n";

                break;

            case "div":
                cadena += "<div>\n";
                for (Etiqueta e : etq.Hijos) {
                    cadena += "\t" + generarHTML(e);
                }
                cadena += "</div>\n";

                break;
                
            case "h":
                cadena += "<h1>" + etq.Cuerpo + "</h1>\n";
                break;
                
            case "usql":
                cadena += resolverUSQL(etq);
                break;

        }

        return cadena;
    }
    
    public String resolverUSQL(Etiqueta etq){
        String cadena = "<table>\n";
        
        try {                
                String texto = etq.Cuerpo;

                usqlGrammar procDatos = new usqlGrammar(new java.io.StringReader(texto));
                EjecucionUsql datos = procDatos.S();

                if(datos.Global.size() == 1){
                    if(datos.Global.get(0).Tipo.equals(Constante.TSeleccionar)){
                        FUsarBaseDatos usar = new FUsarBaseDatos(etq.Atributo, null, 0, 0);
                        usar.Ejecutar();
                        
                        FSeleccionar f = ((FSeleccionar)datos.Global.get(0).Valor);
                        f.Ejecutar();
                        
                        if(Tools.ContarErrores() && Tools.TablaResultado != null){
                            cadena += Tools.TablaResultado.GetHtml();
                            Tools.TablaResultado = null;
                        }
                    }
                }
                

            } catch (ParseException ex) {
                //Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
                Tools.InsertarError("Error", ex.getMessage(), 1, 1);
            }
        
        cadena += "</table>";
        
        return cadena;
    }
}
