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
public class Columna {

    public int Tipo;
    public String Campo, Valor;
    public columnaObjeto campoObjeto;

    public Columna(String _campo, String _valor) {
        Tipo = 0;
        Campo = _campo;
        Valor = _valor;
    }

    public Columna(String _campo, columnaObjeto _campoObjeto) {
        Tipo = 1;
        Campo = _campo;
        campoObjeto = _campoObjeto;
    }

    public String getXML() {
        String cadena = "";
        if (Tipo == 0) {
            cadena = "\t<" + Campo + ">\"" + Valor + "\"</" + Campo + ">\n";
        } else {
            cadena = "\t<" + Campo + ">\n"
                    + campoObjeto.getXML()
                    + "\t</" + Campo + ">\n";
        }
        return cadena;
    }

}
