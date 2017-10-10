/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;

import Funciones.Usql.FNodoExpresion;
import java.util.ArrayList;
import Funciones.Usql.*;
import Funciones.XML.*;
import Static.Constante;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class TablaSeleccionar {

    public ArrayList<ColumnaSeleccionar> Tabla;
    public int pos = 0;
    public int tablas = 0;

    public TablaSeleccionar() {
        this.Tabla = new ArrayList<>();
    }

    public void IngresarNuevaTabla(Tabla tabla) {
        int j = 0;
        TablaSeleccionar tablatemporal = new TablaSeleccionar();
        for (ColumnaEstructura col : tabla.Columnas) {
            ColumnaSeleccionar nuevacol;

            if (col.Tipo == 0) {
                nuevacol = new ColumnaSeleccionar(tabla.Nombre, "", col.NombreCampo, col.TipoCampo);
                for (ArrayList<Columna> fila : tabla.Filas) {
                    //creamos el nodoexpresion con su valor
                    //si tiene datos los convertimos
                    Columna val = fila.get(j);
                    if (!val.Valor.equals("")) {
                        switch (col.TipoCampo) {
                            case Constante.TEntero:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, 0, 0, val.Valor));
                                break;

                            case Constante.TDecimal:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, 0, 0, val.Valor));
                                break;

                            case Constante.TBool:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, 0, 0, val.Valor));
                                break;

                            case Constante.TText:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, 0, 0, val.Valor));
                                break;

                            case Constante.TDate:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDate, Constante.TDate, 0, 0, val.Valor));
                                break;

                            case Constante.TDateTime:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDateTime, Constante.TDateTime, 0, 0, val.Valor));
                                break;
                        }
                        //si no tiene le seteamos uno temporal
                    } else {
                        switch (col.TipoCampo) {
                            case Constante.TEntero:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, 0, 0, "0"));
                                break;

                            case Constante.TDecimal:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, 0, 0, "0"));
                                break;

                            case Constante.TBool:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, 0, 0, "falso"));
                                break;

                            case Constante.TText:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, 0, 0, ""));
                                break;

                            case Constante.TDate:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDate, Constante.TDate, 0, 0, "01-01-2000"));
                                break;

                            case Constante.TDateTime:
                                nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TDateTime, Constante.TDateTime, 0, 0, "01-01-2000 00:00:00"));
                                break;
                        }
                    }
                }
                tablatemporal.Tabla.add(nuevacol);
                j++;
                //si es objeto hacemos la insercion por atributo
            } else {
                nuevacol = new ColumnaSeleccionar(tabla.Nombre, col.NombreCampo, "", col.TipoCampo);
                for (ArrayList<Columna> fila : tabla.Filas) {
                    //creamos el nodoexpresion con su valor
                    //si tiene datos los convertimos                   

                    Columna colval = fila.get(j);

                    //objetemos la estructura del objeto
                    Objeto o = Tools.BaseActual.ExisteObjeto(col.TipoCampo);

                    //creamos el objeto para asignale los datos
                    FObjeto estructura = o.ObtenerObjeto();

                    for (Columna val : colval.campoObjeto.Filas) {
                        Variable var = estructura.TablaVariables.BuscarVariable(val.Campo);
                        if (!val.Valor.equals("")) {
                            switch (var.Tipo) {
                                case Constante.TEntero:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, 0, 0, val.Valor);
                                    break;

                                case Constante.TDecimal:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, 0, 0, val.Valor);
                                    break;

                                case Constante.TBool:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, 0, 0, val.Valor);
                                    break;

                                case Constante.TText:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, 0, 0, val.Valor);
                                    break;

                                case Constante.TDate:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDate, Constante.TDate, 0, 0, val.Valor);
                                    break;

                                case Constante.TDateTime:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDateTime, Constante.TDateTime, 0, 0, val.Valor);
                                    break;
                            }
                            //si no tiene le seteamos uno temporal
                        } else {
                            switch (var.Tipo) {
                                case Constante.TEntero:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TEntero, Constante.TEntero, 0, 0, "0");
                                    break;

                                case Constante.TDecimal:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDecimal, Constante.TDecimal, 0, 0, "0");
                                    break;

                                case Constante.TBool:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TBool, Constante.TBool, 0, 0, "falso");
                                    break;

                                case Constante.TText:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TCadena, Constante.TCadena, 0, 0, "");
                                    break;

                                case Constante.TDate:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDate, Constante.TDate, 0, 0, "01-01-2000");
                                    break;

                                case Constante.TDateTime:
                                    var.Valor = new FNodoExpresion(null, null, Constante.TDateTime, Constante.TDateTime, 0, 0, "01-01-2000 00:00:00");
                                    break;
                            }
                        }
                    }
                    nuevacol.Columnas.add(new FNodoExpresion(null, null, Constante.TObjeto, col.TipoCampo, 0, 0, estructura));
                }
                tablatemporal.Tabla.add(nuevacol);
                j++;
            }
        }

        if (this.tablas == 0) {
            this.tablas++;
            this.Tabla = tablatemporal.Tabla;
        } else {
            this.ProductoCartesiano(this, tablatemporal);
        }

    }

    public void FiltrarDatos(ArrayList<FLlamadaTabla> datos){
        ArrayList<ColumnaSeleccionar> temp = new ArrayList<ColumnaSeleccionar>();
        for(FLlamadaTabla t : datos){
            for(ColumnaSeleccionar c : this.Tabla){
                if(t.Objeto.equals(c.Objeto) && (t.Tabla.equals(c.Tabla) || t.Tabla.equals("")) && t.Atributo.equals(c.Atributo)){
                    temp.add(c);
                }
            }
        }
        
        this.Tabla = temp;        
    }
    
    public FNodoExpresion getValor(String Tabla, String Objeto, String Atributo) {
        if (!Tabla.equals("") && Objeto.equals("") && Atributo.equals("")) {

        } else if (!Tabla.equals("") && !Atributo.equals("")) {
            for (ColumnaSeleccionar col : this.Tabla) {
                if (col.Tabla.equals(Tabla) && col.Atributo.toLowerCase().equals(Atributo.toLowerCase())) {
                    return col.Columnas.get(pos);
                } else if (col.Objeto.equals(Objeto) && !col.Objeto.equals("")) {
                    return col.Columnas.get(pos);
                }
            }
        } else if (!Atributo.equals("")) {
            for (ColumnaSeleccionar col : this.Tabla) {
                if (col.Atributo.equals(Atributo)) {
                        return col.Columnas.get(pos);
                } else if (col.Objeto.equals(Objeto) && !col.Objeto.equals("")) {
                    return col.Columnas.get(pos);
                }
            }
        }
        return null;
    }

    public void ProductoCartesiano(TablaSeleccionar tabla1, TablaSeleccionar tabla2) {
        ArrayList<ColumnaSeleccionar> union = new ArrayList<ColumnaSeleccionar>();

        for (ColumnaSeleccionar tempcol : tabla1.Tabla) {
            union.add(new ColumnaSeleccionar(tempcol.Tabla, tempcol.Objeto, tempcol.Atributo, tempcol.Tipo));
        }

        for (ColumnaSeleccionar tempcol : tabla2.Tabla) {
            union.add(new ColumnaSeleccionar(tempcol.Tabla, tempcol.Objeto, tempcol.Atributo, tempcol.Tipo));
        }

        int i = 0;
        for (int k = 0; k < tabla2.Tabla.get(0).Columnas.size(); k++) {
            i = 0;
            for (ColumnaSeleccionar col : tabla1.Tabla) {
                for (FNodoExpresion exp : col.Columnas) {
                    union.get(i).Columnas.add(exp);
                }
                i++;
            }
        }

        for (ColumnaSeleccionar col : tabla2.Tabla) {
            for (FNodoExpresion exp : col.Columnas) {
                for (int k = 0; k < tabla1.Tabla.get(0).Columnas.size(); k++) {
                    union.get(i).Columnas.add(exp);
                }
            }
            i++;
        }

        tabla1.Tabla = union;
    }

    public void LimpiarDatos() {
        for (ColumnaSeleccionar col : this.Tabla) {
            col.Columnas.clear();
        }
    }

    public int getSize() {
        return this.Tabla.get(0).Columnas.size();
    }

    public void setResultado() {
        for (int i = 0; i < this.Tabla.size(); i++) {
            FNodoExpresion result = this.Tabla.get(i).Columnas.get(pos);
            Tools.TablaResultado.Tabla.get(i).Columnas.add(result);
        }
    }
    
    
    public String GetHtml(){
        String cadena = "";
        cadena += "<thead>\n";
        String encabezado = "\t<tr>\n";
        for(ColumnaSeleccionar col : this.Tabla){
            encabezado += "\t\t<th>" + col.Tabla + "." + col.Atributo + "</th>\n";
        }        
        encabezado += "\t</tr>\n";
        
        cadena += encabezado;
        
        cadena += "</thead>\n";
        
        cadena += "<tbody>\n";
        
        
        
        for(int i = 0; i < this.Tabla.get(0).Columnas.size(); i++){
            cadena += "\t<tr>\n";
            for(ColumnaSeleccionar col : this.Tabla){
                cadena += "\t\t<th>"+col.Columnas.get(i).getCadena() + "</th>\n";
            }
            cadena += "\t</tr>\n";
        }
        
        cadena += "</tbody>\n";
        
        cadena += "<tfoot>\n";
        
        cadena += encabezado;
        
        cadena+= "</tfoot>\n";
        
        return cadena;
    }
}
