/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;



/**
 *
 * @author Titus
 */
public class Simbolo {
    public int Fila, Columna;
    public String Nombre, Rol, Tipo;
    public Ambito Ambito;
    public Object Valor;
    
    
    public Simbolo(String tipo, String nombre, String rol, Ambito ambito, Object valor, int fila, int columna){     
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Rol = rol;
        this.Fila = fila;
        this.Columna = columna;
        this.Ambito = ambito;
        this.Valor = valor;
    }
}
