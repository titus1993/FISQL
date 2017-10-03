/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import EjecucionUsql.TablaSeleccionar;
import Funciones.XML.*;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FSeleccionar {

    public ArrayList<FLlamadaTabla> Select;
    public String Tipo;
    public ArrayList<ColumnaEstructura> From;
    public FNodoExpresion Condicion;
    public FLlamadaTabla Ordenar;
    public String TipoOrdenar;

    public Ambito Ambito;
    public Ambito Padre;
    public int Fila, Columna;

    public FSeleccionar(String Tipo, ArrayList<FLlamadaTabla> Select, ArrayList<ColumnaEstructura> From, FNodoExpresion Condicion, FLlamadaTabla Ordenar, String TipoOrdenar, Ambito Ambito, int Fila, int Columna) {
        this.Tipo = Tipo;
        this.Select = Select;
        this.From = From;
        this.Condicion = Condicion;
        this.Ordenar = Ordenar;
        this.TipoOrdenar = TipoOrdenar;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        //llenar tablas
        if (Tools.BaseActual != null) {
            TablaSeleccionar Selects = new TablaSeleccionar();
            TablaSeleccionar Resultado = new TablaSeleccionar();

            if (Tipo.equals(Constante.TPor)) {
                //buscar las tablas e ingresarlas a la estructura temporal
                for (ColumnaEstructura ntabla : From) {
                    Tabla tabla = Tools.BaseActual.ExisteTabla(ntabla.NombreCampo);
                    if (tabla != null) {
                        Selects.IngresarNuevaTabla(tabla);
                        Resultado.IngresarNuevaTabla(tabla);
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + ntabla.NombreCampo + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    }

                }

                if (Tools.ContarErrores()) {
                    Tools.TablaPivote = Selects;
                    Resultado.LimpiarDatos();
                    Tools.TablaResultado = Resultado;

                    for (int i = 0; i < Selects.getSize(); i++) {
                        FNodoExpresion estado = this.Condicion.ResolverExpresion();
                        if (estado.Tipo.equals(Constante.TBool)) {
                            if (estado.Bool) {
                                Tools.TablaPivote.setResultado();
                            }
                        } else {
                            //error de tipo bool
                        }
                        Tools.TablaPivote.pos++;
                    }
                    Tools.TablaPivote = null;
                    //String cadena = Tools.TablaResultado.GetHtml();
                    if (Tools.ContarErrores()) {
                        Tools.ResultadosRetorno.add(Tools.TablaResultado);
                    }   
                }
            }else{
                for (ColumnaEstructura ntabla : From) {
                    Tabla tabla = Tools.BaseActual.ExisteTabla(ntabla.NombreCampo);
                    if (tabla != null) {
                        Selects.IngresarNuevaTabla(tabla);
                        Resultado.IngresarNuevaTabla(tabla);
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + ntabla.NombreCampo + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    }

                }

                if (Tools.ContarErrores()) {
                    Tools.TablaPivote = Selects;
                    Resultado.LimpiarDatos();
                    Tools.TablaResultado = Resultado;

                    for (int i = 0; i < Selects.getSize(); i++) {
                        FNodoExpresion estado = this.Condicion.ResolverExpresion();
                        if (estado.Tipo.equals(Constante.TBool)) {
                            if (estado.Bool) {
                                Tools.TablaPivote.setResultado();
                            }
                        } else {
                            //error de tipo bool
                        }
                        Tools.TablaPivote.pos++;
                    }
                    
                    Tools.TablaPivote = null;
                    //String cadena = Tools.TablaResultado.GetHtml();
                    if (Tools.ContarErrores()) {
                        Tools.TablaResultado.FiltrarDatos(Select);
                        Tools.ResultadosRetorno.add(Tools.TablaResultado);
                    }   
                }
            }
        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
        }
    }

    public FNodoExpresion EjecutarContar() {
        //llenar tablas
        if (Tools.BaseActual != null) {
            TablaSeleccionar Selects = new TablaSeleccionar();
            TablaSeleccionar Resultado = new TablaSeleccionar();

            if (Tipo.equals(Constante.TPor)) {
                //buscar las tablas e ingresarlas a la estructura temporal
                for (ColumnaEstructura ntabla : From) {
                    Tabla tabla = Tools.BaseActual.ExisteTabla(ntabla.NombreCampo);
                    if (tabla != null) {
                        Selects.IngresarNuevaTabla(tabla);
                        Resultado.IngresarNuevaTabla(tabla);
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + ntabla.NombreCampo + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    }

                }

                if (Tools.ContarErrores()) {
                    Tools.TablaPivote = Selects;
                    Resultado.LimpiarDatos();
                    Tools.TablaResultado = Resultado;

                    for (int i = 0; i < Selects.getSize(); i++) {
                        FNodoExpresion estado = this.Condicion.ResolverExpresion();
                        if (estado.Tipo.equals(Constante.TBool)) {
                            if (estado.Bool) {
                                Tools.TablaPivote.setResultado();
                            }
                        } else {
                            //error de tipo bool
                        }
                        Tools.TablaPivote.pos++;
                    }
                    Tools.TablaPivote = null;
                    //String cadena = Tools.TablaResultado.GetHtml();
                    if (Tools.ContarErrores()) {
                        return new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, this.Fila, this.Columna, Tools.TablaResultado.getSize());
                    }   
                }
            }else{
                for (ColumnaEstructura ntabla : From) {
                    Tabla tabla = Tools.BaseActual.ExisteTabla(ntabla.NombreCampo);
                    if (tabla != null) {
                        Selects.IngresarNuevaTabla(tabla);
                        Resultado.IngresarNuevaTabla(tabla);
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "La tabla " + ntabla.NombreCampo + " no existe en la base de datos " + Tools.BaseActual.Nombre, Fila, Columna);
                    }

                }

                if (Tools.ContarErrores()) {
                    Tools.TablaPivote = Selects;
                    Resultado.LimpiarDatos();
                    Tools.TablaResultado = Resultado;

                    for (int i = 0; i < Selects.getSize(); i++) {
                        FNodoExpresion estado = this.Condicion.ResolverExpresion();
                        if (estado.Tipo.equals(Constante.TBool)) {
                            if (estado.Bool) {
                                Tools.TablaPivote.setResultado();
                            }
                        } else {
                            //error de tipo bool
                        }
                        Tools.TablaPivote.pos++;
                    }
                    
                    Tools.TablaPivote = null;
                    //String cadena = Tools.TablaResultado.GetHtml();
                    if (Tools.ContarErrores()) {
                        Tools.TablaResultado.FiltrarDatos(Select);
                        return new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, this.Fila, this.Columna, Tools.TablaResultado.getSize());
                    }   
                }
            }
        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No ha seleccionado una base de datos.", Fila, Columna);
        }
        return new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, this.Fila, this.Columna, 0);
    }
    
    public String getCadena() {
        String cadena = "";

        if (this.Tipo.equals(Constante.TPor)) {
            cadena += "SELECCIONAR * DE ";

            int i = 0;
            for (ColumnaEstructura n : this.From) {
                if (i == 0) {
                    cadena += n.getCadenaInsertar();
                } else {
                    cadena += ", " + n.getCadenaInsertar();
                }
                i++;
            }
        } else {
            cadena += "SELECCIONAR ";

            int j = 0;
            
            for(FLlamadaTabla t : this.Select){
                if (j == 0) {
                    cadena += t.getCadena();
                } else {
                    cadena += ", " + t.getCadena();
                }
                j++;
            }
            
            cadena += " DE ";
            int i = 0;
            for (ColumnaEstructura n : this.From) {
                if (i == 0) {
                    cadena += n.getCadenaInsertar();
                } else {
                    cadena += ", " + n.getCadenaInsertar();
                }
                i++;
            }
        }

        cadena += " DONDE " + this.Condicion.getCadena();

        if (this.Ordenar != null) {

        }

        return cadena;
    }
}
