/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Static.Constante;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class FUsarBaseDatos {
    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;
    
    public FUsarBaseDatos(String Nombre, Ambito Ambito, int Fila, int Columna){
        this.Padre = null;
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    public void Ejecutar(){
            if(!Tools.Base_de_datos.DLLUsarBaseDatos(this.Nombre, Tools.Usuario.name)){
                Tools.InsertarError("Semantico", "No existe la base de datos " + this.Nombre + " para ser utilizada.", Fila, Columna);
            }else{
                Tools.ImprimirLog("Usar base de datos", "Se selecciono la base de datos " + this.Nombre);
            }       
    }
    
    public String getCadena(){
        return "USAR " + this.Nombre + ";";
    }
}
