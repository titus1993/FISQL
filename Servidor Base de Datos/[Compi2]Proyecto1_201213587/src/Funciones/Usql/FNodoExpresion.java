/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import java.util.ArrayList;

import Static.Constante;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class FNodoExpresion {

    public FNodoExpresion Izquierda, Derecha;
    public String Tipo, Nombre;
    public int Fila, Columna;
    public int Entero;
    public double Decimal;
    public String Cadena;
    public boolean Bool;
    public String Date, DateTime;
    //public FLlamadaObjeto Objeto;
    //public Objeto Obj;
    //public FLlamadaMetodo Metodo;
    //public FNodoArreglo Arreglo;
    //public Arreglo ArregloResuelto;
    //public FNodoExpresion PosArreglo;
    //public FNodoExpresion Col;

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
                break;

            case Constante.TDecimal:
                this.Decimal = Double.parseDouble(valor.toString());
                this.Cadena = valor.toString();

                break;

            case Constante.TCadena:
                this.Cadena = (String) valor;
                break;

            case Constante.TBool:

                this.Cadena = valor.toString();
                if (this.Cadena.equals(Constante.TVerdadero)) {
                    this.Entero = 1;
                    this.Decimal = 1;
                } else {
                    this.Entero = 0;
                    this.Decimal = 0;
                }
                break;

            case Constante.TDate:
                this.Date = valor.toString();
                break;

            case Constante.TDateTime:
                this.DateTime = valor.toString();
                break;

        }
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

            case Constante.TCaracter:
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDate:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.Date + der.Cadena);
                        break;

                    default:
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, Fila, Columna, izq.DateTime + der.Cadena);
                        break;

                    default:
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede +, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede -, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede -, " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede *, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede /, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ^, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ++, " + izq.Tipo, Fila, Columna);
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
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ++, " + izq.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede >, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede <, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, izq.Cadena.equals(der.DateTime));

                        break;

                    default:
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ==, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.Date.equals(der.DateTime));
                        break;

                    default:
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            case Constante.TDateTime:
                switch (der.Tipo) {
                    case Constante.TCadena:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.Cadena));
                        break;

                    case Constante.TDate:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.Date));
                        break;

                    case Constante.TDateTime:
                        aux = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, Fila, Columna, !izq.DateTime.equals(der.DateTime));
                        break;

                    default:
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede >=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede <=, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ||, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede ||, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                        //TitusNotificaciones.InsertarError(Constante.TError, "No se puede &&, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
                        break;
                }
                break;

            default:
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede &&, " + izq.Tipo + " con " + der.Tipo, Fila, Columna);
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
                //TitusNotificaciones.InsertarError(Constante.TError, "No se puede !, " + der.Tipo, Fila, Columna);
                break;
        }

        return aux;
    }    
}
