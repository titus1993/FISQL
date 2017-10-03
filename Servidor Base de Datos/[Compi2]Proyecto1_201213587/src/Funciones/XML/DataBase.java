/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Analisis.Usql.usqlGrammar;
import Analisis.XML.DB.*;
import Analisis.XML.Funcion.*;
import Analisis.XML.Objeto.*;
import Analisis.XML.Procedimiento.*;
import Analisis.XML.Tabla.*;
import EjecucionUsql.EjecucionUsql;
import EjecucionUsql.Simbolo;
import EjecucionUsql.Variable;
import Funciones.Usql.FNodoExpresion;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Titus
 */
public class DataBase {

    public String Nombre, Path, RutaObjetos, RutaProcedimiento, RutaFuncion;
    public ArrayList<Objeto> Objetos = new ArrayList<Objeto>();
    public ArrayList<Procedimiento> Procedimientos = new ArrayList<>();
    public ArrayList<Funcion> Funciones = new ArrayList<>();
    public ArrayList<Tabla> Tablas = new ArrayList<>();

    public DataBase(String nombre, String path) {
        Nombre = nombre;
        Path = path;
    }

    public DataBase(String rutaprocedimiento, String rutafuncion, String rutaobjeto, ArrayList<Tabla> tablas) {
        RutaProcedimiento = rutaprocedimiento;
        RutaFuncion = rutafuncion;
        RutaObjetos = rutaobjeto;
        Tablas = tablas;
    }
    
    
    public void EliminarFuncionOProcedimiento(String nombre){
        for(Funcion f : Funciones){
            if(f.nombre.equals(nombre)){
                Funciones.remove(f);
                break;
            }
        }
        
        for(Procedimiento p : Procedimientos){
            if(p.nombre.equals(nombre)){
                Procedimientos.remove(p);
                break;
            }
        }
    }
    
    public void EliminarObeto(String nombre){
        for(Objeto o : Objetos){
            if(o.nombre.equals(nombre)){
                Objetos.remove(o);
                break;
            }
        }
    }
    
    public void EliminarTabla(String nombre){
        for(Tabla t : Tablas){
            if(t.Nombre.equals(nombre)){
                Tablas.remove(t);
                break;
            }
        }
    }

    public int PruebaInsertarTablaEspecial(String nombretabla, ArrayList<ColumnaEstructura> Columnas, ArrayList<FNodoExpresion> fila) {
        Tabla tabla = ExisteTabla(nombretabla);

        for (ColumnaEstructura colTabla : tabla.Columnas) {
            boolean bandera = false;
            int i=0;
            while (i < fila.size() && !bandera) {
                ColumnaEstructura colInsertar = Columnas.get(i);
                FNodoExpresion val = fila.get(i);
                if (colTabla.NombreCampo.toLowerCase().equals(colInsertar.NombreCampo.toLowerCase())) {
                    bandera = true;

                    if (!(val.Tipo.equals(colTabla.TipoCampo) || val.Cadena.equals(colTabla.TipoCampo))) {
                        //existe el campo pero no coinciden los tipo de datos
                        return 3;
                    }
                }
                i++;
            }
            if (!bandera) {
                if(!colTabla.Complementos.isNulo || colTabla.Complementos.isAutoincrementable){
                    
                }else if(colTabla.Complementos.isPrimary){
                    return 4;
                }else if(colTabla.Complementos.isNulo){
                    return 5;
                }
            }else{
                if(colTabla.Complementos.isAutoincrementable){
                    return 6;
                }
            }
        }

        return 0;
    }

    public int PruebaInsertarTablaNormal(String nombretabla, ArrayList<FNodoExpresion> fila) {
        Tabla tabla = ExisteTabla(nombretabla);

        int i = 0, j = 0;

        while (i < fila.size()) {
            FNodoExpresion valor = fila.get(i);
            ColumnaEstructura columna = tabla.Columnas.get(j);
            if (!valor.Tipo.equals(columna.TipoCampo)) {
                if (columna.TipoCampo.equals(Constante.TEntero) && columna.Complementos.isAutoincrementable) {
                    j++;
                } else if (valor.Tipo.equals(Constante.TObjeto) && valor.Cadena.equals(columna.TipoCampo)) {
                    j++;
                    i++;
                } else {
                    boolean bandera = false;

                    if ((valor.Tipo.equals(Constante.TCadena) && valor.Cadena.equals("") && !columna.Complementos.isNulo)) {
                        j++;
                        i++;
                        bandera = true;
                    } else {
                        //no puede insertar nulo a un campo no nulo
                        return 4;
                    }

                    if (!bandera) {
                        //no coinciden las columnas con los valores a insertar
                        return 3;
                    }
                }
            } else {
                if (columna.TipoCampo.equals(Constante.TEntero) && !columna.Complementos.isAutoincrementable) {

                    i++;
                    j++;
                } else if (valor.Tipo.equals(columna.TipoCampo)) {
                    i++;
                    j++;
                } else {
                    //no se puede insertar un valor a un campo autoincrementable
                    return 5;
                }
            }
        }

        return 0;
    }

