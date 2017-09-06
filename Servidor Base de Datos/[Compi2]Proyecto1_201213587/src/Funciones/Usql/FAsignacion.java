/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;
//import Interface.TitusNotificaciones;

/**
 *
 * @author Titus
 */
public class FAsignacion {

    public Ambito Ambito;
    public Ambito Padre;
    public FLlamadaVariable Nombre;
    public FNodoExpresion Valor;

    public FAsignacion(FLlamadaVariable nombre, Ambito ambito, Object valor) {
        this.Ambito = ambito;
        this.Padre = null;
        this.Nombre = nombre;
        this.Valor = (FNodoExpresion) valor;

    }

    public void EjecutarAsignacion() {
        
    }
}
