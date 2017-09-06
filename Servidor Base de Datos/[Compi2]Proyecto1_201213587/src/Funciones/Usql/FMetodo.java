/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.*;
//import Interface.TitusNotificaciones;
import java.util.ArrayList;
import Static.Constante;

/**
 *
 * @author Titus
 */
public class FMetodo {

    public Ambito Ambito;
    public ArrayList<Simbolo> Parametros;
    public int Fila, Columna;
    public String Tipo, Nombre;

    public FMetodo(ArrayList<Simbolo> parametro, Ambito ambito, int fila, int columna, String tipo, String nombre) {
        this.Ambito = ambito;
        this.Parametros = parametro;
        this.Fila = fila;
        this.Columna = columna;
        this.Tipo = tipo;
        this.Nombre = nombre;
    }

    public void EjecutarInstrucciones() {

    }

    public void EjecutarPara() {
    }

    public void EjecutarSi() {
    }

    public void EjecutarSelecciona() {
    }

    public void EjecutarMientras() {
    }

    public void EjecutarRetorno() {
    }

    public void EjecutarTerminar() {
    }

    public void EjecutarContinuar() {
    }

    public void EjecutarMetodo() {
        
    }

    public void EjecutarDeclaracion(){
    }

    public void EjecutarAsignacion(){
    }   

    public void EjecutarMetodoImprimir() {
        
    }

    public void SacarAmbito(ArrayList<Simbolo> ambito) {
        
    }
}
