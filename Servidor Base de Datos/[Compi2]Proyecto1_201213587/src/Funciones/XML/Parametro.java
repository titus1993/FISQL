/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

/**
 *
 * @author Titus
 */
public class Parametro {
    public String tipo, nombre, objeto;
    
    public Parametro(String _tipo, String _nombre){
        tipo = _tipo;
        nombre = _nombre;
        objeto = "";
    }
    
    public Parametro(String _tipo, String _nombre, String _objeto){
        tipo = _tipo;
        nombre = _nombre;
        objeto = _objeto;
    }
}
