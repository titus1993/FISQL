/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML.Usr;

import Static.Tools;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class usr {

    public String name, pass;
    public int type, state;
    public Date sesion;
    public ArrayList<permisosUsr> permisos;

    public usr(String _name, String _pass, int _type, int _state, String _sesion, ArrayList<permisosUsr> _permisos) {
        name = _name;
        pass = _pass;
        type = _type;
        state = _state;

        try {
            sesion = Tools.formatoFecha.parse(_sesion);
        } catch (ParseException e) {
            sesion = null;
        }
        
        permisos = _permisos;
    }
    
    public boolean startSesion(String _name, String _pass){
        if(name.equals(_name) && pass.equals(_pass)){
            state = 1;
            sesion = new Date();
            return true;
        }
        
        return false;
    }
}
