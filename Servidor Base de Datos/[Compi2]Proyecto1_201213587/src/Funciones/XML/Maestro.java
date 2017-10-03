/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.Usql.usqlGrammar;
import Analisis.XML.Maestro.*;
import Static.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Analisis.XML.Usuario.*;
import EjecucionUsql.EjecucionUsql;
import EjecucionUsql.Simbolo;
import EjecucionUsql.TablaUsql;
import EjecucionUsql.Variable;
import Funciones.Usql.FNodoExpresion;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Titus
 */
public class Maestro {

    public ArrayList<Usuario> Usuarios = null;
    public ArrayList<DataBase> BaseDatos = null;

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

    public int DLLCrearUsuario(String nombre, String pass) {
        if (Tools.Usuario.type == 0) {
            if (ExisteUsuario(nombre) == null) {
                Usuario nuevo = new Usuario(nombre, pass, 1, 0, Tools.formatoFecha.format(new Date()), new ArrayList<PermisosUsr>());
                Usuarios.add(nuevo);
                this.Guardar();
            } else {
                //error que ya existe
                return 2;
            }
        } else {
            //error solo admin puede
            return 1;
        }
        return 0;
    }

    public boolean DLLUsarBaseDatos(String base, String usuario) {
        DataBase db = ExisteBaseDatos(base);
        if (db != null) {
            Tools.BaseActual = db;
            try {
                //Inicializamos las funciones que existen en la base de datos a la memoria
                Tools.Funciones = new TablaUsql();
                //cargamos los procedimientos a memoria
                for (Procedimiento p : Tools.BaseActual.Procedimientos) {

                    usqlGrammar proc = new usqlGrammar(new java.io.StringReader(p.src));
                    EjecucionUsql procm = proc.S();

                    for (Simbolo s : procm.Global) {
                        Tools.Funciones.InsertarVariable(new Variable(s.Tipo, s.Nombre, Constante.TMetodo, s.Fila, s.Columna, s.Ambito, s.Valor));
                    }
                }

                //cargamos las funciones a memoria
                for (Funcion p : Tools.BaseActual.Funciones) {

                    usqlGrammar proc = new usqlGrammar(new java.io.StringReader(p.src));
                    EjecucionUsql procm = proc.S();

                    for (Simbolo s : procm.Global) {
                        Tools.Funciones.InsertarVariable(new Variable(s.Tipo, s.Nombre, Constante.TMetodo, s.Fila, s.Columna, s.Ambito, s.Valor));
                    }
                }

            } catch (Analisis.Usql.ParseException ex) {
                Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean DLLCrearBaseDatos(String nombre, String usuario) {
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
            return false;
        }
        return true;
    }

    public int DLLCrearFuncion(Funcion funcion) {
        if (Tools.BaseActual != null) {
            Procedimiento p = Tools.BaseActual.ExisteProcedimiento(funcion.nombre);
            if (p == null) {
                Funcion f = Tools.BaseActual.ExisteFuncion(funcion.nombre);
                if (f == null) {

                    Tools.BaseActual.Funciones.add(funcion);
                    DSLOtorgarPermisosBaseDatos(Tools.BaseActual.Nombre, Tools.Usuario.name);
                    DSLOtorgarPermisosFuncion(Tools.BaseActual.Nombre, Tools.Usuario.name, funcion.nombre);

                } else {
                    //ya existe una funcion
                    return 3;
                }
            } else {
                //ya existe un procedimiento con ese nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public int DLLCrearProcedimiento(Procedimiento proc) {

        if (Tools.BaseActual != null) {
            Funcion f = Tools.BaseActual.ExisteFuncion(proc.nombre);
            if (f == null) {
                Procedimiento p = Tools.BaseActual.ExisteProcedimiento(proc.nombre);
                if (p == null) {
                    Tools.BaseActual.Procedimientos.add(proc);
                    DSLOtorgarPermisosBaseDatos(Tools.BaseActual.Nombre, Tools.Usuario.name);
                    DSLOtorgarPermisosProcedimiento(Tools.BaseActual.Nombre, Tools.Usuario.name, proc.nombre);
                } else {
                    //ya existe una funcion
                    return 3;
                }
            } else {
                //ya existe un procedimiento con ese nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public int DLLCrearObjeto(Objeto obj) {
        if (Tools.BaseActual != null) {
            Objeto o = Tools.BaseActual.ExisteObjeto(obj.nombre);
            if (o == null) {
                Tools.BaseActual.Objetos.add(obj);
                DSLOtorgarPermisosBaseDatos(Tools.BaseActual.Nombre, Tools.Usuario.name);
                DSLOtorgarPermisosObjeto(Tools.BaseActual.Nombre, Tools.Usuario.name, obj.nombre);
            } else {
                //ya existe un objeto con ese nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public int DLLCrearTabla(Tabla tabla) {
        if (Tools.BaseActual != null) {
            Tabla t = Tools.BaseActual.ExisteTabla(tabla.Nombre);
            if (t == null) {
                tabla.Path = Tools.getAbolutePath(Tools.BaseActual.Path) + "\\" + tabla.Nombre + ".xml";
                Tools.crearArchivo(tabla.Path, "");
                Tools.BaseActual.Tablas.add(tabla);
                DSLOtorgarPermisosBaseDatos(Tools.BaseActual.Nombre, Tools.Usuario.name);
                DSLOtorgarPermisosTabla(Tools.BaseActual.Nombre, Tools.Usuario.name, tabla.Nombre);
            } else {
                //error ya existe una tabla con el mismo nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public String Backup(){
        String cadena = "CREAR BASE_DATOS " + Tools.BaseActual.Nombre + ";\n";
        cadena += "USAR " + Tools.BaseActual.Nombre + ";\n";
        for(Objeto o : Tools.BaseActual.Objetos){
            cadena+= o.getCadena() + "\n";
        }
        
        for(Tabla t : Tools.BaseActual.Tablas){
            cadena += t.getCadena() + "\n";
        }
        
        for(Funcion f : Tools.BaseActual.Funciones){
            cadena += f.getCadena().trim() + "\n";
        }
        
        for(Procedimiento p : Tools.BaseActual.Procedimientos){
            cadena += p.getCadena().trim() + "\n";
        }
        
        return cadena;
    }
    
    public int DMLInsertarTablaEspecial(String tabla, ArrayList<ColumnaEstructura> Columnas, ArrayList<FNodoExpresion> Fila) {

        if (Tools.BaseActual != null) {
            Tabla t = Tools.BaseActual.ExisteTabla(tabla);
            if (t != null) {
                int resultado = Tools.BaseActual.PruebaInsertarTablaEspecial(tabla, Columnas, Fila);
                if (resultado == 0) {
                    t.InsertarEspecial(Columnas, Fila);
                    this.Guardar();
                } else {
                    return resultado;
                }
            } else {
                //no existe tabla
                return 2;
            }
        } else {
            //no ha seleccionado base de datos
            return 1;
        }

        return 0;
    }

    public int DMLInsertarTablaNormal(String tabla, ArrayList<FNodoExpresion> Fila) {

        if (Tools.BaseActual != null) {
            Tabla t = Tools.BaseActual.ExisteTabla(tabla);
            if (t != null) {
                int resultado = Tools.BaseActual.PruebaInsertarTablaNormal(tabla, Fila);
                if (resultado == 0) {
                    t.InsertarNormal(Fila);
                    this.Guardar();
                } else {
                    return resultado;
                }
            } else {
                //no existe tabla
                return 2;
            }
        } else {
            //no ha seleccionado base de datos
            return 1;
        }

        return 0;
    }

    public int DLLEliminarUsuario(String usuario) {
        Usuario usr = Tools.Base_de_datos.ExisteUsuario(usuario);
        if (usr != null) {
            if (Tools.Usuario.type == 0) {
                if (usr.type != 0) {
                    this.Usuarios.remove(usr);
                    this.Guardar();
                } else {
                    //no se puede eliminar al admin
                    return 3;
                }
            } else {
                //no tiene permisos para editar usuario
                return 2;
            }
        } else {
            //No existe usuario
            return 1;
        }
        return 0;
    }

    public int DLLEliminarFuncionProcedimiento(String funcion) {
        if (Tools.BaseActual != null) {
            if (Tools.Usuario.ExisteFuncion(Tools.BaseActual.Nombre, funcion) || Tools.Usuario.ExisteProcedimiento(Tools.BaseActual.Nombre, funcion) || Tools.Usuario.type == 0) {
                Tools.BaseActual.EliminarFuncionOProcedimiento(funcion);
                this.Guardar();
            } else {
                //no exite o no tiene permisos para editar usuario
                return 2;
            }

        } else {
            return 1;
        }

        return 0;
    }

    public int DLLEliminarObjeto(String nombre) {
        if (Tools.BaseActual != null) {
            if (Tools.Usuario.ExisteObjeto(Tools.BaseActual.Nombre, nombre) || Tools.Usuario.type == 0) {
                Tools.BaseActual.EliminarObeto(nombre);
                this.Guardar();
            } else {
                //no exite o no tiene permisos para editar usuario
                return 2;
            }

        } else {
            return 1;
        }

        return 0;
    }

    public int DLLEliminarTabla(String nombre) {
        if (Tools.BaseActual != null) {
            if (Tools.Usuario.ExisteTabla(Tools.BaseActual.Nombre, nombre) || Tools.Usuario.type == 0) {
                Tools.BaseActual.EliminarTabla(nombre);
                this.Guardar();
            } else {
                //no exite o no tiene permisos para editar usuario
                return 2;
            }

        } else {
            return 1;
        }

        return 0;
    }

    public int DLLEliminarBaseDatos(String nombre) {

        if (Tools.Usuario.type == 0) {
            int i = 0;
            boolean encontrado = false;

            for (DataBase b : this.BaseDatos) {
                if (b.Nombre.equals(nombre)) {
                    encontrado = true;
                    break;
                }
                i++;
            }

            if (encontrado) {
                this.BaseDatos.remove(i);
                this.Guardar();
            } else {
                return 2;
                //no existe la base de datos
            }
        } else {
            //no exite o no tiene permisos para editar usuario
            return 1;
        }

        return 0;
    }

    public int DLLAlterUsuario(String usuario, String pass) {

        Usuario usr = Tools.Base_de_datos.ExisteUsuario(usuario);
        if (usr != null) {
            if (Tools.Usuario.type == 0) {
                usr.pass = pass;
                this.Guardar();
            } else {
                //no tiene permisos para editar usuario
                return 2;
            }
        } else {
            //No existe usuario
            return 1;
        }
        return 0;
    }

    public int DLLAlterTableAgregar(String tabla, ArrayList<ColumnaEstructura> columnas) {

        if (Tools.BaseActual != null) {
            Tabla t = Tools.BaseActual.ExisteTabla(tabla);
            if (t != null) {
                if (Tools.Usuario.ExisteBaseDatos(Tools.BaseActual.Nombre) && Tools.Usuario.ExisteTabla(Tools.BaseActual.Nombre, tabla) || Tools.Usuario.type == 0) {
                    int resultado = Tools.BaseActual.PruebaAlterTablaAgregar(t.Nombre, columnas);
                    if (resultado == 0) {
                        for (ColumnaEstructura nuevacol : columnas) {
                            t.Columnas.add(nuevacol);

                            Columna c;

                            if (nuevacol.Tipo == 0) {
                                c = new Columna(nuevacol.TipoCampo, "");

                            } else {
                                columnaObjeto co = new columnaObjeto(new ArrayList<>());
                                Objeto obj = Tools.BaseActual.ExisteObjeto(nuevacol.TipoCampo);

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
                    } else {
                        return resultado;
                    }
                } else {
                    //no tiene permisos sobre la tabla
                    return 3;
                }
            } else {
                //No existe tabla
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    //Titus aqui te quedaste ahi te acuerdas pilas con el USQL :P
    public int DLLAlterTableQuitar(String tabla, ArrayList<ColumnaEstructura> columnas) {
        if (Tools.BaseActual != null) {
            Tabla t = Tools.BaseActual.ExisteTabla(tabla);
            if (t != null) {
                if (Tools.Usuario.ExisteBaseDatos(Tools.BaseActual.Nombre) && Tools.Usuario.ExisteTabla(Tools.BaseActual.Nombre, tabla) || Tools.Usuario.type == 0) {
                    int resultado = Tools.BaseActual.PruebaAlterTablaQuitar(t.Nombre, columnas);

                    if (resultado == 0) {
                        for (ColumnaEstructura nuevacol : columnas) {
                            t.QuitarCampo(nuevacol.NombreCampo);
                        }
                        this.Guardar();
                    } else {
                        return resultado;
                    }
                } else {
                    //no tiene permisos sobre la tabla
                    return 3;
                }
            } else {
                //no existe la tabla
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public int DLLAlterObjetoAgregar(String objeto, ArrayList<Parametro> columnas) {

        if (Tools.BaseActual != null) {
            Objeto o = Tools.BaseActual.ExisteObjeto(objeto);
            if (o != null) {
                if (Tools.Usuario.ExisteBaseDatos(Tools.BaseActual.Nombre) && Tools.Usuario.ExisteObjeto(Tools.BaseActual.Nombre, objeto)) {
                    int resultado = Tools.BaseActual.PruebaAlterObjetoAgregar(o.nombre, columnas);
                    if (resultado == 0) {
                        for (Parametro nuevapar : columnas) {
                            o.parametros.add(nuevapar);

                            for (Tabla tab : Tools.BaseActual.Tablas) {
                                for (ArrayList<Columna> ce : tab.Filas) {
                                    for (Columna col : ce) {
                                        if (col.Tipo == 1) {
                                            if (col.Campo.equals(objeto)) {
                                                col.campoObjeto.Filas.add(new Columna(nuevapar.tipo, ""));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        this.Guardar();
                    } else {
                        return resultado;
                    }
                } else {
                    //no tiene permisos sobre la tabla
                    return 3;
                }
            } else {
                //ya existe un procedimiento con ese nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }

    public int DLLAlterObjetoQuitar(String objeto, ArrayList<Parametro> columnas) {

        if (Tools.BaseActual != null) {
            Objeto o = Tools.BaseActual.ExisteObjeto(objeto);
            if (o != null) {
                if (Tools.Usuario.ExisteBaseDatos(Tools.BaseActual.Nombre) && Tools.Usuario.ExisteObjeto(Tools.BaseActual.Nombre, objeto)) {
                    int resultado = Tools.BaseActual.PruebaAlterObjetoQuitar(o.nombre, columnas);
                    if (resultado == 0) {
                        for (Parametro nuevapar : columnas) {
                            int posremove = o.QuitarObjeto(nuevapar.nombre);

                            for (Tabla tab : Tools.BaseActual.Tablas) {
                                for (ArrayList<Columna> ce : tab.Filas) {
                                    for (Columna col : ce) {
                                        if (col.Tipo == 1) {
                                            if (col.Campo.equals(objeto)) {
                                                col.campoObjeto.Filas.remove(posremove);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        this.Guardar();
                    } else {
                        return resultado;
                    }
                } else {
                    //no tiene permisos sobre la tabla
                    return 3;
                }
            } else {
                //ya existe un procedimiento con ese nombre
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
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
