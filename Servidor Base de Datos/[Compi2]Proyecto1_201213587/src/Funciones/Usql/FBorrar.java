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
public class FBorrar {

    public FNodoExpresion Condicion;
    public String Tabla;
    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;

    public FBorrar(String Tabla, FNodoExpresion Condicion, Ambito Ambito, int Fila, int Columna) {
        this.Tabla = Tabla;
        this.Condicion = Condicion;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        //llenar tablas
        if (Tools.BaseActual != null) {
            TablaSeleccionar Selects = new TablaSeleccionar();
            TablaSeleccionar Resultado = new TablaSeleccionar();

            //buscar las tablas e ingresarlas a la estructura temporal
            Tabla tabla = Tools.BaseActual.ExisteTabla(Tabla);
            if (tabla != null) {
                Selects.IngresarNuevaTabla(tabla);
                Resultado.IngresarNuevaTabla(tabla);
            } else {
                Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + Tabla + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
            }

            if (Tools.ContarErrores()) {
                Tools.TablaPivote = Selects;
                Resultado.LimpiarDatos();

                Tools.TablaPivote.pos = Selects.getSize() - 1;
                for (int i = Selects.getSize() - 1; i >= 0; i--) {
                    FNodoExpresion estado = this.Condicion.ResolverExpresion();
                    if (estado.Tipo.equals(Constante.TBool)) {
                        if (estado.Bool) {
                            tabla.BorrarFila(i);
                        }
                    } else {
                        //error de tipo bool
                    }
                    Tools.TablaPivote.pos--;
                }
                Tools.TablaPivote = null;
                Tools.ImprimirLog("Borrar Tabla", "Se borraron datos en la tabla " + this.Tabla + " en la base de datos " + Tools.BaseActual.Nombre);
                Tools.Base_de_datos.Guardar();
            }

        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
        }
    }

    public String getCadena() {
        String cadena = "";

        cadena += "BORRAR EN TABLA " + this.Tabla;


        cadena += " DONDE " + this.Condicion.getCadena();

        return cadena;
    }
}
