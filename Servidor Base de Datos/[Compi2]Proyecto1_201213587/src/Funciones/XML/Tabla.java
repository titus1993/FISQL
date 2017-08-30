/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Tabla {

    public ArrayList<ColumnaEstructura> Columnas;
    public String Nombre, Path;
    public ArrayList<ArrayList<Columna>> Filas;

    public Tabla(String nombre, String path, ArrayList<ColumnaEstructura> columnas) {
        Nombre = nombre;
        Path = path;
        Columnas = columnas;
    }

    public String getXML() {
        String cadena = "";

        cadena += "<Tabla>\n"
                + "\t<Nombre>\"" + Nombre + "\"</Nombre>\n"
                + "\t<Path>\"" + Path + "\"</Path>\n"
                + "\t<Rows>\n";

        for (int i = 0; i < Columnas.size(); i++) {
            cadena += Columnas.get(i).getXML();
        }

        cadena += "\t</Rows>\n"
                + "</Tabla>\n";

        return cadena;
    }

    public void GuardarTabla() {
        String cadena = "";
        for (int i = 0; i < Filas.size(); i++) {
            ArrayList<Columna> temp = Filas.get(i);
            cadena += "<Row>\n";
            for (Columna celda : temp) {
                cadena += celda.getXML();                        
            }
            cadena += "</Row>\n";
        }
        
        Tools.guardarArchivo(Path, cadena);
    }
}
