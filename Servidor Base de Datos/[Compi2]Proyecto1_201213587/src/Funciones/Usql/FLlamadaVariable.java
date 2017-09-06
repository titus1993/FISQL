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
public class FLlamadaVariable {

    public String Nombre, Objeto;
    public int Fila, Columna;

    public FLlamadaVariable(String nombre, String objeto,int fila, int columna) {
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;
        this.Objeto = objeto;
    }

    public void Ejecutar() {
       
    }
}
