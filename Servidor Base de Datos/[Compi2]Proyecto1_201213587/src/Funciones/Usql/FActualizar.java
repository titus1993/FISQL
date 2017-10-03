/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import EjecucionUsql.TablaSeleccionar;
import Funciones.XML.ColumnaEstructura;
import Funciones.XML.Tabla;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FActualizar {

    public ArrayList<ColumnaEstructura> Columnas;
    public ArrayList<FNodoExpresion> Valores;
    public FNodoExpresion Condicion;

    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;
    public String Tabla;

    public FActualizar(String Tabla, ArrayList<ColumnaEstructura> Columnas, ArrayList<FNodoExpresion> Valores, FNodoExpresion Condicion, Ambito Ambito, int Fila, int Columna) {
        this.Columna = Columna;
        this.Columnas = Columnas;
        this.Condicion = Condicion;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Tabla = Tabla;
        this.Valores = Valores;
    }

    public void Ejecutar() {
        if (Tools.BaseActual != null) {
            if (Valores.size() == Columnas.size()) {
                ArrayList<FNodoExpresion> valores = new ArrayList<>();
                for (FNodoExpresion ne : this.Valores) {
                    valores.add(ne.ResolverExpresion());
                }
                if (Tools.ContarErrores()) {
                    Tabla tabla = Tools.BaseActual.ExisteTabla(Tabla);
                    if (tabla != null) {
                        TablaSeleccionar Selects = new TablaSeleccionar();
                        Selects.IngresarNuevaTabla(tabla);
                        Tools.TablaPivote = Selects;
                        for (int i = 0; i < Selects.getSize(); i++) {
                            FNodoExpresion cond = Condicion.ResolverExpresion();

                            if (cond.Tipo.equals(Constante.TBool)) {
                                if (cond.Bool) {
                                    tabla.Actualizar(this.Columnas, valores, Selects.pos);
                                }
                            } else {

                            }

                            Selects.pos++;
                        }
                        Tools.ImprimirLog("Actualizar Tabla", "Se actualizaron datos en la tabla " + this.Tabla + " en la base de datos " + Tools.BaseActual.Nombre);
                        Tools.Base_de_datos.Guardar();
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + this.Tabla + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    }
                }
            }
        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
        }
    }

    public String getCadena() {
        String cadena = "";

        cadena += "ACTUALIZAR TABLA " + this.Tabla + "(";

        int j = 0;
        for (ColumnaEstructura c : this.Columnas) {
            if (j == 0) {
                cadena += c.getCadenaInsertar();
            } else {
                cadena += ", " + c.getCadenaInsertar();
            }
            j++;
        }
        
        cadena += ") VALORES(";
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
        
        if(this.Condicion.Bool == false){
            cadena += " DONDE " + this.Condicion.getCadena();
        }

        return cadena;
    }
}
