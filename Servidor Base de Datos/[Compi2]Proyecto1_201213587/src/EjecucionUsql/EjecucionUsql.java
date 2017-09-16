/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;

import Static.*;
import Funciones.Usql.*;
//import Interface.TitusNotificaciones;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Titus
 */
public class EjecucionUsql {

   
    public ArrayList<Simbolo> Global;

    public EjecucionUsql(ArrayList <Simbolo> Global) {
        this.Global = Global;       

    }

    public void Ejecutar() {
        PrimerPasada();
        FMetodo global = new FMetodo();
        
        global.EjecutarInstrucciones(Global);
    }
    
    public void PrimerPasada(){
        Tools.IniciarErrores();
    }


    
}
