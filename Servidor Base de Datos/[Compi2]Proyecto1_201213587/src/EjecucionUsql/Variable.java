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
public class Variable {
    public String Tipo, Nombre, Rol;
    public int Fila, Columna;
    public Ambito Ambito;
    public Object Valor;
    
    public Variable(String tipo, String nombre, String rol, int fila, int columna, Ambito ambito, Object valor){
        this.Tipo = tipo;
        this.Nombre = nombre;
        this.Rol = rol;
        this.Fila = fila;
        this.Columna = columna;
        this.Ambito = ambito;
        this.Valor = valor;      
    }
}
