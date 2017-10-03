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
public class FFechaHora {
    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;

    public FFechaHora(int Fila, int Columna) {
        this.Ambito = new Ambito(Constante.TFecha);
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    
    public FNodoExpresion Ejecutar(){
        FNodoExpresion temp = new FNodoExpresion(null, null, Constante.TDateTime, Constante.TDateTime, Fila, Columna, Tools.formatoFecha.format(new Date()));
        
        return temp;
    }
}
