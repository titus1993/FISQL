/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.*;
import java.util.ArrayList;

import Static.*;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titus
 */
public class FNodoExpresion {

    public FNodoExpresion Izquierda, Derecha;
    public String Tipo, Nombre;
    public int Fila, Columna, Precedencia;
    public int Entero;
    public double Decimal;
    public String Cadena;
    public boolean Bool;
    public String Date, DateTime;
    public FLlamadaVariable Variable;
    public FObjeto Objeto;
    public FLlamadaMetodo Metodo;
    public FLlamadaTabla Tabla;
    public FNodoExpresion Col;

    public FNodoExpresion(FNodoExpresion nodo) {
        this.Izquierda = nodo.Izquierda;
        this.Derecha = nodo.Derecha;
        this.Bool = nodo.Bool;
        this.Cadena = nodo.Cadena;
        this.Columna = nodo.Columna;
        this.Decimal = nodo.Decimal;
        this.Entero = nodo.Entero;
        this.Fila = nodo.Fila;
        this.Nombre = nodo.Nombre;
        this.Tipo = nodo.Tipo;
        this.Date = nodo.Date;
        this.DateTime = nodo.DateTime;
        this.Precedencia = nodo.Precedencia;
        this.Objeto = nodo.Objeto;
    }

    public FNodoExpresion(FNodoExpresion izq, FNodoExpresion der, String tipo, String nombre, int fila, int columna, Object valor) {
        this.Izquierda = izq;
        this.Derecha = der;
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Fila = fila;
        this.Columna = columna;

        switch (tipo) {
            case Constante.TEntero:
                this.Entero = Integer.parseInt(valor.toString());
                this.Cadena = valor.toString();
                this.Precedencia = 1;
                break;

            case Constante.TDecimal:
                this.Decimal = Double.parseDouble(valor.toString());
                this.Cadena = valor.toString();
                this.Precedencia = 1;
                break;

            case Constante.TCadena:
                this.Cadena = (String) valor;
                this.Precedencia = 1;
                break;

            case Constante.TBool:

                this.Cadena = valor.toString();
                if (this.Cadena.equals(Constante.TVerdadero) || this.Cadena.equals("true")) {
                    this.Bool = true;
                    this.Entero = 1;
                    this.Decimal = 1;
                } else {
                    this.Bool = false;
                    this.Entero = 0;
                    this.Decimal = 0;
                }
                this.Precedencia = 1;
                break;

            case Constante.TDate:
                this.Date = valor.toString();
                this.Cadena = this.Date;
                this.Precedencia = 1;
                break;

            case Constante.TDateTime:
                this.DateTime = valor.toString();
                this.Cadena = this.DateTime;
                this.Precedencia = 1;
                break;

            case Constante.TObjeto:
                this.Objeto = (FObjeto)valor;
                this.Cadena = this.Objeto.Nombre;
                this.Precedencia = 1;
                break;
                
            case Constante.TMetodo:
                this.Metodo = (FLlamadaMetodo) valor;
                this.Precedencia = 1;
                break;

            case Constante.TVariable:
                this.Variable = (FLlamadaVariable) valor;
                this.Precedencia = 1;
                break;

            case Constante.TTabla:
                this.Tabla = (FLlamadaTabla) valor;
                this.Precedencia = 1;
                break;

            case Constante.TPotencia:
                this.Precedencia = 2;
                break;

            case Constante.TMenos:
                if (izq == null) {
                    this.Precedencia = 3;
                } else {
                    this.Precedencia = 5;
                }
                break;

            case Constante.TPor:
                this.Precedencia = 4;
                break;

            case Constante.TDivision:
                this.Precedencia = 4;
                break;

            case Constante.TMas:
                this.Precedencia = 5;
                break;

            case Constante.TMayor:
                this.Precedencia = 6;
                break;

            case Constante.TMenor:
                this.Precedencia = 6;
                break;

            case Constante.TMayorIgual:
                this.Precedencia = 6;
                break;

            case Constante.TMenorIgual:
                this.Precedencia = 6;
                break;

            case Constante.TIgualacion:
                this.Precedencia = 6;
                break;

            case Constante.TDiferenciacion:
                this.Precedencia = 6;
                break;

            case Constante.TNot:
                this.Precedencia = 7;
                break;

            case Constante.TAnd:
                this.Precedencia = 8;
                break;

            case Constante.TOr:
                this.Precedencia = 9;
                break;

        }
    }

