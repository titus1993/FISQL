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
public class Tabla {
    public ArrayList<ColumnaEstructura> Columnas;
    public String Nombre, Path;
    public ArrayList<ArrayList<Columna>> Filas;
    
    
    public Tabla(String nombre, String path, ArrayList<ColumnaEstructura> columnas){
        Nombre = nombre;
        Path = path;
        Columnas = columnas;
    }
}




