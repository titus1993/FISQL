/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.*;
//import Interface.Tools;
import java.util.ArrayList;
import Static.*;

/**
 *
 * @author Titus
 */
public class FMetodo {

    public Ambito Ambito;
    public ArrayList<Simbolo> Parametros;
    public int Fila, Columna;
    public String Tipo, Nombre;

    public FMetodo(ArrayList<Simbolo> parametro, Ambito ambito, int fila, int columna, String tipo, String nombre) {
        this.Ambito = ambito;
        this.Parametros = parametro;
        this.Fila = fila;
        this.Columna = columna;
        this.Tipo = tipo;
        this.Nombre = nombre;
    }
    
    public FMetodo(){
        
    }

    public void EjecutarInstrucciones(ArrayList<Simbolo> instrucciones) {
        if (Tools.ContarErrores()) {
            for (Simbolo instruccion : instrucciones) {
                if (Tools.ContarErrores() && !Tools.Tabla.IsDetener() && !Tools.Tabla.IsRertorno()) {
                    switch (instruccion.Rol) {
                        case Constante.TImprimir:
                            EjecutarImprimir(instruccion);
                            break;
                        /*case Constante.TMetodo:
                            EjecutarMetodo(instruccion);
                            break;*/
                        case Constante.TDeclaracion:
                            EjecutarDeclaracion(instruccion);
                            break;
                        case Constante.TAsignacion:
                            EjecutarAsignacion(instruccion);
                            break;
                        case Constante.TRetorno:
                            EjecutarRetorno(instruccion);
                            break;
                        case Constante.TDetener:
                            EjecutarDetener(instruccion);
                            break;
                        case Constante.TSi:
                            EjecutarSi(instruccion);
                            break;
                        case Constante.TMientras:
                            EjecutarMientras(instruccion);
                            break;
                        case Constante.TSeleccion:
                            EjecutarSelecciona(instruccion);
                            break;
                        case Constante.TPara:
                            EjecutarPara(instruccion);
                            break;

                        default:
                            break;
                    }
                }
            }
        }
    }

    public void EjecutarPara(Simbolo instruccion) {
        FPara para = (FPara) instruccion.Valor;
        para.EjecutarPara();
    }

    public void EjecutarSi(Simbolo instruccion) {
        FSi si = (FSi) instruccion.Valor;
        si.EjecutarSi();
    }

    public void EjecutarSelecciona(Simbolo instruccion) {
        FSelecciona selecciona = (FSelecciona) instruccion.Valor;
        selecciona.EjecutarSelecciona();
    }

    public void EjecutarMientras(Simbolo instruccion) {
        FMientras mientras = (FMientras) instruccion.Valor;
        mientras.EjecutarMientras();
    }

    public void EjecutarRetorno(Simbolo instruccion) {
        FNodoExpresion exp = (FNodoExpresion) instruccion.Valor;
        exp = exp.ResolverExpresion();

        Tools.Tabla.InsertarVariable(new Variable(exp.Nombre, instruccion.Nombre, instruccion.Nombre, instruccion.Fila, instruccion.Columna, instruccion.Ambito, exp));
    }

    public void EjecutarDetener(Simbolo instruccion) {
        Tools.Tabla.InsertarVariable(new Variable(instruccion.Tipo, instruccion.Nombre, instruccion.Rol, instruccion.Fila, instruccion.Columna, instruccion.Ambito, null));
    }

    public void EjecutarContinuar(Simbolo instruccion) {
        Tools.Tabla.InsertarVariable(new Variable(instruccion.Tipo, instruccion.Nombre, instruccion.Rol, instruccion.Fila, instruccion.Columna, instruccion.Ambito, null));
    }

    public void EjecutarMetodo(Simbolo instruccion) {
        
    }

    public void EjecutarDeclaracion(Simbolo instruccion) {
        FDeclaracion declaracion = (FDeclaracion) instruccion.Valor;
        declaracion.EjecutarDeclaracion();
    }

    public void EjecutarAsignacion(Simbolo instruccion) {
         FAsignacion asigna = (FAsignacion) instruccion.Valor;
        asigna.EjecutarAsignacion();
    }

    public void EjecutarImprimir(Simbolo instruccion) {
        FImprimir imprimir = (FImprimir) instruccion.Valor;
        imprimir.Imprimir();
    }

    public void SacarAmbito(ArrayList<Simbolo> ambito) {

    }
}
