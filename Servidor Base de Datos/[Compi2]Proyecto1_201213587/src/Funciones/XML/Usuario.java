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

    public void DarPermisos(String tipo, String base, String nombreObjeto) {
        switch (tipo) {
            case Tools.permisoTabla:
                DarPermisosTabla(base, nombreObjeto);
                break;

            case Tools.permisoBase:
                DarPermisosBaseDatos(base);
                break;

            case Tools.permisoFunc:
                DarPermisosFuncion(base, nombreObjeto);
                break;

            case Tools.permisoProc:
                DarPermisosProcedimiento(base, nombreObjeto);
                break;

            case Tools.permisoObj:
                DarPermisosObjeto(base, nombreObjeto);
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

    public boolean ExisteTabla (String nombre, String tabla) {
        for (PermisosUsr tempo : permisos) {
            if (tempo.name.equals(nombre)) {
                if(tempo.existsTable(tabla)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean ExisteObjeto (String nombre, String objeto) {
        for (PermisosUsr tempo : permisos) {
            if (tempo.name.equals(nombre)) {
                if(tempo.existsObject(objeto)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean ExisteFuncion (String nombre, String funcion) {
        for (PermisosUsr tempo : permisos) {
            if (tempo.name.equals(nombre)) {
                if(tempo.existsFunction(funcion)){
                    return true;
                }
            }
        }
        return false;       
    }
    
    public boolean ExisteProcedimiento (String nombre, String tabla) {
        for (PermisosUsr tempo : permisos) {
            if (tempo.name.equals(nombre)) {
                if(tempo.existsProcedure(tabla)){
                    return true;
                }
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

    public void QuitarPermisosTabla(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (temp.existsTable(nombreobjeto)) {
                    temp.removeTable(name);
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

    public void QuitarPermisosObjeto(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (temp.existsObject(nombreobjeto)) {
                    temp.removeObject(nombreobjeto);
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

    public void QuitarPermisosFuncion(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (temp.existsFunction(nombreobjeto)) {
                    temp.removeFunction(nombreobjeto);
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

    public void QuitarPermisosProcedimiento(String base, String nombreobjeto) {
        for (PermisosUsr temp : permisos) {
            if (temp.name.equals(base)) {
                if (temp.existsProcedure(nombreobjeto)) {
                    temp.removeProcedure(nombreobjeto);
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
