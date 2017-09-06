/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

/**
 *
 * @author Titus
 */
public class FLlamadaTabla {
    String Tabla, Atributo, Objeto;
    int Fila, Columna;
    
    public FLlamadaTabla(String Tabla, String Objeto, String Atributo, int Fila, int Columna){
        this.Tabla = Tabla;
        this.Atributo = Atributo;
        this.Objeto = Objeto;
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
}
