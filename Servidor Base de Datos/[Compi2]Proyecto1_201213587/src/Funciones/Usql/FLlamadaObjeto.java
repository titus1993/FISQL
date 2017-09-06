/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;
//import Interface.TitusNotificaciones;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FLlamadaObjeto {

    public FLlamadaObjeto Hijo;
    public String Tipo, Nombre;
    public int Fila, Columna;
    public FLlamadaMetodo LlamadaMetodo;

    public FLlamadaObjeto(String tipo, String nombre, int fila, int columna, Object valor) {
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;
        this.LlamadaMetodo = null;

        if (tipo.equals(Constante.TMetodo)) {
            this.LlamadaMetodo = (FLlamadaMetodo) valor;
        }
        this.Hijo = null;
    }

    public void InsertarHijo(FLlamadaObjeto hijo) {
        if (this.Hijo == null) {
            this.Hijo = hijo;
        } else {
            this.Hijo.InsertarHijo(hijo);
        }
    }

    public void Ejecutar() {
       
    }

    private void EjecutarHijo() {
        
    }
}
