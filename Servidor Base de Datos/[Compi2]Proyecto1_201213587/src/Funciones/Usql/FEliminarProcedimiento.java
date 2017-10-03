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
public class FEliminarProcedimiento {
    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;

    public FEliminarProcedimiento(String Nombre, Ambito Ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        switch (Tools.Base_de_datos.DLLEliminarFuncionProcedimiento(Nombre)) {

            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "El procedimiento " + this.Nombre + " no existe o no tiene permisos para eliminarla de la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                break;
                
            default:
                Tools.ImprimirLog("Eliminar Procedimiento", "Se elimino el procedimiento " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                break;
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "ELIMINAR PROCEDIMIENTO " + this.Nombre;

        return cadena;
    }
}
