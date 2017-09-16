/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class FCrearBaseDatos {
    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;
    
    public FCrearBaseDatos(String Nombre, Ambito Ambito, int Fila, int Columna){
        this.Padre = null;
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    public void Ejecutar(){
        if(Tools.Base_de_datos.DLLCrearBaseDatos(this.Nombre, Tools.Usuario.name)){
            Tools.ImprimirLog("Crear Base de Datos", "Creacion de la base de datos " + this.Nombre);
        }else{
            Tools.InsertarError("Semantico", "Ya existe la base de datos " + this.Nombre, Fila, Columna);
        }
        
    }
    
    public String getCadena(){
        return "CREAR BASE_DATOS " + this.Nombre + ";";
    }
}
