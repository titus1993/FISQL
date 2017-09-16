/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Funciones.XML.*;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FCrearObjeto {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;
    ArrayList<Parametro> Parametros;

    public FCrearObjeto(String Nombre, ArrayList<Parametro> Parametros, Ambito ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Parametros = Parametros;
        this.Ambito = ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        Objeto obj = new Objeto(this.Nombre, this.Parametros);
        switch (Tools.Base_de_datos.DLLCrearObjeto(obj)) {
            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "El objeto " + this.Nombre + " ya existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                break;
                
            default:
                Tools.ImprimirLog("Crear Objeto", "Se creo el objeto " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                break;
        }        
    }

    public String getCadena() {
        String cadena = "";

        cadena = "CREAR OBJETO " + this.Nombre + "(";

        int i = 0;
        for (Parametro p : Parametros) {
            if (i == 0) {
                cadena += p.getCadena();
            } else {
                cadena += ", " + p.getCadena();
            }
        }
        
        cadena += ");";

        return cadena;
    }
}
