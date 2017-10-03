/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Funciones.XML.ColumnaEstructura;
import Funciones.XML.Tabla;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FCrearTabla {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;
    ArrayList<ColumnaEstructura> Campos;

    public FCrearTabla(String Nombre, Ambito Ambito, ArrayList<ColumnaEstructura> Campos, int Fila, int Columna) {
        this.Padre = null;
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
        this.Campos = Campos;
    }

    public void Ejecutar() {
        Tabla tabla = new Tabla(this.Nombre, "", "0", Campos);
        switch (Tools.Base_de_datos.DLLCrearTabla(tabla)) {
            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + this.Nombre + " ya existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                break;
                
            default:
                Tools.ImprimirLog("Crear Tabla", "Se creo la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                break;
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "CREAR TABLA " + this.Nombre + "(";

        int i = 0;
        for (ColumnaEstructura col : Campos) {
            if (i == 0) {
                cadena += "\n\t" + col.getCadena();
            } else {
                cadena += ",\n\t" + col.getCadena();
            }
            i++;
        }

        cadena += "\n)";

        return cadena;
    }
}
