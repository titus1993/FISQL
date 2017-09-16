/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import java.util.ArrayList;
import EjecucionUsql.*;
//import Interface.Tools;

/**
 *
 * @author Titus
 */
public class FSelecciona {

    public ArrayList<FCaso> Casos;
    public Ambito Ambito;
    public FCaso Defecto;
    public FNodoExpresion Condicion;

    public FSelecciona(FNodoExpresion condicion, ArrayList<FCaso> casos, FCaso defecto, Ambito ambito) {
        this.Casos = casos;
        this.Defecto = defecto;
        this.Ambito = ambito;
        this.Condicion = condicion;
    }

    public String getCadena(){
        String cadena = "";
        
        cadena += "SELECCIONA(" + Condicion.getCadena() + "){\n";
        
        
        for(FCaso caso : Casos){
            cadena += caso.getCadena() + "\n";
        }

        if(Defecto != null){
            cadena += "DEFECTO :\n" + Defecto.getCadena().replaceAll("\n", "\n\t");
        }
        
        cadena += "}";
        return cadena;
    }
    
    public void EjecutarSelecciona() {
        FNodoExpresion condicion = this.Condicion.ResolverExpresion();
        
        if (Tools.ContarErrores()) {
            int cont = 0;
            int posencontrado = -1;
            Boolean encontrado = false;
            while (cont < Casos.size() && !Tools.Tabla.IsDetener() && !Tools.Tabla.IsRertorno() && Tools.ContarErrores()) {
                if (Casos.get(cont).Valor.Tipo.equals(condicion.Tipo)) {
                    if (!encontrado) {
                        if (Casos.get(cont).Valor.Tipo.equals(Constante.TEntero)) {
                            if (Casos.get(cont).Valor.Entero == condicion.Entero) {
                                FMetodo metodo = new FMetodo();
                                metodo.EjecutarInstrucciones(this.Casos.get(cont).Ambito.TablaSimbolo);
                                encontrado = true;
                                posencontrado = cont;
                                if (Tools.Tabla.IsDetener()) {
                                    Variable tope = Tools.Tabla.ObtenerTope();
                                    Tools.Tabla.SacarVariable();
                                    metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);
                                    Tools.Tabla.InsertarVariable(tope);
                                }
                                //metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);
                            }
                        } else if (Casos.get(cont).Valor.Tipo.equals(Constante.TDecimal)) {
                            if (Casos.get(cont).Valor.Decimal == condicion.Decimal) {
                                FMetodo metodo = new FMetodo();
                                metodo.EjecutarInstrucciones(this.Casos.get(cont).Ambito.TablaSimbolo);
                                encontrado = true;
                                posencontrado = cont;
                                if (Tools.Tabla.IsDetener()) {
                                    Variable tope = Tools.Tabla.ObtenerTope();
                                    Tools.Tabla.SacarVariable();
                                    metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);
                                    Tools.Tabla.InsertarVariable(tope);
                                }
                                //metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);

                            }
                        } else if (Casos.get(cont).Valor.Tipo.equals(Constante.TCadena)) {
                            if (Casos.get(cont).Valor.Cadena.equals(condicion.Cadena)) {
                                FMetodo metodo = new FMetodo();
                                metodo.EjecutarInstrucciones(this.Casos.get(cont).Ambito.TablaSimbolo);
                                encontrado = true;
                                posencontrado = cont;
                                if (Tools.Tabla.IsDetener()) {
                                    Variable tope = Tools.Tabla.ObtenerTope();
                                    Tools.Tabla.SacarVariable();
                                    metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);
                                    Tools.Tabla.InsertarVariable(tope);
                                }
                                //metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);

                            }
                        }else if (Casos.get(cont).Valor.Tipo == Constante.TBool) {
                            if (Casos.get(cont).Valor.Bool == condicion.Bool) {
                                FMetodo metodo = new FMetodo();
                                metodo.EjecutarInstrucciones(this.Casos.get(cont).Ambito.TablaSimbolo);
                                encontrado = true;
                                posencontrado = cont;
                                if (Tools.Tabla.IsDetener()) {
                                    Variable tope = Tools.Tabla.ObtenerTope();
                                    Tools.Tabla.SacarVariable();
                                    metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);
                                    Tools.Tabla.InsertarVariable(tope);
                                }
                                //metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);

                            }
                        } else {
                            if (condicion.Tipo.equals(Constante.TObjeto)) {
                                Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo " + Casos.get(cont).Valor.Tipo + " no un tipo " + Casos.get(cont).Valor.Nombre, Casos.get(cont).Valor.Fila, Casos.get(cont).Valor.Columna);
                            } else {
                                Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo " + Casos.get(cont).Valor.Tipo + " no un tipo " + Casos.get(cont).Valor.Tipo, Casos.get(cont).Valor.Fila, Casos.get(cont).Valor.Columna);
                            }
                        }
                    }

                    if (encontrado & cont > posencontrado) {
                        FMetodo metodo = new FMetodo();
                        metodo.EjecutarInstrucciones(this.Casos.get(cont).Ambito.TablaSimbolo);
                        metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);

                    }
                } else {
                    if (condicion.Tipo.equals(Constante.TObjeto)) {
                        Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo " + Casos.get(cont).Valor.Tipo + " no un tipo " + Casos.get(cont).Valor.Nombre, Casos.get(cont).Valor.Fila, Casos.get(cont).Valor.Columna);
                    } else {
                        Tools.InsertarError(Constante.TErrorSemantico, "Se esperaba un tipo " + Casos.get(cont).Valor.Tipo + " no un tipo " + Casos.get(cont).Valor.Tipo, Casos.get(cont).Valor.Fila, Casos.get(cont).Valor.Columna);
                    }
                }
                cont++;
            }
            if (!encontrado && !Tools.Tabla.IsDetener() && !Tools.Tabla.IsRertorno() && Tools.ContarErrores()) {
                if (Defecto != null) {
                    FMetodo metodo = new FMetodo();
                    metodo.EjecutarInstrucciones(this.Defecto.Ambito.TablaSimbolo);
                    if (Tools.Tabla.IsDetener()) {
                        Variable tope = Tools.Tabla.ObtenerTope();
                        Tools.Tabla.SacarVariable();
                        metodo.SacarAmbito(this.Defecto.Ambito.TablaSimbolo);
                        Tools.Tabla.InsertarVariable(tope);
                    }
                    //metodo.SacarAmbito(this.Casos.get(cont).Ambito.TablaSimbolo);

                }
            }

            if (Tools.Tabla.IsDetener()) {
                Tools.Tabla.SacarVariable();
            }
        }
    }
}
