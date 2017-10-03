/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Funciones.Usql.FObjeto;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Objeto {

    String nombre;
    ArrayList<Parametro> parametros;

    public Objeto(String _nombre, ArrayList<Parametro> _parametros) {
        nombre = _nombre;
        parametros = _parametros;
    }

    public FObjeto ObtenerObjeto() {
        return new FObjeto(this.nombre, this.parametros);
    }
    
    public String getCadena(){
        String cadena = "";
        
        cadena += "CREAR OBJETO " + this.nombre + "(";
        
        int i=0;
        for(Parametro p : this.parametros){
            if(i == 0){
                cadena += p.getCadenaParametro();
            }else{
                cadena += ", " + p.getCadenaParametro();
            }
            i++;
        }
        
        cadena += ");";
        
        return cadena;
    }
    
    public int QuitarObjeto(String c){
        int pos = PosColumna(c);

        if (pos >= 0) {
            this.parametros.remove(pos);
        }
        
        return pos;
    }
    
    public int PosColumna(String nombre) {
        for (int i = 0; i < this.parametros.size(); i++) {
            if (this.parametros.get(i).nombre.equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public String getXML() {
        String cadena = "";

        cadena += "<Obj>\n"
                + "\t<Nombre>" + nombre + "</nombre>\n"
                + "\t<attr>\n";

        for (int i = 0; i < parametros.size(); i++) {
            cadena += parametros.get(i).getXML();
        }

        cadena += "\t</attr>\n"
                + "</Obj>\n";

        return cadena;
    }
}
