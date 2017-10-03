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
public class FImprimir {

    public Ambito Ambito;
    public FNodoExpresion Valor;
    public int Fila, Columna;

    public FImprimir(FNodoExpresion valor) {
        this.Ambito = new Ambito(Constante.TImprimir, new ArrayList<Simbolo>());
        this.Valor = valor;
    }

    
    public String getCadena(){
        return "IMPRIMIR(" + this.Valor.getCadena() + ")\n";
    }
    public void Imprimir() {
        FNodoExpresion solucion = Valor.ResolverExpresion();
       
        
        if (true) {
            if (solucion.Tipo.equals(Constante.TCadena)) {
                //Tools.ImprimirConsola(solucion.Cadena);
                ImprimirRespuesta(solucion.Cadena);
            } else if (solucion.Tipo.equals(Constante.TEntero)) {
                //Tools.ImprimirConsola(String.valueOf(solucion.Entero));
                ImprimirRespuesta(String.valueOf(solucion.Entero));
            } else if (solucion.Tipo.equals(Constante.TDecimal)) {
                //Tools.ImprimirConsola(String.valueOf(solucion.Decimal));
                ImprimirRespuesta(String.valueOf(solucion.Decimal));
            }  else if (solucion.Tipo.equals(Constante.TBool)) {
                //Tools.ImprimirConsola(String.valueOf(solucion.Cadena));                
                ImprimirRespuesta(String.valueOf(solucion.Cadena));
            }else if (solucion.Tipo.equals(Constante.TDate)) {
                //Tools.ImprimirConsola(String.valueOf(solucion.Date));                
                ImprimirRespuesta(String.valueOf(solucion.Date));
            }else if (solucion.Tipo.equals(Constante.TDateTime)) {
                //Tools.ImprimirConsola(String.valueOf(solucion.DateTime));
                ImprimirRespuesta(String.valueOf(solucion.DateTime));
            } else {
                //Tools.ImprimirConsola(String.valueOf(solucion.Nombre));                
                ImprimirRespuesta(String.valueOf(solucion.Nombre));
                //Tools.InsertarError(Constante.TErrorSintactico, "Se esperaba un tipo String", solucion.Fila, solucion.Columna);
            }
        }
    }
    
    public void ImprimirRespuesta(String cadena){
        Tools.Imprimir += cadena + "\n";
    }
}