    public int PruebaAlterTablaAgregar(String nombretabla, ArrayList<ColumnaEstructura> nuevas) {
        Tabla tabla = ExisteTabla(nombretabla);

        for (ColumnaEstructura col : nuevas) {
            //comprobamos que no exista mas de una primaria
            if (tabla.ExistePrimaria() && col.Complementos.isPrimary) {
                //Error ya existe una llave primaria
                return 4;
            }

            //comprobamos que no se repita el nombre
            for (ColumnaEstructura col2 : tabla.Columnas) {
                if (col.NombreCampo.toLowerCase().equals(col2.NombreCampo.toLowerCase())) {
                    //Error ya existe el nombre
                    return 5;
                }
            }

            //comprobamos que existe la tabla foranea con llave primaria
            if (col.Complementos.isForanea) {
                Tabla tablaforanea = ExisteTabla(col.Complementos.Foranea);
                if (tablaforanea != null) {
                    if (!tablaforanea.ExistePrimaria()) {
                        //Error la tabla no tiene una llave primaria para la relacion
                        return 6;
                    }
                } else {
                    //Error no existe la tabla para hacer la relacion foranea
                    return 7;
                }
            }

            if (col.Tipo != 0) {
                Objeto obj = ExisteObjeto(col.TipoCampo);
                if (obj == null) {
                    //Error no existe el objeto
                    return 7;
                }
            }
        }
        return 0;
    }

    public int PruebaAlterTablaQuitar(String nombretabla, ArrayList<ColumnaEstructura> nuevas) {
        Tabla tabla = ExisteTabla(nombretabla);

        for (ColumnaEstructura col : nuevas) {
            //comprobamos que no se quiera eliminar una llave primaria
            for (ColumnaEstructura ce : tabla.Columnas) {
                if (ce.NombreCampo.toLowerCase().equals(col.NombreCampo.toLowerCase())) {
                    if (ce.Complementos.isPrimary) {
                        return 4;
                    }
                }
            }

        }
        return 0;
    }

    public int PruebaAlterObjetoAgregar(String nombreobjeto, ArrayList<Parametro> nuevas) {
        Objeto objeto = ExisteObjeto(nombreobjeto);

        for (Parametro par : nuevas) {

            //comprobamos que no se repita el nombre
            for (Parametro par2 : objeto.parametros) {
                if (par.nombre.equals(par2.nombre)) {
                    //Error ya existe el nombre
                    return 4;
                }
            }
        }
        return 0;
    }
    
    public int PruebaAlterObjetoQuitar(String nombreobjeto, ArrayList<Parametro> nuevas) {
        Objeto objeto = ExisteObjeto(nombreobjeto);

        for (Parametro par : nuevas) {

            //comprobamos que no se repita el nombre
            for (Parametro par2 : objeto.parametros) {
                if (par.nombre.equals(par2.nombre)) {
                    //ya existe el nombre
                    return 0;
                }
            }
        }
        return 4;
    }

    public Tabla ExisteTabla(String nombre) {
        for (Tabla tab : Tablas) {
            if (tab.Nombre.toLowerCase().equals(nombre.toLowerCase())) {
                return tab;
            }
        }
        return null;
    }

    public Procedimiento ExisteProcedimiento(String nombre) {
        for (Procedimiento proc : Procedimientos) {
            if (proc.nombre.toLowerCase().equals(nombre.toLowerCase())) {
                return proc;
            }
        }
        return null;
    }

    public Funcion ExisteFuncion(String nombre) {
        for (Funcion fun : Funciones) {
            if (fun.nombre.toLowerCase().equals(nombre.toLowerCase())) {
                return fun;
            }
        }
        return null;
    }

    public Objeto ExisteObjeto(String nombre) {
        for (Objeto obj : Objetos) {
            if (obj.nombre.toLowerCase().equals(nombre.toLowerCase())) {
                return obj;
            }
        }
        return null;
    }

