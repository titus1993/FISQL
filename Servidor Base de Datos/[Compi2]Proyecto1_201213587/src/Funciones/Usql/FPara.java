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
public class FPara {

    public String AccionSiguiente;
    public Simbolo AccionAnterior;
    public FNodoExpresion Condicion;
    public Ambito Ambito;

    public FPara(Simbolo anterior, FNodoExpresion condicion, String siguiente, Ambito ambito) {
        this.AccionAnterior = anterior;
        this.Condicion = condicion;
        this.AccionSiguiente = siguiente;
        this.Ambito = ambito;
    }

    public String getCadena() {
        String cadena = "";
        FDeclaracion fd = (FDeclaracion)AccionAnterior.Valor;
        cadena+= "PARA( " + fd.getCadena() + "; " + Condicion.getCadena() + "; " + this.AccionSiguiente + "){\n";
        
        FMetodo m = new FMetodo();
        String cuerpo = m.getCadenaCuerpo(Ambito.TablaSimbolo).replaceAll("\n", "\n\t");
        
        cadena += cuerpo + "\n}";
        
        return cadena;
    }

    public void EjecutarPara() {
        //verificamos si la accion posterior es declaracion o asignacion
        if (AccionAnterior.Rol.equals(Constante.TDeclaracion)) {
            FDeclaracion decla = (FDeclaracion) AccionAnterior.Valor;
            decla.EjecutarDeclaracion();

        }

        FNodoExpresion condicion = this.Condicion.ResolverExpresion();

        if (Tools.ContarErrores()) {
            if (condicion.Tipo.equals(Constante.TBool)) {
                while (Tools.ContarErrores() && condicion.Bool && !Tools.Tabla.IsRertorno() && !Tools.Tabla.IsDetener()) {
                    condicion = Condicion.ResolverExpresion();

                    FMetodo metodo1 = new FMetodo();

                    if (condicion.Bool) {
                        metodo1.EjecutarInstrucciones(this.Ambito.TablaSimbolo);

                    }

                    condicion = Condicion.ResolverExpresion();

                    //sacamos el ambito del para
                    metodo1.SacarAmbito(this.Ambito.TablaSimbolo);
                    //realizamos la operacion posterior
                    if (condicion.Bool) {
                        FDeclaracion decla = (FDeclaracion) AccionAnterior.Valor;
                        Variable var = Tools.Tabla.BuscarVariable(decla.Nombre);
                        FNodoExpresion exp = (FNodoExpresion) var.Valor;
                        if (AccionSiguiente.equals(Constante.TAumento)) {
                            exp.Entero++;
                            exp.Decimal++;
                        } else {
                            exp.Entero--;
                            exp.Decimal--;
                        }
                    }

                }
                if (Tools.Tabla.IsDetener()) {
                    Tools.Tabla.SacarVariable();
                }

                //sacamos la variable si fue declaracion
                if (AccionAnterior.Rol.equals(Constante.TDeclaracion)) {
                    FDeclaracion decla = (FDeclaracion) AccionAnterior.Valor;
                    if (Tools.Tabla.ExisteVariableTope(decla.Nombre)) {
                        Tools.Tabla.SacarVariable();
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
