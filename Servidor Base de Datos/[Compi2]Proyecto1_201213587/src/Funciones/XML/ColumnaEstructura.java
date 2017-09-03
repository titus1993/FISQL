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
public class ColumnaEstructura {

    public int Tipo;
    public String NombreCampo, TipoCampo;
    public Complemento Complementos;

    public ColumnaEstructura() {
        Complementos = new Complemento();
    }

    public String getXML() {
        String cadena = "";

        cadena += "\t\t<Campo>\n"
                + "\t\t\t<" + TipoCampo + ">\"" + NombreCampo + "\"</" + TipoCampo + ">\n";

        if(Complementos.isNulo){
            cadena += "\t\t\t<Complemento>nulo</Complemento>\n";
        }else{
            cadena += "\t\t\t<Complemento>no nulo</Complemento>\n";
        }
        
        if(Complementos.isAutoincrementable){
            cadena += "\t\t\t<Complemento>autoincrementable</Complemento>\n";
        }
        
        if(Complementos.isPrimary){
            cadena += "\t\t\t<Complemento>llave_primaria</Complemento>\n";
        }
        
        if(Complementos.isForanea){
            cadena += "\t\t\t<Complemento>\n"
                    + "\t\t\t\t<Foranea>\"" + Complementos.Foranea + "\"</Foranea>\n"
                    + "\t\t\t</Complemento>\n";
        }
        
        cadena += "\t\t</Campo>\n";

        return cadena;
    }
}
