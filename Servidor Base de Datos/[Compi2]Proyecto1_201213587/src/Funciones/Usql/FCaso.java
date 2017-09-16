/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.*;
/**
 *
 * @author Titus
 */
public class FCaso {
    public FNodoExpresion Valor;
    public Ambito Ambito;
    
    public FCaso(FNodoExpresion valor, Ambito ambito){
        this.Valor = valor;
        this.Ambito = ambito;
    }
    
    
    public String getCadena(){
        String cadena = "";
        
        cadena += "CASO " + Valor.getCadena() + ":\n";
        
        FMetodo m = new FMetodo();
        
        cadena += m.getCadenaCuerpo(Ambito.TablaSimbolo).replaceAll("\n", "\n\t");
        
        return cadena;
    }
}
