/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Static;

import Funciones.XML.Maestro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Titus
 */
public class Tools {

    public static JTextArea Consola = new JTextArea();

    public static void ImprimirConsola(String texto) {
        Consola.setText(Consola.getText() + ">> " + texto + "\n");
    }

    public static String local = "C:\\FISQL_DB";
    public static String localUsrXml = "C:\\FISQL_DB\\users.xml";
    public static String localDb = "C:\\FISQL_DB\\DB";
    public static String localMaestroXml = "C:\\FISQL_DB\\maestro.xml";

    public static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static String ttext = "text";
    public static String tinteger = "integer";
    public static String tdouble = "double";
    public static String tbool = "bool";
    public static String tdate = "date";
    public static String tdatetime = "datetime";
    public static String tobjeto = "objeto";

    public static final String permisoTabla = "tabla";
    public static final String permisoBase = "base";
    public static final String permisoFunc = "func";
    public static final String permisoProc = "proc";
    public static final String permisoObj = "obj";

    public static Maestro Base_de_datos = new Maestro();

    public static String LeerArchivo(String ruta) {
        String contenido = "";
        try {
            File archivo = new File(ruta);

            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                contenido += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenido;
    }

    public static boolean CrearCarpeta(String ruta) {
        File archivo = new File(ruta);

        return archivo.mkdirs();
    }

    public static boolean crearArchivo(String ruta, String contenido) {
        File archivo = new File(ruta);
        Writer writer = null;
        //creacion del archivo xml de usuarios, inicialmente solo tiene el usuario admin
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();

                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(ruta), "utf-8"));
                writer.write(contenido);
                writer.close();

                return true;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

        return false;
    }

    public static boolean guardarArchivo(String ruta, String contenido) {
        File archivo = new File(ruta);
        Writer writer = null;
        //creacion del archivo xml de usuarios, inicialmente solo tiene el usuario admin
        if (archivo.exists()) {
            try {
                archivo.createNewFile();

                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(ruta), "utf-8"));
                writer.write(contenido);
                writer.close();

                return true;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

        return false;
    }

    public static boolean Existe(String ruta) {
        File archivo = new File(ruta);
        return archivo.exists();
    }

    public static String getAbolutePath(String ruta) {
        File f = new File(ruta);
        String path = "";
        path = f.getParent();
        return path;
    }
}
