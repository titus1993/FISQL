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
public class Columna{
    int Tipo;
    String Campo, Valor;
    columnaObjeto campoObjeto;
    
    public Columna(String _campo, String _valor){
        Tipo = 0;
        Campo = _campo;
        Valor = _valor;
        
    }
    
    public Columna(String _campo, columnaObjeto _campoObjeto){
        Tipo = 1;
        Campo = _campo;
        campoObjeto = _campoObjeto;
    }
    
}
