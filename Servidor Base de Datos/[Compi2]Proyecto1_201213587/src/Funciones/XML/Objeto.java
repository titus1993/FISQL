/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Funciones.Usql.FObjeto;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Objeto {

    String nombre;
    ArrayList<Parametro> parametros;

    public Objeto(String _nombre, ArrayList<Parametro> _parametros) {
        nombre = _nombre;
        parametros = _parametros;
    }

    public FObjeto ObtenerObjeto() {
        return new FObjeto(this.nombre, this.parametros);
    }

    public String getXML() {
        String cadena = "";

        cadena += "<Obj>\n"
                + "\t<Nombre>" + nombre + "</nombre>\n"
                + "\t<attr>\n";

        for (int i = 0; i < parametros.size(); i++) {
            cadena += parametros.get(i).getXML();
        }

        cadena += "\t</attr>\n"
                + "</Obj>\n";

        return cadena;
    }
}
