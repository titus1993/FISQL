/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Funciones.XML.ColumnaEstructura;
import Funciones.XML.Parametro;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FAlterarObjeto {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    String Tipo;
    public int Fila, Columna;
    ArrayList<Parametro> Campos;

    public FAlterarObjeto(String Tipo, String Nombre, Ambito Ambito, ArrayList<Parametro> Campos, int Fila, int Columna) {
        this.Tipo = Tipo;
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Campos = Campos;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        if (Tipo.equals(Constante.TAgregar)) {
            switch (Tools.Base_de_datos.DLLAlterObjetoAgregar(this.Nombre, this.Campos)) {
                case 1:
                    Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                    break;

                case 2:
                    Tools.InsertarError(Constante.TErrorSemantico, "No existe el objeto " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 3:
                    Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para alterar el objeto " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 4:
                    Tools.InsertarError(Constante.TErrorSemantico, "Ya existe un campo en el objeto llamado " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                default:
                    Tools.ImprimirLog("Alterar Objeto", "Se agregaron nuevo campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                    break;
            }
        } else {
            switch (Tools.Base_de_datos.DLLAlterObjetoQuitar(this.Nombre, this.Campos)) {
                case 1:
                    Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                    break;

                case 2:
                    Tools.InsertarError(Constante.TErrorSemantico, "No existe el objeto " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 3:
                    Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para alterar el objeto " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 4:
                    Tools.InsertarError(Constante.TErrorSemantico, "Ya existe un campo en el objeto llamado " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                default:
                    Tools.ImprimirLog("Alterar Objeto", "Se eliminaron campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                    break;
            }
        }
    }

    public String getCadena() {
        String cadena = "";

        if (this.Tipo.equals(Constante.TAgregar)) {
            cadena += "ALTERAR OBJETO " + this.Nombre + " AGREGAR (";

            int i = 0;
            for (Parametro col : Campos) {
                if (i == 0) {
                    cadena += col.tipo + " " + col.nombre;
                } else {
                    cadena += ", " + col.tipo + " " + col.nombre;

                }
                i++;
            }
            cadena += ")";
        } else {
            cadena += "ALTERAR OBJETO " + this.Nombre + " QUITAR ";

            int i = 0;
            for (Parametro col : Campos) {
                if (i == 0) {
                    cadena += col.nombre;
                } else {
                    cadena += ", " + col.nombre;
                }
                i++;
            }
        }

        cadena += ";\n";

        return cadena;
    }
}
