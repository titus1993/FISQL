/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi2.proyecto1_201213587;

import Funciones.XML.Maestro;
import Static.Tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Titus
 */
public class Compi2Proyecto1_201213587 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cargar();
        Tools.Base_de_datos.DLLCrearUsuario("anicka", "anicka");
        Tools.Base_de_datos.DLLCrearBaseDatos("DBAnicka","anicka");        
        //Tools.Base_de_datos.DMLOtorgarPermisosObjeto("DB1", "titus2", "nombre_obj1");
        
        Consola a = new Consola();
        a.setVisible(true);
    }    
    
    public static void Cargar(){
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\Usql\\usqlGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }    
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Maestro\\maestroGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\DB\\dbGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Tabla\\tablaGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Procedimiento\\procGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Funcion\\funcGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Objeto\\objGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmd = new String[4];
            cmd[0] = "cmd.exe";
            cmd[1] = "/C";
            cmd[2] = "javacc";
            cmd[3] = "D:\\Titus\\Documents\\Proyectos\\Compiladores 2\\Proyecto 1\\FISQL\\Servidor Base de Datos\\[Compi2]Proyecto1_201213587\\src\\Analisis\\XML\\Usuario\\usrGrammar.jj";
            /*
                        para poder ejecutar esta clase es necesario setear JavaCC a las varibles de entorno del sistema 
                        de tal forma que el simbolo del sistema (la terminal) reconozca el comando javacc o jjtree
             */
            Process proc = runtime.exec(cmd);
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.print(e.toString());
        }
    }
}
