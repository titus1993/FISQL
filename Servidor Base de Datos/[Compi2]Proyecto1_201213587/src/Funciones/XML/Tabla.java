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
    public String Nombre;
    public ArrayList<ArrayList<Columna>> Filas;
    
    public Tabla(ArrayList<ArrayList<Columna>> _filas){
        Filas = _filas;
    }
}




