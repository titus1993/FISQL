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
public class FAlterarTabla {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    String Tipo;
    public int Fila, Columna;
    ArrayList<ColumnaEstructura> Campos;

    public FAlterarTabla(String Tipo, String Nombre, Ambito Ambito, ArrayList<ColumnaEstructura> Campos, int Fila, int Columna) {
        this.Tipo = Tipo;
        this.Nombre = Nombre;
        this.Ambito = Ambito;
        this.Campos = Campos;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        if (Tipo.equals(Constante.TAgregar)) {
            switch (Tools.Base_de_datos.DLLAlterTableAgregar(this.Nombre, this.Campos)) {
                case 1:
                    Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                    break;

                case 2:
                    Tools.InsertarError(Constante.TErrorSemantico, "No existe la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 3:
                    Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para alterar la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 4:
                    Tools.InsertarError(Constante.TErrorSemantico, "Ya existe una llave primaria en la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 5:
                    Tools.InsertarError(Constante.TErrorSemantico, "Campo repetido en la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 6:
                    Tools.InsertarError(Constante.TErrorSemantico, "No se puede agregar campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre + " porque no existe llave primaria en la tabla de referencia", Fila, Columna);
                    break;

                case 7:
                    Tools.InsertarError(Constante.TErrorSemantico, "No se puede agregar campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre + " porque no existe la tabla de referencia", Fila, Columna);
                    break;

                default:
                    Tools.ImprimirLog("Alterar Tabla", "Se agregaron nuevo campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                    break;
            }
        } else {
            switch (Tools.Base_de_datos.DLLAlterTableQuitar(this.Nombre, this.Campos)) {
                case 1:
                    Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                    break;

                case 2:
                    Tools.InsertarError(Constante.TErrorSemantico, "No existe la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 3:
                    Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + Tools.Usuario.name + ", no tiene permios para alterar la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 4:
                    Tools.InsertarError(Constante.TErrorSemantico, "No se puede eliminar un campo que sea llave primaria en la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                default:
                    Tools.ImprimirLog("Alterar Tabla", "Se eliminaron campos a la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                    break;
            }
        }
    }

    public String getCadena() {
        String cadena = "";

        if (this.Tipo.equals(Constante.TAgregar)) {
            cadena += "ALTERAR TABLA " + this.Nombre + " AGREGAR (";

            int i = 0;
            for (ColumnaEstructura col : Campos) {
                if (i == 0) {
                    cadena += col.TipoCampo + " " +col.NombreCampo;
                    if (col.Complementos.isAutoincrementable) {
                        cadena += " AUTOINCREMENTABLE";
                    }

                    if (col.Complementos.isForanea) {
                        cadena += " LLAVE_FORANEA " + col.Complementos.Foranea;
                    }

                    if (col.Complementos.isNulo) {
                        cadena += " NO NULO";
                    }

                    if (col.Complementos.isPrimary) {
                        cadena += " LLAVE_PRIMARIA";
                    }
                } else {
                    cadena += ", " + col.TipoCampo + " " + col.NombreCampo;

                    if (col.Complementos.isAutoincrementable) {
                        cadena += " AUTOINCREMENTABLE";
                    }

                    if (col.Complementos.isForanea) {
                        cadena += " LLAVE_FORANEA " + col.Complementos.Foranea;
                    }

                    if (col.Complementos.isNulo) {
                        cadena += " NO NULO";
                    }

                    if (col.Complementos.isPrimary) {
                        cadena += " LLAVE_PRIMARIA";
                    }
                }
                i++;
            }
            cadena += ")";
        } else {
            cadena += "ALTERAR TABLA " + this.Nombre + " QUITAR ";

            int i = 0;
            for (ColumnaEstructura col : Campos) {
                if (i == 0) {
                    cadena += col.NombreCampo;
                } else {
                    cadena += ", " + col.NombreCampo;
                }
                i++;
            }
        }

        cadena += ";\n";

        return cadena;
    }

}
