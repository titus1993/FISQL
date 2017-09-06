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
public class FPara {

    public String AccionSiguiente;
    public Simbolo AccionAnterior;
    public FNodoExpresion Condicion;
    public Ambito Ambito;

    public FPara(Simbolo anterior, FNodoExpresion condicion, String siguiente, Ambito ambito) {
        this.AccionAnterior = anterior;
        this.Condicion = condicion;
        this.AccionSiguiente = siguiente;
        this.Ambito = ambito;
    }

    public void EjecutarPara() {
        
    }
}
