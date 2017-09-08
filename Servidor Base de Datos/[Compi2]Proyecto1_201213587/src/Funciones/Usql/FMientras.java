/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import Static.*;
import EjecucionUsql.*;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FMientras {

    public Ambito Ambito;
    public FNodoExpresion Condicion;

    public FMientras(FNodoExpresion condicion, Ambito ambito) {
        this.Ambito = ambito;
        this.Condicion = condicion;
    }

    public void EjecutarMientras() {
        FNodoExpresion condicion = this.Condicion.ResolverExpresion();
        
        if (Tools.ContarErrores()) {
            if (condicion.Tipo.equals(Constante.TBool)) {
                while (Tools.ContarErrores() && condicion.Bool && !Tools.Tabla.IsRertorno() && !Tools.Tabla.IsDetener()) {
                    FMetodo metodo = new FMetodo();
                    metodo.EjecutarInstrucciones(Ambito.TablaSimbolo);

                    condicion = this.Condicion.ResolverExpresion();
                    
                    metodo.SacarAmbito(Ambito.TablaSimbolo);
                }
                if (Tools.Tabla.IsDetener()) {
                    Tools.Tabla.SacarVariable();
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
