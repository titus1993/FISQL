/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;

import Funciones.Usql.FNodoExpresion;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class ColumnaSeleccionar{
    public String Tabla, Objeto, Atributo;
    public String Tipo;
    public ArrayList<FNodoExpresion> Columnas; 
    
    public ColumnaSeleccionar(String Tabla, String Objeto, String Atributo, String Tipo){
        this.Tabla = Tabla;
        this.Objeto = Objeto;
        this.Atributo = Atributo;
        this.Tipo = Tipo;
        Columnas = new ArrayList<>();
    }
}
