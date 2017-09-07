/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import EjecucionUsql.*;
//import Interface.TitusNotificaciones;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FImprimir {

    public Ambito Ambito;
    public FNodoExpresion Valor;
    public int Fila, Columna;

    public FImprimir(FNodoExpresion valor) {
        this.Ambito = new Ambito(Constante.TImprimir, new ArrayList<Simbolo>());
        this.Valor = valor;
    }

    public void Imprimir() {
        
    }
}
