/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class columnaObjeto {

    ArrayList<Columna> Filas;

    public columnaObjeto(ArrayList<Columna> _filas) {
        Filas = _filas;
    }

    public String getXML() {
        String cadena = "";

        for (Columna temp : Filas) {
            cadena += "\t" + temp.getXML();
        }

        return cadena;
    }
}
