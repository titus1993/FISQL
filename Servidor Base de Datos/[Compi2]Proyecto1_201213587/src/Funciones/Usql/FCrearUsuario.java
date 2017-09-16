/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.Usql;

import EjecucionUsql.Ambito;
import Funciones.XML.ColumnaEstructura;
import Funciones.XML.Tabla;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class FCrearUsuario {
    public Ambito Ambito;
    public Ambito Padre;
    String Nombre, Contraseña;
    public int Fila, Columna;

    public FCrearUsuario(String Nombre, String Contraseña, Ambito Ambito, int Fila, int Columna) {
        this.Padre = null;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.Ambito = Ambito;
        this.Fila = Fila;
        this.Columna = Columna;
    }

    public void Ejecutar() {
        switch(Tools.Base_de_datos.DLLCrearUsuario(this.Nombre, this.Contraseña)){
            case 1:
                Tools.InsertarError(Constante.TErrorSemantico, "Solo un usuario con permisos de administrador puede crear mas usuarios.", Fila, Columna);
                break;

            case 2:
                Tools.InsertarError(Constante.TErrorSemantico, "El usuario " + this.Nombre + " ya esta registrado.", Fila, Columna);
                break;
                
            default:
                Tools.ImprimirLog("Crear Usuario", "Se creo el usuario " + this.Nombre);
                break;
        }
        
    }
    
    public String getCadena(){
        return "CREAR USUARIO " + this.Nombre + " COLOCAR PASSWORD = \"" + this.Contraseña + "\";\n"; 
    }
}
