/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;

import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Ambito {
    public ArrayList<Simbolo> TablaSimbolo;
    public Ambito Padre;
    public String Nombre;
    
    public Ambito(String nombre, ArrayList<Simbolo> tablasimbolo){
        this.TablaSimbolo = tablasimbolo;
        this.Padre = null;
        this.Nombre = nombre;
    }
    
    public Ambito(String nombre){
        this.Nombre = nombre;
        this.TablaSimbolo = new ArrayList<>();
    }
}
