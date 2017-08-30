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
        pass = _pass;
        type = _type;
        state = _state;
        _sesion = _sesion;

        try {
            sesion = Tools.formatoFecha.parse(_sesion);
        } catch (ParseException e) {
            sesion = new Date();
        }

        permisos = _permisos;
    }

    public void DarPermisos(String tipo, String user, String nombreObjeto) {
        switch (tipo) {
            case Tools.permisoTabla:
                break;

            case Tools.permisoBase:
                break;

            case Tools.permisoFunc:
                break;

            case Tools.permisoProc:
                break;

            case Tools.permisoObj:
                break;

        }
    }

    public void DarPermisosBaseDatos(String nombre) {
        if (!ExisteBaseDatos(nombre)) {
            permisos.add(new PermisosUsr(nombre, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()));
        }
    }

    public boolean ExisteBaseDatos(String nombre) {
        for (PermisosUsr tempo : permisos) {
            if (tempo.name.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void DarPermisosTabla(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (!temp.existsTable(nombreobjeto)) {
                    temp.addTable(nombreobjeto);
                }
                break;
            }
        }
    }

    public void DarPermisosObjeto(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (!temp.existsObject(nombreobjeto)) {
                    temp.addObject(nombreobjeto);
                }
                break;
            }
        }
    }
    
    public void DarPermisosFuncion(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (!temp.existsFunction(nombreobjeto)) {
                    temp.addFunction(nombreobjeto);
                }
                break;
            }
        }
    }
    
    public void DarPermisosProcedimiento(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (!temp.existsProcedure(nombreobjeto)) {
                    temp.addProcedure(nombreobjeto);
                }
                break;
            }
        }
    }

    public boolean startSesion(String _name, String _pass) {
        if (name.equals(_name) && pass.equals(_pass)) {
            state = 1;
            sesion = new Date();
            return true;
        }

        return false;
    }

    public String getXML() {
        String cadena = "";
        String tipo = "0";
        String estado = "0";

        if (this.type == 1) {
            tipo = "1";
        }

        if (this.state == 1) {
            estado = "1";
        }

        cadena += "<usr>\n"
                + "\t<nombre>" + name + "</nombre>\n"
                + "\t<pass>\"" + pass + "\"</pass>\n"
                + "\t<tipo>" + tipo + "</tipo>\n"
                + "\t<estado>" + estado + "</estado>\n"
                + "\t<sesion>\"" + Tools.formatoFecha.format(sesion) + "\"</sesion>\n"
                + "\t<permisos>\n";

        for (int i = 0; i < permisos.size(); i++) {
            cadena += permisos.get(i).getXML();
        }

        cadena += "\t</permisos>\n"
                + "</usr>\n";

        return cadena;
    }
}
