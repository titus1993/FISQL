/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Static.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Analisis.XML.Usuario.*;
import Funciones.XML.Usr.usr;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Maestro {

    public Maestro() {
        iniciarDB();
        /*try {
            File file = new File(ruta);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException ex) {
            
        }*/
    }

    private void iniciarDB() {
        File raiz = new File(Tools.local);

        if (!raiz.exists()) {
            crearDB(raiz);
        } else {
            cargar();
        }
    }

    private void cargar() {
        String texto = "";

        File usr = new File(Tools.localUsrXml);

        try {
            Scanner sc = new Scanner(usr);
            while (sc.hasNextLine()) {
                texto += sc.nextLine();
            }
            
            
            usrGrammar gramaticaUsuario = new usrGrammar(new java.io.StringReader(texto));
            ArrayList<usr> usuario = gramaticaUsuario.S();

            ArrayList<usr> usuario2 = usuario;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void crearDB(File raiz) {
        if (raiz.mkdirs()) {
            try {
                crearArchivos();
            } catch (IOException ex) {
                Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void crearArchivos() throws IOException {
        File ruta = new File(Tools.localUsrXml);
        Writer writer = null;
        //creacion del archivo xml de usuarios, inicialmente solo tiene el usuario admin
        if (!ruta.exists()) {
            ruta.createNewFile();

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(ruta), "utf-8"));
                writer.write("<usr>\n"
                        + "	<nombre>admin</nombre>\n"
                        + "	<pass>\"admin\"</pass>\n"
                        + "	<tipo>admin</tipo>\n"
                        + "	<estado>inactivo</estado>\n"
                        + "	<sesion>\"01-01-2010 00:00:00\"</sesion>\n"
                        + "	<permisos>		\n"
                        + "	</permisos>\n"
                        + "</usr>");
            } catch (IOException ex) {
                // report
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {/*ignore*/
                }
            }
        }
        //creacion del archivo xml maestro, inicialmente no tiene ninguna db
        ruta = new File(Tools.localMaestroXml);
        if (!ruta.exists()) {
            ruta.createNewFile();
        }

        //creaio de la carpeta donde estaran todas las db, inicialmente no existe ninguna
        ruta = new File(Tools.localDb);
        if (!ruta.exists()) {
            ruta.mkdirs();
        }
    }
}
