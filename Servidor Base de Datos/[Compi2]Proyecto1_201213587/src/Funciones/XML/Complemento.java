/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

/**
 *
 * @author Titus
 */
public class Complemento {

    public boolean isNulo, isAutoincrementable, isPrimary, isForanea;
    public String Foranea = "";

    public String getCadena() {
        String cadena = "";
        if (!isNulo) {
            cadena += " NULO";
        } else {
            cadena += " NO NULO";
        }
        
        if(isAutoincrementable) cadena+= " AUTOINCREMENTABLE";
        if(isPrimary) cadena += " LLAVE_PRIMARIA";
        if(isForanea) cadena += " LLAVE_FORANEA " + this.Foranea;

        return cadena;
    }
}