    public String getXML() {
        String cadena = "";

        cadena += "<Procedure>\n"
                + "\t<Path>\"" + RutaProcedimiento + "\"</Path>\n"
                + "</Procedure>\n"
                + "<Funcion>\n"
                + "\t<Path>\"" + RutaFuncion + "\"</Path>\n"
                + "</Funcion>\n"
                + "<Object>\n"
                + "\t<Path>\"" + RutaObjetos + "\"</Path>\n"
                + "</Object>\n";

        for (int i = 0; i < Tablas.size(); i++) {
            cadena += Tablas.get(i).getXML();
        }

        return cadena;
    }

    public void GuardarBaseDatos() {
        String cadena = "";
        for (int i = 0; i < Objetos.size(); i++) {
            Objeto temp = Objetos.get(i);
            cadena += temp.getXML();
        }
        Tools.guardarArchivo(RutaObjetos, cadena);

        cadena = "";
        for (int i = 0; i < Funciones.size(); i++) {
            Funcion temp = Funciones.get(i);
            cadena += temp.getXML();
        }
        Tools.guardarArchivo(RutaFuncion, cadena);

        cadena = "";
        for (int i = 0; i < Procedimientos.size(); i++) {
            Procedimiento temp = Procedimientos.get(i);
            cadena += temp.getXML();
        }
        Tools.guardarArchivo(RutaProcedimiento, cadena);

        for (int i = 0; i < Tablas.size(); i++) {
            Tabla temp = Tablas.get(i);
            temp.GuardarTabla();
        }
    }

    public void Cargar() {
        if (CargarDB()) {
            CargarProcedimientos();
            CargarFunciones();
            CargarObjetos();
            CargarTablas();
        }
    }

    public boolean CargarDB() {
        try {
            if (Tools.Existe(Path)) {
                String texto = Tools.LeerArchivo(Path);

                dbGrammar dbDatos = new dbGrammar(new java.io.StringReader(texto));
                DataBase datos = dbDatos.S();

                this.RutaFuncion = datos.RutaFuncion;
                this.RutaProcedimiento = datos.RutaProcedimiento;
                this.RutaObjetos = datos.RutaObjetos;
                this.Tablas = datos.Tablas;
                System.out.println("Cargo Base de datos");
                return true;
            } else {
                Tools.ImprimirConsola("La archivo xml de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.DB.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void CargarProcedimientos() {
        try {
            if (Tools.Existe(this.RutaProcedimiento)) {
                String texto = Tools.LeerArchivo(this.RutaProcedimiento);

                procGrammar procDatos = new procGrammar(new java.io.StringReader(texto));
                ArrayList<Procedimiento> datos = procDatos.S();

                this.Procedimientos = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de procedimientos de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Procedimiento.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarFunciones() {
        try {
            if (Tools.Existe(this.RutaFuncion)) {
                String texto = Tools.LeerArchivo(this.RutaFuncion);

                funcGrammar funcDatos = new funcGrammar(new java.io.StringReader(texto));
                ArrayList<Funcion> datos = funcDatos.S();

                this.Funciones = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de funciones de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Funcion.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarObjetos() {
        try {
            if (Tools.Existe(this.RutaObjetos)) {
                String texto = Tools.LeerArchivo(this.RutaObjetos);

                objGrammar objDatos = new objGrammar(new java.io.StringReader(texto));
                ArrayList<Objeto> datos = objDatos.S();

                this.Objetos = datos;

                System.out.println("Cargo Base de datos");
            } else {
                Tools.ImprimirConsola("La archivo xml de objetos de la base de datos " + this.Nombre + " no existe.");
            }
        } catch (Analisis.XML.Objeto.ParseException ex) {
            Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarTablas() {
        for (int i = 0; i < Tablas.size(); i++) {
            try {
                Tabla temp = Tablas.get(i);
                if (Tools.Existe(temp.Path)) {
                    String texto = Tools.LeerArchivo(temp.Path);

                    tablaGrammar tablaDatos = new tablaGrammar(new java.io.StringReader(texto));
                    ArrayList<ArrayList<Columna>> datos = tablaDatos.S();

                    temp.Filas = datos;

                    System.out.println("Cargo Base de datos");
                } else {
                    Tools.ImprimirConsola("La archivo xml de tablas de la base de datos " + this.Nombre + " no existe.");
                }
            } catch (Analisis.XML.Tabla.ParseException ex) {
                Logger.getLogger(Maestro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
