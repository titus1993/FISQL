/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;

/**
 *
 * @author Titus
 */
public class FDeclaracion {

    public Ambito Ambito;
    public Ambito Padre;
    public String Tipo, Nombre;
    public FNodoExpresion Valor;
    public int Fila, Columna;

    public FDeclaracion(String tipo, String nombre, Ambito ambito, Object valor, int fila, int columna) {
        this.Ambito = ambito;
        this.Padre = null;
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;
        this.Valor = (FNodoExpresion) valor;
    }

    public void EjecutarDeclaracion() {
        
    }
}
