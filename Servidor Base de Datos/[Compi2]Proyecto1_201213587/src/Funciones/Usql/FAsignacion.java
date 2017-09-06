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
    public String Tipo;
    public FLlamadaObjeto Nombre;
    public FNodoExpresion Valor;

    public FAsignacion(String tipo, FLlamadaObjeto nombre, Ambito ambito, Object valor) {
        this.Ambito = ambito;
        this.Padre = null;
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Valor = (FNodoExpresion) valor;

    }

    public void EjecutarAsignacion() {
        
    }
}
