/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi2.proyecto1_201213587;


import Funciones.XML.*;
import Static.Tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        //Tools.Base_de_datos.DLLCrearUsuario("masterchef", "master");
        //Tools.Base_de_datos.DLLCrearBaseDatos("dbnueva","masterchef");    
        //Tools.Base_de_datos.DMLCrearFuncion("dbnueva", "masterchef", new Funcion(Tools.tbool, "funcion5", "use db1;", new ArrayList<>()));
        //Tools.Base_de_datos.DMLCrearProcedimiento("dbnueva", "masterchef", new Procedimiento("proc3", "use proc1;", new ArrayList()));
        //ArrayList<Parametro> l = new ArrayList<>();
        //l.add(new Parametro(Tools.tinteger, "id"));
        //Tools.Base_de_datos.DMLCrearObjeto("dbnueva", "masterchef", new Objeto("obj9", l));
        
        //Tools.Base_de_datos.DMLOtorgarPermisosObjeto("DB1", "titus2", "nombre_obj1");
        
        //Metiendo una tabla
        /*ArrayList<ColumnaEstructura> lce = new ArrayList<>();
        ColumnaEstructura ce = new ColumnaEstructura();
        ce.NombreCampo = "col1";
        ce.Tipo = 0;
        ce.TipoCampo = Tools.ttext;
        lce.add(ce);
        Tabla t = new Tabla("tabla3", "", lce);
        t.Filas = new ArrayList<ArrayList<Columna>>();
        Columna c = new Columna(Tools.tinteger, "5");
        ArrayList<Columna> ac = new ArrayList<>();
        ac.add(c);
        t.Filas.add(ac);
        Tools.Base_de_datos.DMLCrearTabla("dbnueva", "masterchef", t);*/
        
        
        //prueba altertable
        /*ColumnaEstructura ce = new ColumnaEstructura();
        ce.Complementos.isAutoincrementable = true;
        ce.Tipo = 1;
        ce.TipoCampo = "obj2";
        ce.NombreCampo = "estenoesunobjeto";
        ArrayList<ColumnaEstructura> lce = new ArrayList<>();
        lce.add(ce);
        Tools.Base_de_datos.DLLAlterTable("dbnueva", "masterchef", "tabla3", lce);*/
        
        //prueba alter objeto agregar
        /*Parametro p = new Parametro(Tools.ttext, "nombre");
        ArrayList<Parametro> lp = new ArrayList<>();
        lp.add(p);              
        
        Tools.Base_de_datos.DLLAlterObjetoAgregar("dbnueva", "masterchef", "obj1", lp);*/
        
        
        
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
