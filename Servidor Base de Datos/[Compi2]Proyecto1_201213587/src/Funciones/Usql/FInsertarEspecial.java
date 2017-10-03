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
public class FInsertarEspecial {

    public Ambito Ambito;
    public Ambito Padre;
    String Nombre;
    public int Fila, Columna;
    ArrayList<ColumnaEstructura> Columnas;
    ArrayList<FNodoExpresion> Valores;

    public FInsertarEspecial(String Nombre, ArrayList<ColumnaEstructura> Columnas, ArrayList<FNodoExpresion> Valores, Ambito Ambito, int Fila, int Columna) {
        this.Nombre = Nombre;
        this.Columnas = Columnas;
        this.Valores = Valores;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        ArrayList<FNodoExpresion> resueltos = new ArrayList<>();

        for (FNodoExpresion nodo : Valores) {
            resueltos.add(nodo.ResolverExpresion());
        }

        if (this.Columnas.size() == this.Valores.size()) {
            switch (Tools.Base_de_datos.DMLInsertarTablaEspecial(Nombre, this.Columnas, resueltos)) {
                case 1:
                    Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
                    break;

                case 2:
                    Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + this.Nombre + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    break;

                case 3:
                    Tools.InsertarError(Constante.TErrorSemantico, "No coincden el tipo de dato a insertar", Fila, Columna);
                    break;

                case 4:
                    Tools.InsertarError(Constante.TErrorSemantico, "Se debe registrar un valor a la columna primaria", Fila, Columna);
                    break;

                case 5:
                    Tools.InsertarError(Constante.TErrorSemantico, "Existen campos no nulos que deben llevar un valor", Fila, Columna);
                    break;

                case 6:
                    Tools.InsertarError(Constante.TErrorSemantico, "No se puede insertar un valor a un campo autoincrementable", Fila, Columna);
                    break;

                default:
                    Tools.ImprimirLog("Insertar Tabla", "Se insertaron los registro correctamente en la tabla " + this.Nombre + " en la base de datos " + Tools.BaseActual.Nombre);
                    break;
            }
        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No coinciden la cantidad de campos y valores a insertar", Fila, Columna);
        }

    }

    public String getCadena() {
        String cadena = "";

        cadena += "INSERTAR EN TABLA " + this.Nombre + "(";

        int j = 0;

        for (ColumnaEstructura ce : Columnas) {
            if (j == 0) {
                cadena += ce.getCadenaInsertar();
            } else {
                cadena += "," + ce.getCadenaInsertar();
            }
            j++;
        }

        cadena += ") VALORES (";

        int i = 0;
        for (FNodoExpresion n : Valores) {
            if (i == 0) {
                cadena += n.getCadena();
            } else {
                cadena += ", " + n.getCadena();
            }
            i++;
        }

        cadena += ")";

        return cadena;
    }

}
