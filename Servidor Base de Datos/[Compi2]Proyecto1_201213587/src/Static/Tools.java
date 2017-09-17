/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Static;

import EjecucionUsql.TablaSeleccionar;
import EjecucionUsql.TablaUsql;
import Funciones.XML.DataBase;
import Funciones.XML.Maestro;
import Funciones.XML.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Titus
 */
public class Tools {

    public static JTable TablaErrores;
    public static DefaultTableModel Error;
    
    public static JTextArea Consola = new JTextArea();

    public static String CadenaErrores = "";
    

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

    

    public static TablaUsql Tabla = new TablaUsql();
    
    public static TablaUsql Funciones = new TablaUsql();
    
    public static DataBase BaseActual = null;
    
    public static Usuario Usuario = null;
    
    public static Maestro Base_de_datos = new Maestro();
    
    public static TablaSeleccionar TablaPivote = null;
    
    public static TablaSeleccionar TablaResultado = null;
    
    public static void ImprimirConsola(String texto) {
        Consola.setText(Consola.getText() + ">> " + texto + "\n");
    }
    
    public static void ImprimirLog(String Accion, String Descripcion){
        ImprimirConsola("Fecha: " + formatoFecha.format(new Date()) + ", Usuario: " + Usuario.name + ", Accion: " + Accion + ", Descripcion: " + Descripcion);
    }
    
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
    
    public static void IniciarErrores() {
        String[] columnas = {"Tipo de error", "Descripcion", "Linea", "Columna"};
        Error = new DefaultTableModel(columnas, 0);
        TablaErrores = new JTable(Error);
    }

    public static void InsertarError(String tipo, String descripcion, int linea, int columna) {
        String[] error = {tipo, descripcion, String.valueOf(linea + 1), String.valueOf(columna + 1)};
        Error.addRow(error);
        CadenaErrores += "Error " + tipo + " en la linea: " + String.valueOf(linea) + ", columna: " + String.valueOf(columna) + "; Descripcion: " + descripcion + "\n";
        System.out.println("Error " + tipo + " en la linea: " + String.valueOf(linea) + ", columna: " + String.valueOf(columna) + "; Descripcion: " + descripcion + "\n");
    }

    public static boolean ContarErrores() {
        return Error.getRowCount() == 0;
    }

    public static void LimpiarTabla() {
        while (Error.getRowCount() > 0) {
            Error.removeRow(0);
        }
    }
}
