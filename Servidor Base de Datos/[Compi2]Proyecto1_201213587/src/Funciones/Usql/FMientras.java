/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import EjecucionUsql.*;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FMientras {

    public Ambito Ambito;
    public FNodoExpresion Condicion;

    public FMientras(FNodoExpresion condicion, Ambito ambito) {
        this.Ambito = ambito;
        this.Condicion = condicion;
    }

    public void EjecutarMientras() {
        
    }
}