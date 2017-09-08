/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.Constante;
import EjecucionUsql.*;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class FDeclaracion {

    public Ambito Ambito;
    public Ambito Padre;
    public String Tipo, Nombre;
    public FNodoExpresion Valor;
    public int Fila, Columna;

    public FDeclaracion(String tipo, String nombre, Ambito ambito, Object valor, int fila, int columna) {
        this.Ambito = ambito;
        this.Padre = null;
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;
        this.Valor = (FNodoExpresion) valor;
    }

    public void EjecutarDeclaracion() {
        Variable nuevavariable;
        if (Valor != null) {
            FNodoExpresion exp = (FNodoExpresion) Valor;
            exp = exp.ResolverExpresion();

            if (Tools.ContarErrores()) {
                switch (Tipo) {
                    case Constante.TEntero:
                        switch (exp.Tipo) {
                            case Constante.TEntero:
                                break;

                            case Constante.TBool:
                                exp.Entero = exp.Entero;
                                exp.Tipo = Constante.TEntero;
                                break;

                            default:
                                Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + Tipo, Fila, Columna);
                                break;
                        }
                        break;

                    case Constante.TDecimal:
                        switch (exp.Tipo) {
                            case Constante.TDecimal:
                                break;

                            case Constante.TEntero:
                                exp.Decimal = exp.Entero;
                                exp.Tipo = Constante.TDecimal;
                                break;

                            case Constante.TBool:
                                exp.Decimal = exp.Entero;
                                exp.Tipo = Constante.TDecimal;
                                break;

                            default:
                                Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + Tipo, Fila, Columna);
                                break;
                        }
                        break;

                    case Constante.TCadena:
                        switch (exp.Tipo) {
                            case Constante.TEntero:
                                exp.Cadena = String.valueOf(exp.Entero);
                                exp.Tipo = Constante.TCadena;
                                break;

                            case Constante.TBool:
                                exp.Cadena = String.valueOf(exp.Entero);
                                exp.Tipo = Constante.TCadena;
                                break;

                            case Constante.TDecimal:
                                exp.Cadena = String.valueOf(exp.Decimal);
                                exp.Tipo = Constante.TCadena;
                                break;

                            case Constante.TCadena:
                                break;

                            default:
                                Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + Tipo, Fila, Columna);
                                break;
                        }
                        break;

                    case Constante.TBool:
                        switch (exp.Tipo) {
                            case Constante.TBool:
                                break;

                            default:
                                Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + Tipo, Fila, Columna);
                                break;

                        }
                        break;

                    default:

                        Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + Tipo, Fila, Columna);

                        break;

                }

                nuevavariable = new Variable(Tipo, Nombre, Constante.TVariable, Fila, Columna, Ambito, exp);
                Tools.Tabla.InsertarVariable(nuevavariable);
            }
        } else {
            nuevavariable = new Variable(Tipo, Nombre, Constante.TVariable, Fila, Columna, Ambito, null);
            Tools.Tabla.InsertarVariable(nuevavariable);
        }
    }
}
