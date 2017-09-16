/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;
import Static.Tools;
//import Interface.TitusNotificaciones;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FLlamadaVariable {

    public String Nombre, Objeto;
    public int Fila, Columna;

    public FLlamadaVariable(String nombre, String objeto, int fila, int columna) {
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;
        this.Objeto = objeto;
    }

    public String getCadena() {
        if (Objeto.equals("")) {
            return "@" + this.Nombre;
        } else {
            return "@" + this.Objeto + "." + this.Nombre;
        }
    }

    public Variable Ejecutar() {
        if (this.Objeto.equals("")) {
            return Tools.Tabla.BuscarVariable(Nombre);
        } else {
            Variable var = Tools.Tabla.BuscarVariable(Objeto);
            if (var != null) {
                FNodoExpresion val = (FNodoExpresion) var.Valor;

                if (val.Tipo.equals(Constante.TObjeto)) {
                    Variable atributo = val.Objeto.TablaVariables.BuscarVariable(Nombre);
                    if (atributo != null) {
                        return atributo;
                    } else {
                        Tools.InsertarError("Semantico", "No existe el atributo " + this.Nombre + "en el objeto " + this.Objeto, Fila, Columna);
                    }
                } else {
                    Tools.InsertarError("Semantico", "La variable " + this.Objeto + " no es un objeto", Fila, Columna);
                }
            } else {
                Tools.InsertarError("Semantico", "La variable " + this.Objeto + " no existe", Fila, Columna);
            }
        }
        return null;
    }
}
