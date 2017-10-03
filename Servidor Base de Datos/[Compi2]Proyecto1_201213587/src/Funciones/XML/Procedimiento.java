/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Procedimiento {
    public String nombre, src;
    public ArrayList<Parametro> parametros;
    
    public Procedimiento(String _nombre, String _src, ArrayList<Parametro> _parametros){
        nombre = _nombre;
        src = _src;
        parametros = _parametros;
    }
    
    public String getCadena(){
               
        return this.src;
    }
    
    public String getXML(){
        String cadena = "";
        
        cadena += "<Proc>\n"
                + "\t<Nombre>\"" + nombre + "\"</Nombre>\n"
                + "\t<Params>\n";
        
        for(int i = 0; i < parametros.size(); i++){
            cadena += parametros.get(i).getXMLComillas();
        }
        
        cadena += "\t</Params>\n"
                + "\t<src>§\n" + src + "\n§\n\t</src>\n"
                + "</Proc>\n";
        
        return cadena;
    }
}