    public String getCadena() {
        String cadena = "";
        cadena += getCadena(this);
        return cadena;
    }

    public String getCadena(FNodoExpresion nodo) {
        String cadena = "";
        String cadizq = "";
        String cadder = "";

        if (nodo.Izquierda != null) {
            cadizq = nodo.Izquierda.getCadena();
            if (nodo.Izquierda.Precedencia > nodo.Precedencia) {
                cadizq = "(" + cadizq + ")";
            }
        }

        if (nodo.Derecha != null) {
            cadder = nodo.Derecha.getCadena();
            if (nodo.Derecha.Precedencia > nodo.Precedencia) {
                cadder = "(" + cadder + ")";
            }
        }

        cadena = nodo.Tipo;
        switch (nodo.Tipo) {
            case Constante.TEntero:
                cadena = String.valueOf(nodo.Entero);
                break;

            case Constante.TDecimal:
                cadena = String.valueOf(nodo.Decimal);
                break;

            case Constante.TCadena:
                cadena = String.valueOf("\"" + nodo.Cadena + "\"");
                break;

            case Constante.TBool:
                if (this.Cadena.equals(Constante.TVerdadero) || this.Cadena.equals("true")) {
                    cadena = Constante.TVerdadero;
                } else {
                    cadena = Constante.TFalso;
                }
                break;

            case Constante.TDate:
                cadena = "'" + nodo.Date + "'";
                break;

            case Constante.TDateTime:
                cadena = "'" + nodo.DateTime + "'";
                break;

            case Constante.TMetodo:
                cadena = this.Metodo.getCadena();
                break;

            case Constante.TVariable:
                cadena = this.Variable.getCadena();
                break;

            case Constante.TTabla:
                
                break;
        }

        return cadizq + cadena + cadder;
    }

    public FNodoExpresion ResolverExpresion() {
        return ResolverExpresion(this);
    }

