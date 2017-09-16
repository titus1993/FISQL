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
public class FEliminarUsuario {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;

    public FEliminarUsuario(String Nombre, Ambito Ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        switch (Tools.Base_de_datos.DLLEliminarUsuario(Nombre)) {

            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No existe el usuario  " + this.Nombre, Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para eliminar usuarios", Fila, Columna);
                break;

            case 3:
                Tools.InsertarError(Constante.TErrorSemantico, "No se puede eliminar al usuario administrador", Fila, Columna);
                break;

            default:
                Tools.ImprimirLog("Eliminar Usuario", "Se elimino al usuario " + this.Nombre);
                break;
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "ELIMINAR USUARIO " + this.Nombre;

        return cadena;
    }
}
