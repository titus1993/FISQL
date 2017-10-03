/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.Usql.ParseException;
import Analisis.Usql.usqlGrammar;
import Analisis.XML.Reporte.reporteGrammar;
import EjecucionUsql.EjecucionUsql;
import EjecucionUsql.TablaSeleccionar;
import Static.Tools;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titus
 */
public class Paquete {

    String Tipo;
    String Usuario, Password;

    String Instruccion;

    public Paquete(String Tipo, String Usuario, String Password) {
        this.Tipo = Tipo;
        this.Usuario = Usuario;
        this.Password = Password;
        this.Instruccion = "";

    }

    public Paquete(String Tipo) {
        this.Tipo = Tipo;
        this.Usuario = "";
        this.Password = "";
        this.Instruccion = "";
    }

    public Paquete(String Tipo, String Instruccion) {
        this.Tipo = Tipo;
        this.Usuario = "";
        this.Password = "";
        this.Instruccion = Instruccion;

    }

    public void Ejecutar() {
        Tools.LimpiarTabla();
        if (Tipo.equals("usql")) {
            try {               
                
                String texto = this.Instruccion;

                usqlGrammar procDatos = new usqlGrammar(new java.io.StringReader(texto));
                EjecucionUsql datos = procDatos.S();

                datos = datos;
                datos.Ejecutar();

            } catch (ParseException ex) {
                //Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
                Tools.InsertarError("Error", ex.getMessage(), 1, 1);
            }
        }else if(Tipo.equals("reporte")){
            try {
                
                String texto = this.Instruccion;

                reporteGrammar procDatos = new reporteGrammar(new java.io.StringReader(texto));
                Etiqueta datos = procDatos.S();

                datos = datos;
                datos.Ejecutar();
                
                Tools.ResultadosRetorno = new ArrayList<TablaSeleccionar>();

            } catch (Analisis.XML.Reporte.ParseException ex) {
                //Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
                Tools.InsertarError("Error", ex.getMessage(), 1, 1);
            }
        }else if(Tipo.equals("bacup")){
            if(Tools.BaseActual != null){
                Tools.Bacup = Tools.Base_de_datos.Backup();
            }
        }
    }
}