    private FNodoExpresion ResolverExpresion(FNodoExpresion nodo) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, nodo.Fila, nodo.Columna, null);
        FNodoExpresion izq = nodo.Izquierda;
        FNodoExpresion der = nodo.Derecha;
        if (nodo.Izquierda != null) {
            izq = nodo.Izquierda.ResolverExpresion();
        }

        if (nodo.Derecha != null) {
            der = nodo.Derecha.ResolverExpresion();
        }
        switch (nodo.Tipo) {
            case Constante.TMas:
                aux = Suma(izq, der);
                break;

            case Constante.TMenos:
                if (nodo.Izquierda != null) {
                    aux = Resta(izq, der);
                } else {
                    aux = Resta(der);
                }
                break;

            case Constante.TPor:
                aux = Multiplicacion(izq, der);
                break;

            case Constante.TDivision:
                aux = Division(izq, der);
                break;

            case Constante.TPotencia:
                aux = Potencia(izq, der);
                break;

            case Constante.TAumento:
                aux = Aumento(izq);
                break;

            case Constante.TDisminucion:
                aux = Disminucion(izq);
                break;

            case Constante.TMayor:
                aux = Mayor(izq, der);
                break;

            case Constante.TMenor:
                aux = Menor(izq, der);
                break;

            case Constante.TMayorIgual:
                aux = MayorIgual(izq, der);
                break;

            case Constante.TMenorIgual:
                aux = MenorIgual(izq, der);
                break;

            case Constante.TIgualacion:
                aux = Igual(izq, der);
                break;

            case Constante.TDiferenciacion:
                aux = Diferente(izq, der);
                break;

            case Constante.TOr:
                aux = Or(izq, der);
                break;

            case Constante.TAnd:
                aux = And(izq, der);
                break;

            case Constante.TNot:
                aux = Not(der);
                break;

            case Constante.TEntero:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TDecimal:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TCadena:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TBool:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TDate:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TDateTime:
                aux = new FNodoExpresion(nodo);
                break;

            case Constante.TVariable:{
                FLlamadaVariable llamada = this.Variable;
                Variable valor = llamada.Ejecutar();
                if (valor != null) {
                    if(valor.Valor != null){
                        aux = (FNodoExpresion) valor.Valor;
                    }else{
                        Tools.InsertarError("Semantico", "La variable devolvio un valor nulo", Fila, Columna);
                    }
                }
                break;
            }
            case Constante.TLlamadaMetodo:{                
                Variable valor = this.Metodo.EjecutarLlamadaMetodo();
                if (valor != null) {
                    aux = (FNodoExpresion) valor.Valor;
                }
                break;
            }
            case Constante.TMetodo:{                
                Variable valor = this.Metodo.EjecutarLlamadaMetodo();
                if (valor != null) {
                    aux = (FNodoExpresion) valor.Valor;
                }
                break;
            }
            
            case Constante.TTabla:
                FNodoExpresion val = this.Tabla.Ejecutar();
                if(val != null){
                    aux = val;
                }
                break;
        }
        return aux;
    }

    public FNodoExpresion Suma(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero + der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero + der.Decimal);

                        break;

                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, String.valueOf(izq.Entero) + der.Cadena);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero + der.Entero);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal + der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal + der.Decimal);

                        break;

                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, String.valueOf(izq.Decimal) + der.Cadena);
                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal + der.Entero);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TCadena:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + String.valueOf(der.Entero));
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + String.valueOf(der.Decimal));
                        break;

                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + der.Cadena);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + der.Date);
                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + der.DateTime);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero + der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero + der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Bool || der.Bool);

                        break;

                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Cadena + der.Cadena);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Date + der.Cadena);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.DateTime + der.Cadena);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Resta(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero - der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero - der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero - der.Entero);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal - der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal - der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal - der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero - der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero - der.Decimal);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Resta(FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (der.Tipo) {
            case Constante.TEntero:
                aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, -der.Entero);
                break;

            case Constante.TDecimal:
                aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, -der.Decimal);

                break;

            case Constante.TBool:
                aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, -der.Entero);
                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede -, " + der.Tipo, Fila, Columna);
                break;
        }
        return aux;
    }

    public FNodoExpresion Multiplicacion(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero * der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero * der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero * der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal * der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal * der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal * der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero * der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero * der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Bool && der.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Division(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero / der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero / der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero / der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal / der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal / der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal / der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero / der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Entero / der.Decimal);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Potencia(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        double p = Math.pow(izq.Entero, der.Entero);
                        int v = (int) p;
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, v);

                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, Math.pow(izq.Entero, der.Decimal));

                        break;

                    case Constante.TBool:
                        double pb = Math.pow(izq.Entero, der.Entero);
                        int vb = (int) pb;
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, vb);
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, Math.pow(izq.Decimal, der.Entero));
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, Math.pow(izq.Decimal, der.Decimal));

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, Math.pow(izq.Decimal, der.Entero));

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        double p = Math.pow(izq.Entero, der.Entero);
                        int v = (int) p;
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, v);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, Math.pow(izq.Entero, der.Decimal));

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Aumento(FNodoExpresion izq) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero + 1);
                break;

            case Constante.TDecimal:
                aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal + 1);
                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede ++, " + izq.Tipo, Fila, Columna);
                break;

        }
        return aux;
    }

    public FNodoExpresion Disminucion(FNodoExpresion izq) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero - 1);
                break;

            case Constante.TDecimal:
                aux = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, Fila, Columna, izq.Decimal - 1);
                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede ++, " + izq.Tipo, Fila, Columna);
                break;

        }
        return aux;
    }

    public FNodoExpresion Mayor(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero > der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero > der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero > der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal > der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal > der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal > der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero > der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero > der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero > der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TDate: {
                        String cadi = izq.Date + " 00:00:00";
                        String cadd = der.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(cadd);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    case Constante.TDateTime: {
                        String cadi = izq.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(der.DateTime);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TDate: {
                        String cadi = izq.DateTime;
                        String cadd = der.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(cadd);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    case Constante.TDateTime: {

                        try {
                            Date di = Tools.formatoFecha.parse(izq.DateTime);
                            Date dd = Tools.formatoFecha.parse(der.DateTime);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Menor(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero < der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero < der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero < der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal < der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal < der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal < der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero < der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero < der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero < der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TDate: {
                        String cadi = izq.Date + " 00:00:00";
                        String cadd = der.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(cadd);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    case Constante.TDateTime: {
                        String cadi = izq.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(der.DateTime);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.after(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TDate: {
                        String cadi = izq.DateTime;
                        String cadd = der.Date + " 00:00:00";

                        try {
                            Date di = Tools.formatoFecha.parse(cadi);
                            Date dd = Tools.formatoFecha.parse(cadd);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.before(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    case Constante.TDateTime: {

                        try {
                            Date di = Tools.formatoFecha.parse(izq.DateTime);
                            Date dd = Tools.formatoFecha.parse(der.DateTime);
                            aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, di.before(dd));
                        } catch (ParseException ex) {
                            Logger.getLogger(FNodoExpresion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Igual(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero == der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero == der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero == der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal == der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal == der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal == der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TCadena:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Date));

                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.DateTime));

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero == der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero == der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Bool == der.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Date));

                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, (izq.Date + " 00:00:00").equals(der.DateTime));

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.Date + " 00:00:00"));

                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.DateTime));

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion Diferente(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TEntero:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero != der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero != der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, Fila, Columna, izq.Entero != der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDecimal:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal != der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal != der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Decimal != der.Entero);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TCadena:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Cadena.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Cadena.equals(der.Date));
                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Cadena.equals(der.DateTime));
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TEntero:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero != der.Entero);
                        break;

                    case Constante.TDecimal:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Entero != der.Decimal);

                        break;

                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Bool != der.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Date.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Date.equals(der.Date));
                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !(izq.Date + " 00:00:00").equals(der.DateTime));
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.Date + " 00:00:00"));
                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.DateTime));
                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

        }
        return aux;
    }

    public FNodoExpresion MayorIgual(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);
        FNodoExpresion mayor = Mayor(izq, der);
        FNodoExpresion igual = Igual(izq, der);

        switch (mayor.Tipo) {
            case Constante.TBool:
                switch (igual.Tipo) {
                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, mayor.Bool || igual.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede >=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public FNodoExpresion MenorIgual(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);
        FNodoExpresion menor = Menor(izq, der);
        FNodoExpresion igual = Igual(izq, der);

        switch (menor.Tipo) {
            case Constante.TBool:
                switch (igual.Tipo) {
                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, menor.Bool || igual.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede <=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;
        }
        return aux;
    }

    public FNodoExpresion Or(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Bool || der.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede ||, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede ||, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                break;
        }
        return aux;
    }

    public FNodoExpresion And(FNodoExpresion izq, FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (izq.Tipo) {
            case Constante.TBool:
                switch (der.Tipo) {
                    case Constante.TBool:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Bool && der.Bool);

                        break;

                    default:
                        Tools.InsertarError(Constante.TError, "No se puede &&, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede &&, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                break;
        }
        return aux;
    }

    public FNodoExpresion Not(FNodoExpresion der) {
        FNodoExpresion aux = new FNodoExpresion(null, null, Constante.TError, Constante.TError, Fila, Columna, null);

        switch (der.Tipo) {
            case Constante.TBool:
                aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !der.Bool);

                break;

            default:
                Tools.InsertarError(Constante.TError, "No se puede !, " + der.Tipo, Fila, Columna);
                break;
        }

        return aux;
    }
}
