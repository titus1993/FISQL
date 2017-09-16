/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import EjecucionUsql.*;
//import Interface.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FSi {

    public Ambito Si;
    public Ambito Sino;
    public Ambito Ambito;
    public FNodoExpresion Condicion;

    public FSi(FNodoExpresion condicion, Ambito si, Ambito sino, Ambito ambito) {
        this.Si = si;
        this.Sino = sino;
        this.Condicion = condicion;
        this.Ambito = ambito;
    }
    
    public String getCadena() {
        String cadena = "";
        
        cadena+= "SI(" + Condicion.getCadena() + "){\n";
        
        FMetodo m = new FMetodo();
        String cuerpo = "\t" + m.getCadenaCuerpo(Si.TablaSimbolo).replaceAll("\n", "\n\t");
        
        cadena += cuerpo + "\n}";
        
        if(this.Sino != null){
            cadena += "SINO{\n";
            String c = "\t" + m.getCadenaCuerpo(Sino.TablaSimbolo).replaceAll("\n", "\n\t");
            cadena += c + "\n}";
        }      
        
        
        return cadena;
    }

    public void EjecutarSi() {
        FNodoExpresion condicion = this.Condicion.ResolverExpresion();
        
        if (Tools.ContarErrores()) {
            if (condicion.Tipo.equals(Constante.TBool)) {
                if (condicion.Bool) {
                    FMetodo metodo = new FMetodo();
                    metodo.EjecutarInstrucciones(Si.TablaSimbolo);
                    metodo.SacarAmbito(Si.TablaSimbolo);
                } else {
                    if (Sino != null) {
                        FMetodo metodo = new FMetodo();
                        metodo.EjecutarInstrucciones(Sino.TablaSimbolo);
                        metodo.SacarAmbito(Sino.TablaSimbolo);
                    }
                }
            } else {
                if (condicion.Tipo.equals(Constante.TObjeto)) {
                    Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo bool no un tipo " + condicion.Nombre, Condicion.Fila, Condicion.Columna);
                } else {
                    Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo bool no un tipo " + condicion.Tipo, Condicion.Fila, Condicion.Columna);
                }
            }
        }
    }
}
