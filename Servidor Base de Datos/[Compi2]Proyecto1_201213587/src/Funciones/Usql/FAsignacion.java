/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import EjecucionUsql.*;
//import Interface.TitusNotificaciones;

/**
 *
 * @author Titus
 */
public class FAsignacion {

    public Ambito Ambito;
    public Ambito Padre;
    public FLlamadaVariable Nombre;
    public FNodoExpresion Valor;
    public int Fila, Columna;

    public FAsignacion(FLlamadaVariable nombre, Ambito ambito, Object valor, int Fila, int Columna) {
        this.Ambito = ambito;
        this.Padre = null;
        this.Nombre = nombre;
        this.Valor = (FNodoExpresion) valor;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public String getCadena() {
        String cadena = "";

        cadena += Nombre.getCadena() + " = " + Valor.getCadena();

        return cadena;
    }

    public void EjecutarAsignacion() {

        Variable nuevavariable;
        if (Valor != null) {
            FNodoExpresion exp = (FNodoExpresion) Valor;
            exp = exp.ResolverExpresion();

            //comprobamos si hay errores
            if (Tools.ContarErrores()) {
                //comprobar si es un nuevo objeto

                nuevavariable = Nombre.Ejecutar();///////////////////--->casteo

                if (nuevavariable != null) {

                    //hacemos el casteo implicito
                    switch (nuevavariable.Tipo) {
                        case Constante.TEntero:
                            switch (exp.Tipo) {
                                case Constante.TEntero:
                                    break;

                                case Constante.TBool:
                                    exp.Entero = exp.Entero;
                                    exp.Tipo = Constante.TEntero;
                                    break;

                                default:
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
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
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
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

                                case Constante.TDate:
                                    exp.Cadena = exp.Date;
                                    exp.Tipo = Constante.TCadena;
                                    break;

                                case Constante.TDateTime:
                                    exp.Cadena = exp.DateTime;
                                    exp.Tipo = Constante.TCadena;
                                    break;

                                default:
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
                                    break;
                            }
                            break;

                        case Constante.TBool:
                            switch (exp.Tipo) {
                                case Constante.TBool:
                                    break;

                                default:
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
                                    break;

                            }
                            break;

                        case Constante.TDate:
                            switch (exp.Tipo) {
                                case Constante.TDate:
                                    break;

                                default:
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
                                    break;

                            }
                            break;

                        case Constante.TDateTime:
                            switch (exp.Tipo) {
                                case Constante.TDateTime:
                                    break;

                                case Constante.TDate:
                                    exp.Tipo = Constante.TDateTime;
                                    exp.DateTime = exp.Date + " 00:00:00";
                                    break;

                                default:
                                    Tools.InsertarError(Constante.TErrorSintactico, "No se puede asignar un tipo " + exp.Tipo + " a " + nuevavariable.Tipo, Fila, Columna);
                                    break;

                            }
                            break;

                        default:
                            if (nuevavariable.Tipo.equals(exp.Nombre)) {
                                
                            } else {
                                Tools.InsertarError(Constante.TErrorSemantico, "No se puede asignar un tipo " + exp.Tipo + " a un tipo " + nuevavariable.Tipo, Fila, Columna);
                            }

                            break;

                    }

                    nuevavariable.Valor = exp;//--------------------------------------hacer casteo

                } else {
                    Tools.InsertarError(Constante.TErrorSemantico, "No existe la variable " + this.Nombre.Nombre, Fila, Columna);
                }
            }
        }

    }
}
