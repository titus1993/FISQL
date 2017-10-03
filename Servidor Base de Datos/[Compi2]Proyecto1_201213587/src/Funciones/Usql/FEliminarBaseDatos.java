/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Static.Constante;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class FEliminarBaseDatos {
    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;

    public FEliminarBaseDatos(String Nombre, Ambito Ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        switch (Tools.Base_de_datos.DLLEliminarBaseDatos(Nombre)) {

            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No tiene permisos para elliminar una base de datos, solo el administrador puede.", Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "No existe la base de datos " + this.Nombre, Fila, Columna);
                break;
                
            default:
                Tools.ImprimirLog("Eliminar Base de Datos", "Se elimino la base de datos " + this.Nombre);
                break;
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "ELIMINAR BASE_DATOS " + this.Nombre;

        return cadena;
    }
}
