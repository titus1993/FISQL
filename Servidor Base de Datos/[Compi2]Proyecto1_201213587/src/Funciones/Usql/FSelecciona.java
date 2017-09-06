/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import java.util.ArrayList;
import EjecucionUsql.*;
//import Interface.TitusNotificaciones;

/**
 *
 * @author Titus
 */
public class FSelecciona {

    public ArrayList<FCaso> Casos;
    public Ambito Ambito;
    public FCaso Defecto;
    public FNodoExpresion Condicion;

    public FSelecciona(FNodoExpresion condicion, ArrayList<FCaso> casos, FCaso defecto, Ambito ambito) {
        this.Casos = casos;
        this.Defecto = defecto;
        this.Ambito = ambito;
        this.Condicion = condicion;
    }

    public void EjecutarSelecciona() {
        
    }
}
