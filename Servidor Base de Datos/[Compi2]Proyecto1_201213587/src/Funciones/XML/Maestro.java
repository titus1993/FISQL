/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.XML.Maestro.*;
import Static.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Analisis.XML.Usuario.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class Maestro {

    ArrayList<Usuario> Usuarios = null;
    ArrayList<DataBase> BaseDatos = null;

    public Maestro() {
        iniciarDB();
    }

    public void Guardar() {
        GuardarMaestro();
        GuardarUsuarios();
        GuardarBaseDatos();
    }

    private void GuardarMaestro() {
        String cadena = "";

        for (DataBase temp : BaseDatos) {
            cadena += "<DB>\n"
                    + "\t<Nombre>\"" + temp.Nombre + "\"</Nombre>\n"
                    + "\t<Path>\"" + temp.Path + "\"</Path>\n"
                    + "</DB>\n";
        }

        Tools.guardarArchivo(Tools.localMaestroXml, cadena);
    }

    private void GuardarUsuarios() {
        String cadena = "";
        for (int i = 0; i < Usuarios.size(); i++) {
            cadena += Usuarios.get(i).getXML();
        }
        Tools.guardarArchivo(Tools.localUsrXml, cadena);
    }

    private void GuardarBaseDatos() {
        String cadena = "";
        for (int i = 0; i < BaseDatos.size(); i++) {
            DataBase temp = BaseDatos.get(i);
            temp.GuardarBaseDatos();
            cadena = temp.getXML();
            Tools.guardarArchivo(temp.Path, cadena);
        }
    }

    private void iniciarDB() {
        if (!Tools.Existe(Tools.local)) {
            CrearDB();
            Cargar();
        } else {
            Cargar();
        }
    }

    private void Cargar() {
        CargarUSuarios();
        CargarMaster();
        CargarDB();
    }

    private void CargarUSuarios() {
        try {
            if (Tools.Existe(Tools.localUsrXml)) {
                String texto = Tools.LeerArchivo(Tools.localUsrXml);

                usrGrammar gramaticaUsuario = new usrGrammar(new java.io.StringReader(texto));
                ArrayList<Usuario> usuario = gramaticaUsuario.S();

                Usuarios = usuario;
                System.out.println("Cargo Usuarios");
            } else {
                CrearUsuario();
                CargarUSuarios();
            }
        } catch (Analisis.XML.Usuario.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargarMaster() {
        try {
            if (Tools.Existe(Tools.localMaestroXml)) {
                String texto = Tools.LeerArchivo(Tools.localMaestroXml);

                maestroGrammar gramaticaDatos = new maestroGrammar(new java.io.StringReader(texto));
                ArrayList<DataBase> datos = gramaticaDatos.S();

                BaseDatos = datos;
                System.out.println("Cargo Base de datos");
            } else {
                CrearDB();
            }
        } catch (Analisis.XML.Maestro.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void CargarDB() {
        for (int i = 0; i < BaseDatos.size(); i++) {
            DataBase temp = BaseDatos.get(i);
            if (Tools.Existe(temp.Path)) {
                temp.Cargar();
                System.out.println("Existe");
            } else {
                System.out.println("No existe la base de datos " + temp.Nombre + "en la ruta " + temp.Path);
            }
        }
    }

    private void CrearDB() {
        if (Tools.CrearCarpeta(Tools.local)) {
            CrearArchivos();
        }
    }

    private void CrearArchivos() {
        CrearMaestro();
        CrearUsuario();
        CrearCarpetaDB();
    }

    private void CrearMaestro() {
        //creacion del archivo xml maestro, inicialmente no tiene ninguna db
        if (!Tools.Existe(Tools.localMaestroXml)) {
            Tools.crearArchivo(Tools.localMaestroXml, "");
        }
    }

    private void CrearCarpetaDB() {
        //creaio de la carpeta donde estaran todas las db, inicialmente no existe ninguna

        if (!Tools.Existe(Tools.localDb)) {
            Tools.CrearCarpeta(Tools.localDb);
        }
    }

    private void CrearUsuario() {
        String usuario = "<usr>\n"
                + "	<nombre>admin</nombre>\n"
                + "	<pass>\"admin\"</pass>\n"
                + "	<tipo>0</tipo>\n"
                + "	<estado>0</estado>\n"
                + "	<sesion>\"01-01-2010 00:00:00\"</sesion>\n"
                + "	<permisos>		\n"
                + "	</permisos>\n"
                + "</usr>";

        if (!Tools.crearArchivo(Tools.localUsrXml, usuario)) {
            //reportar error
        }
    }

    public Usuario ExisteUsuario(String nombre) {
        for (Usuario usr : Usuarios) {
            if (nombre.toLowerCase().equals(usr.name.toLowerCase())) {
                return usr;
            }
        }
        return null;
    }

    public String DLLCrearUsuario(String nombre, String pass) {
        if (ExisteUsuario(nombre) == null) {
            Usuario nuevo = new Usuario(nombre, pass, 1, 0, Tools.formatoFecha.format(new Date()), new ArrayList<PermisosUsr>());
            Usuarios.add(nuevo);
            this.Guardar();
        } else {
            //error que ya existe
        }

        return "";
    }

    public String DLLCrearBaseDatos(String nombre, String usuario) {
        if (ExisteBaseDatos(nombre) == null) {
            //primero creamos la carpeta de la base de datos
            String carpetaDB = Tools.localDb + "\\" + nombre;
            Tools.CrearCarpeta(carpetaDB);

            //creamos la instancia de la base de datos
            DataBase nueva = new DataBase(nombre, Tools.localDb + "\\" + nombre + "\\" + nombre + ".xml");

            //asignamos las rutas de los archivos xml
            nueva.RutaFuncion = Tools.localDb + "\\" + nombre + "\\Funciones.xml";
            nueva.RutaObjetos = Tools.localDb + "\\" + nombre + "\\Objetos.xml";
            nueva.RutaProcedimiento = Tools.localDb + "\\" + nombre + "\\Procedimientos.xml";

            //creamos los archivos xml de la base de datos
            Tools.crearArchivo(nueva.RutaFuncion, "");
            Tools.crearArchivo(nueva.RutaProcedimiento, "");
            Tools.crearArchivo(nueva.RutaObjetos, "");
            Tools.crearArchivo(nueva.Path, "");

            BaseDatos.add(nueva);

            DSLOtorgarPermisosBaseDatos(nombre, usuario);

            this.Guardar();
        } else {
            //retornar error que ya existe
        }
        return "";
    }

    public boolean DLLCrearFuncion(String base, String usuario, Funcion funcion) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Procedimiento p = db.ExisteProcedimiento(funcion.nombre);
            if (p == null) {
                Funcion f = db.ExisteFuncion(funcion.nombre);
                if (f == null) {
                    Usuario usr = ExisteUsuario(usuario);
                    if (usr != null) {
                        if (usr.ExisteBaseDatos(base)) {
                            db.Funciones.add(funcion);
                            DSLOtorgarPermisosFuncion(base, usuario, funcion.nombre);
                        } else {
                            //no tiene permisos sobre la base de datos
                        }
                    } else {
                        //no existe usuario
                    }
                } else {
                    //ya existe una funcion
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DLLCrearProcedimiento(String base, String usuario, Procedimiento proc) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Funcion f = db.ExisteFuncion(proc.nombre);
            if (f == null) {
                Procedimiento p = db.ExisteProcedimiento(proc.nombre);
                if (p == null) {
                    Usuario usr = ExisteUsuario(usuario);
                    if (usr != null) {
                        if (usr.ExisteBaseDatos(base)) {
                            db.Procedimientos.add(proc);
                            DSLOtorgarPermisosProcedimiento(base, usuario, proc.nombre);
                        } else {
                            //no tiene permisos sobre la base de datos
                        }
                    } else {
                        //no existe usuario
                    }
                } else {
                    //ya existe una funcion
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DLLCrearObjeto(String base, String usuario, Objeto obj) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Objeto o = db.ExisteObjeto(obj.nombre);
            if (o == null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    if (usr.ExisteBaseDatos(base)) {
                        db.Objetos.add(obj);
                        DSLOtorgarPermisosObjeto(base, usuario, obj.nombre);
                    } else {
                        //no tiene permisos sobre la base de datos
                    }
                } else {
                    //no existe usuario
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DLLCrearTabla(String base, String usuario, Tabla tabla) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Tabla t = db.ExisteTabla(tabla.Nombre);
            if (t == null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    if (usr.ExisteBaseDatos(base)) {
                        tabla.Path = Tools.getAbolutePath(db.Path) + "\\" + tabla.Nombre + ".xml";
                        Tools.crearArchivo(tabla.Path, "");
                        db.Tablas.add(tabla);
                        DSLOtorgarPermisosTabla(base, usuario, tabla.Nombre);
                    } else {
                        //no tiene permisos sobre la base de datos
                    }
                } else {
                    //no existe usuario
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DLLAlterTableAgregar(String base, String usuario, String tabla, ArrayList<ColumnaEstructura> columnas) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Tabla t = db.ExisteTabla(tabla);
            if (t != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    if (usr.ExisteBaseDatos(base) && usr.ExisteTabla(base, tabla)) {
                        if (db.PruebaAlterTablaAgregar(t.Nombre, columnas)) {
                            for (ColumnaEstructura nuevacol : columnas) {
                                t.Columnas.add(nuevacol);

                                Columna c;

                                if (nuevacol.Tipo == 0) {
                                    c = new Columna(nuevacol.TipoCampo, "");

                                } else {
                                    columnaObjeto co = new columnaObjeto(new ArrayList<>());
                                    Objeto obj = db.ExisteObjeto(nuevacol.TipoCampo);

                                    for (Parametro p : obj.parametros) {
                                        co.Filas.add(new Columna(p.tipo, ""));
                                    }

                                    c = new Columna(nuevacol.NombreCampo, co);

                                }

                                for (ArrayList<Columna> ac : t.Filas) {
                                    ac.add(c);
                                }
                            }
                            this.Guardar();
                        }
                    } else {
                        //no tiene permisos sobre la tabla
                    }
                } else {
                    //no existe usuario
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DLLAlterObjetoAgregar(String base, String usuario, String objeto, ArrayList<Parametro> columnas) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Objeto o = db.ExisteObjeto(objeto);
            if (o != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    if (usr.ExisteBaseDatos(base) && usr.ExisteObjeto(base, objeto)) {
                        if (db.PruebaAlterObjetoAgregar(o.nombre, columnas)) {
                            for (Parametro nuevapar : columnas) {
                                o.parametros.add(nuevapar);

                                for (Tabla tab : db.Tablas) {
                                    for (ArrayList<Columna> ce : tab.Filas) {
                                        for (Columna col : ce) {
                                            if (col.Tipo == 1) {
                                                if(col.Campo.equals(objeto)){
                                                    col.campoObjeto.Filas.add(new Columna(nuevapar.tipo, ""));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            this.Guardar();
                        }else{
                            //error 
                        }
                    } else {
                        //no tiene permisos sobre la tabla
                    }
                } else {
                    //no existe usuario
                }
            } else {
                //ya existe un procedimiento con ese nombre
            }
        }
        return true;
    }

    public boolean DSLOtorgarPermisosBaseDatos(String base, String usuario) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Usuario usr = ExisteUsuario(usuario);
            if (usr != null) {
                usr.DarPermisosBaseDatos(db.Nombre);
                this.Guardar();
                return true;
            }
        }
        return false;
    }

    public boolean DSLOtorgarPermisosObjeto(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Objeto obj = db.ExisteObjeto(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.DarPermisosBaseDatos(db.Nombre);
                    usr.DarPermisosObjeto(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLDenegarPermisosObjeto(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Objeto obj = db.ExisteObjeto(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.QuitarPermisosObjeto(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLOtorgarPermisosFuncion(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Funcion obj = db.ExisteFuncion(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.DarPermisosBaseDatos(db.Nombre);
                    usr.DarPermisosFuncion(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLDenegarPermisosFuncion(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Funcion obj = db.ExisteFuncion(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.QuitarPermisosFuncion(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLOtorgarPermisosProcedimiento(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Procedimiento obj = db.ExisteProcedimiento(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.DarPermisosBaseDatos(db.Nombre);
                    usr.DarPermisosProcedimiento(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLDenegarPermisosProcedimiento(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Procedimiento obj = db.ExisteProcedimiento(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.QuitarPermisosProcedimiento(db.Nombre, obj.nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLOtorgarPermisosTabla(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Tabla obj = db.ExisteTabla(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.DarPermisosBaseDatos(db.Nombre);
                    usr.DarPermisosTabla(db.Nombre, obj.Nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DSLDenegarPermisosTabla(String base, String usuario, String Objeto) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Tabla obj = db.ExisteTabla(Objeto);
            if (obj != null) {
                Usuario usr = ExisteUsuario(usuario);
                if (usr != null) {
                    usr.QuitarPermisosTabla(db.Nombre, obj.Nombre);
                    this.Guardar();
                    return true;
                }
            }
        }
        return false;
    }

    public DataBase ExisteBaseDatos(String nombre) {
        for (int i = 0; i < BaseDatos.size(); i++) {
            if (BaseDatos.get(i).Nombre.equals(nombre)) {
                return BaseDatos.get(i);
            }
        }
        return null;
    }
}
