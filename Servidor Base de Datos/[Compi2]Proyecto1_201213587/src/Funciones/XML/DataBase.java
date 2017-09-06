/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.XML.DB.*;
import Analisis.XML.Funcion.*;
import Analisis.XML.Objeto.*;
import Analisis.XML.Procedimiento.*;
import Analisis.XML.Tabla.*;
import Static.Tools;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titus
 */
public class DataBase {

    public String Nombre, Path, RutaObjetos, RutaProcedimiento, RutaFuncion;
    public ArrayList<Objeto> Objetos = new ArrayList<Objeto>();
    public ArrayList<Procedimiento> Procedimientos = new ArrayList<>();
    public ArrayList<Funcion> Funciones = new ArrayList<>();
    public ArrayList<Tabla> Tablas = new ArrayList<>();

    public DataBase(String nombre, String path) {
        Nombre = nombre;
        Path = path;
    }

    public DataBase(String rutaprocedimiento, String rutafuncion, String rutaobjeto, ArrayList<Tabla> tablas) {
        RutaProcedimiento = rutaprocedimiento;
        RutaFuncion = rutafuncion;
        RutaObjetos = rutaobjeto;
        Tablas = tablas;
    }
    
    
    
    public boolean PruebaAlterTablaAgregar(String nombretabla, ArrayList<ColumnaEstructura> nuevas){
        Tabla tabla = ExisteTabla(nombretabla);
        
        for (ColumnaEstructura col : nuevas) {
            //comprobamos que no exista mas de una primaria
            if (tabla.ExistePrimaria() && col.Complementos.isPrimary) {
                //Error ya existe una llave primaria
                return false;
            }
            
            //comprobamos que no se repita el nombre
            for (ColumnaEstructura col2 : tabla.Columnas) {
                if (col.NombreCampo.equals(col2.NombreCampo)) {
                    //Error ya existe el nombre
                    return false;
                }
            }
            
            //comprobamos que existe la tabla foranea con llave primaria
            if(col.Complementos.isForanea){
              Tabla tablaforanea = ExisteTabla(col.Complementos.Foranea);
              if(tablaforanea != null){
                  if(!tablaforanea.ExistePrimaria()){
                      //Error la tabla no tiene una llave primaria para la relacion
                      return false;
                  }
              }else{
                  //Error no existe la tabla para hacer la relacion foranea
                  return false;
              }
            }
            
            if(col.Tipo != 0){
                Objeto obj = ExisteObjeto(col.TipoCampo);
                if(obj == null){
                    //Error no existe el objeto
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean PruebaAlterTablaQuitar(String nombretabla, ArrayList<ColumnaEstructura> nuevas){
        Tabla tabla = ExisteTabla(nombretabla);
        
        for (ColumnaEstructura col : nuevas) {
            //comprobamos que no se quiera eliminar una llave primaria
            for(ColumnaEstructura ce :tabla.Columnas){
                if(ce.NombreCampo.equals(col.NombreCampo)){
                    if(ce.Complementos.isPrimary){
                        return false;
                    }
                }
            }            
            
        }
        return true;
    }
    
    public boolean PruebaAlterObjetoAgregar(String nombreobjeto, ArrayList<Parametro> nuevas){
        Objeto objeto = ExisteObjeto(nombreobjeto);
        
        for (Parametro par : nuevas) {
                        
            //comprobamos que no se repita el nombre
            for (Parametro par2 : objeto.parametros) {
                if (par.nombre.equals(par2.nombre)) {
                    //Error ya existe el nombre
                    return false;
                }
            }
        }
        return true;
    }
    
    
    public Tabla ExisteTabla(String nombre){
        for(Tabla tab : Tablas){
            if(tab.Nombre.equals(nombre)){
                return tab;
            }
        }
        return null;
    }    
    
    public Procedimiento ExisteProcedimiento(String nombre){
        for(Procedimiento proc : Procedimientos){
            if(proc.nombre.equals(nombre)){
                return proc;
            }
        }
        return null;
    }
    
    public Funcion ExisteFuncion(String nombre){
        for(Funcion fun : Funciones){
            if(fun.nombre.equals(nombre)){
                return fun;
            }
        }
        return null;
    }
    
    public Objeto ExisteObjeto(String nombre){
        for(Objeto obj : Objetos){
            if(obj.nombre.equals(nombre)){
                return obj;
            }
        }
        return null;
    }
    
    public String getXML(){
        String cadena ="";
        
        
        cadena += "<Procedure>\n"
                + "\t<Path>\"" + RutaProcedimiento + "\"</Path>\n"
                + "</Procedure>\n"
                + "<Funcion>\n"
                + "\t<Path>\"" + RutaFuncion + "\"</Path>\n"
                + "</Funcion>\n"
                + "<Object>\n"
                + "\t<Path>\"" + RutaObjetos + "\"</Path>\n"
                + "</Object>\n"
                ;
        
        for(int i =0; i < Tablas.size(); i++){
            cadena += Tablas.get(i).getXML();
        }
        
        return cadena;
    }
    
    public void GuardarBaseDatos(){
        String cadena = "";
        for(int i = 0; i < Objetos.size(); i++){
            Objeto temp = Objetos.get(i);
            cadena += temp.getXML();
        }
        Tools.guardarArchivo(RutaObjetos, cadena);
        
        cadena = "";
        for(int i = 0; i < Funciones.size(); i++){
            Funcion temp = Funciones.get(i);
            cadena  += temp.getXML();
        }
        Tools.guardarArchivo(RutaFuncion, cadena);
        
        cadena = "";
        for(int i = 0; i < Procedimientos.size(); i++){
            Procedimiento temp = Procedimientos.get(i);
            cadena += temp.getXML();
        }
        Tools.guardarArchivo(RutaProcedimiento, cadena);
        
        for(int i = 0; i < Tablas.size(); i++){
            Tabla temp = Tablas.get(i);
            temp.GuardarTabla();
        }
    }

    public void Cargar() {
        if (CargarDB()) {
            CargarProcedimientos();
            CargarFunciones();
            CargarObjetos();
            CargarTablas();
        }
    }

    public boolean CargarDB() {
        try {
            if (Tools.Existe(Path)) {
                String texto = Tools.LeerArchivo(Path);

                dbGrammar dbDatos = new dbGrammar(new java.io.StringReader(texto));
                DataBase datos = dbDatos.S();

                this.RutaFuncion = datos.RutaFuncion;
                this.RutaProcedimiento = datos.RutaProcedimiento;
                this.RutaObjetos = datos.RutaObjetos;
                this.Tablas = datos.Tablas;
                System.out.println("Cargo Base de datos");
                return true;
            } else {
                Tools.ImprimirConsola("La archivo xml de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.DB.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void CargarProcedimientos() {
        try {
            if (Tools.Existe(this.RutaProcedimiento)) {
                String texto = Tools.LeerArchivo(this.RutaProcedimiento);

                procGrammar procDatos = new procGrammar(new java.io.StringReader(texto));
                ArrayList<Procedimiento> datos = procDatos.S();

                this.Procedimientos = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de procedimientos de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Procedimiento.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarFunciones() {
        try {
            if (Tools.Existe(this.RutaFuncion)) {
                String texto = Tools.LeerArchivo(this.RutaFuncion);

                funcGrammar funcDatos = new funcGrammar(new java.io.StringReader(texto));
                ArrayList<Funcion> datos = funcDatos.S();

                this.Funciones = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de funciones de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Funcion.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarObjetos() {
        try {
            if (Tools.Existe(this.RutaObjetos)) {
                String texto = Tools.LeerArchivo(this.RutaObjetos);

                objGrammar objDatos = new objGrammar(new java.io.StringReader(texto));
                ArrayList<Objeto> datos = objDatos.S();

                this.Objetos = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de objetos de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Objeto.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarTablas() {
        for (int i = 0; i < Tablas.size(); i++) {
            try {
                Tabla temp = Tablas.get(i);
                if (Tools.Existe(temp.Path)) {
                    String texto = Tools.LeerArchivo(temp.Path);

                    tablaGrammar tablaDatos = new tablaGrammar(new java.io.StringReader(texto));
                    ArrayList<ArrayList<Columna>> datos = tablaDatos.S();

                    temp.Filas = datos;

                    System.out.println("Cargo Base de datos");
                } else {
                    Tools.ImprimirConsola("La archivo xml de tablas de la base de datos " + this.Nombre + " no existe.");
                }
            } catch (Analisis.XML.Tabla.ParseException ex) {
                Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
