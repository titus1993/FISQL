/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Static.Constante;
import Static.Tools;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class FFecha {
    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;

    public FFecha(int Fila, int Columna) {
        this.Ambito = new Ambito(Constante.TFecha);
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    
    public FNodoExpresion Ejecutar(){
        FNodoExpresion temp = new FNodoExpresion(null, null, Constante.TDate, Constante.TDate, Fila, Columna, Tools.formatoFecha.format(new Date()).substring(0, 10));
        
        return temp;
    }
}
