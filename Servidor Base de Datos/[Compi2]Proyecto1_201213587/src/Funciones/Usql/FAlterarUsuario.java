/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Funciones.XML.ColumnaEstructura;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FAlterarUsuario {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre, Pass;
    public int Fila, Columna;

    public FAlterarUsuario(String Nombre, String Pass, Ambito Ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
        this.Pass = Pass;
    }

    public void Ejecutar() {
        switch (Tools.Base_de_datos.DLLAlterUsuario(this.Nombre, this.Pass)) {            

            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "No existe el usuario  " + this.Nombre, Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para alterar usuario", Fila, Columna);
                break;

            default:
                Tools.ImprimirLog("Alterar Usuario", "Se cambio la contraseña al usuario " + this.Nombre + " a \"" + this.Pass + "\"");
                break;
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "ALTERAR USUARIO " + this.Nombre + " CAMBIAR PASSWORD = \"" + this.Pass + "\"";

        return cadena;
    }
}
