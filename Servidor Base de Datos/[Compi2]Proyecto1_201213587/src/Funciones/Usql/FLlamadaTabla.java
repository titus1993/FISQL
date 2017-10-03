/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Static.Tools;

/**
 *
 * @author Titus
 */
public class FLlamadaTabla {
    public String Tabla, Atributo, Objeto;
    public int Fila, Columna;
    public Ambito Ambito;
    
    public FLlamadaTabla(String Tabla, String Objeto, String Atributo, int Fila, int Columna){
        this.Tabla = Tabla;
        this.Atributo = Atributo;
        this.Objeto = Objeto;
        this.Fila = Fila;
        this.Columna = Columna;
    }
    
    
    public FNodoExpresion Ejecutar(){
        FNodoExpresion va = Tools.TablaPivote.getValor(this.Tabla, this.Objeto, this.Atributo);
        
        return va;
    }
    
    
    public String getCadena(){
        String cadena = "";
        
        if(!this.Tabla.equals("")){
            cadena += this.Tabla + ".";
        }
        
        if(!this.Objeto.equals("")){
            cadena += this.Objeto + ".";
        }
        
        if(!this.Atributo.equals("")){
            cadena += this.Atributo;
        }
        
        return cadena;
    }
}
