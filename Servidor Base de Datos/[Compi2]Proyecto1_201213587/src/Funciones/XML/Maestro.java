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
import java.util.ArrayList;

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

    public void GuardarMaestro() {
        GuardarUsuarios();
        GuardarBaseDatos();
    }

    private void GuardarUsuarios() {
        String cadena = "";
        for (int i = 0; i < Usuarios.size(); i++) {
            cadena = Usuarios.get(i).getXML();
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

    public void DLLCrearUsuario() {

    }

    public String DLLCrearBaseDatos(String nombre) {
        if (!existeBaseDatos(nombre)) {
            //primero creamos la carpeta de la base de datos
            String carpetaDB = Tools.localDb + "\\" + nombre;
            Tools.CrearCarpeta(carpetaDB);

            //creamos el archivo de la base de datos
            DataBase nueva = new DataBase(nombre, Tools.localDb + "\\");
        } else {
            //retornar error que ya existe
        }
        return "";
    }

    public boolean existeBaseDatos(String nombre) {
        for (int i = 0; i < BaseDatos.size(); i++) {
            if (BaseDatos.get(i).Nombre.equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}
