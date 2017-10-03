/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Static.Constante;

/**
 *
 * @author Titus
 */
public class FContar {
    public FSeleccionar Seleccionar;    

    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;
    
    public FContar(FSeleccionar Seleccionar, int Fila, int Columna) {
        this.Seleccionar = Seleccionar;
        this.Ambito = new Ambito(Constante.TContar);
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    
    public FNodoExpresion Ejecutar(){
        return  this.Seleccionar.EjecutarContar();
    }
    
    public String getCadena(){
        String cadena = "";
        
        cadena = "CONTAR (<< " + Seleccionar.getCadena() + " >>)";
        
        return cadena;
    }
}
