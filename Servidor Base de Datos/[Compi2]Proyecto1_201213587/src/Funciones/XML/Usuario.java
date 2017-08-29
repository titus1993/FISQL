/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Static.Tools;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class Usuario {

    public String name, pass;
    public int type, state;
    public Date sesion;
    public ArrayList<PermisosUsr> permisos;

    public Usuario(String _name, String _pass, int _type, int _state, String _sesion, ArrayList<PermisosUsr> _permisos) {
        name = _name;
        pass = _pass.substring(1, _pass.length()-1);
        type = _type;
        state = _state;
        _sesion = _sesion.substring(1, _sesion.length()-1);
        
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
    
    
    public String getXML(){
        String cadena ="";
        String tipo = "0";
        String estado = "0";
        
        if(this.type == 1){
            tipo = "1";
        }
        
        if(this.state == 1){
            estado = "1";
        }
        
        cadena += "<usr>\n"
                + "\t<nombre>" + name + "</nombre>\n"
                + "\t<pass>\"" + pass + "\"</pass>\n"
                + "\t<tipo>" + tipo +"</tipo>\n"
                + "\t<estado>" + estado +"</estado>\n"
                + "\t<sesion>\"" + Tools.formatoFecha.format(sesion) + "\"</sesion>\n"
                + "\t<permisos>\n"
                ;
        
        for(int i =0; i < permisos.size(); i++){
            cadena += permisos.get(i).getXML();
        }
        
        cadena += "\t</permisos>\n"
                + "</usr>";
        
        return cadena;
    }
}
