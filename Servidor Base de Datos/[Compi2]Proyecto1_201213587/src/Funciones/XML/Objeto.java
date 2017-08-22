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
public class Objeto {
    String nombre;
    ArrayList<Parametro> parametros;
    
    public Objeto(String _nombre, ArrayList<Parametro> _parametros){
        nombre = _nombre;
        parametros = _parametros;
    }
}
