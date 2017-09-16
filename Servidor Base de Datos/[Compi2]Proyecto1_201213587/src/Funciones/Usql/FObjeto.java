/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.TablaUsql;
import EjecucionUsql.Variable;
import Funciones.XML.Columna;
import Funciones.XML.Parametro;
import Funciones.XML.columnaObjeto;
import Static.Constante;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FObjeto {

    public TablaUsql TablaVariables = new TablaUsql();
    public String Nombre;

    public FObjeto(String nombre, ArrayList<Parametro> campos) {
        this.Nombre = nombre;

        for (Parametro p : campos) {
            this.TablaVariables.Tabla.add(new Variable(p.tipo, p.nombre, Constante.TVariable, 0, 0, null, null));
        }
    }

    public columnaObjeto GetDatos() {
        ArrayList<Columna> lista = new ArrayList<>();
        for (Variable v : TablaVariables.Tabla) {
            if (v.Valor != null) {
                FNodoExpresion val = (FNodoExpresion) v.Valor;
                lista.add(new Columna(v.Nombre, val.Cadena));
            }else{
                lista.add(new Columna(v.Nombre, ""));
            }
        }
        return new columnaObjeto(lista);
    }

}
