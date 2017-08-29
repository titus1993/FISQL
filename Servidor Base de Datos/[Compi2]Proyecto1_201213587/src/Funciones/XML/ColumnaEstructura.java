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
    
    public ColumnaEstructura(){
        Complementos = new Complemento();
    }
}
