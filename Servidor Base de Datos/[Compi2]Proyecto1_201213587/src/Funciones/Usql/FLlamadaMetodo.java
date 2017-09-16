/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.*;
import Static.*;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FLlamadaMetodo {

    //public Ambito Ambito;
    public String Nombre;
    public int Fila, Columna;
    public ArrayList<FNodoExpresion> Parametros = new ArrayList<>();

    public FLlamadaMetodo(String nombre, ArrayList<FNodoExpresion> parametros, int fila, int columna) {
        this.Nombre = nombre;
        this.Parametros = parametros;
        this.Fila = fila;
        this.Columna = columna;
        //this.Ambito = new Ambito(Constante.TMetodo);
    }

    public String getCadena(){
        String cadena = "";
        cadena += this.Nombre + "(";
        
        int i =0;
        for(FNodoExpresion nodo : Parametros){
            if(i == 0){
                cadena += nodo.getCadena();
            }else{
                cadena += ", " + nodo.getCadena();
            }
            i++;
        }
        
        cadena += ")";
        
        return cadena;
    }
    public void InsertarParametro(FNodoExpresion parametro) {
        Parametros.add(parametro);
    }

    public Variable EjecutarLlamadaMetodo() {

        ArrayList<FNodoExpresion> listaparametros = new ArrayList<>();
        for (FNodoExpresion par : Parametros) {
            FNodoExpresion nuevopar = par.ResolverExpresion();

            listaparametros.add(nuevopar);
        }

        Variable actual = Tools.Funciones.BuscarFuncion(this, listaparametros);
        if (actual != null) {
            //primero ejecutamos el metodo
            FMetodo metodo = (FMetodo) actual.Valor;
            //obtenemos el return
            Variable retorno = metodo.EjecutarMetodo(this, actual);


            //comprobamos si es null para notificar error
            if (retorno != null && !actual.Tipo.equals(Constante.TVacio)) {
                if (actual.Tipo.equals(Constante.TCadena) || actual.Tipo.equals(Constante.TEntero) || actual.Tipo.equals(Constante.TDecimal) || actual.Tipo.equals(Constante.TBool)) {

                    return retorno;

                } else {
                    Tools.InsertarError(Constante.TErrorSemantico, "El metodo " + actual.Nombre + " no retonra un Als, retorna un tipo " + actual.Tipo, Fila, Columna);
                }
            } else {
                if (actual.Tipo.equals(Constante.TVacio)) {
                    Tools.InsertarError(Constante.TErrorSemantico, "El metodo " + actual.Nombre + " es de tipo vacio ", Fila, Columna);
                } else {
                    Tools.InsertarError(Constante.TErrorSemantico, "El metodo " + actual.Nombre + " no retorno ningun valor ", Fila, Columna);
                }
            }

        } else {
            Tools.InsertarError(Constante.TErrorSemantico, "No se encontro el metodo " + this.Nombre, this.Fila, this.Columna);
        }
        return null;
    }

}
