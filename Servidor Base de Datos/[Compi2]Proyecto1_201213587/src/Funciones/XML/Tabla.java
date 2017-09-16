/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import Funciones.Usql.FNodoExpresion;
import Funciones.Usql.FObjeto;
import Static.Constante;
import Static.Tools;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class Tabla {

    public ArrayList<ColumnaEstructura> Columnas;
    public String Nombre, Path;
    public int Autoincrementable;
    public ArrayList<ArrayList<Columna>> Filas;

    public Tabla(String nombre, String path, String val, ArrayList<ColumnaEstructura> columnas) {
        Nombre = nombre;
        Path = path;
        Columnas = columnas;
        this.Filas = new ArrayList<ArrayList<Columna>>();
        this.Autoincrementable = Integer.parseInt(val);
    }

    public void InsertarEspecial(ArrayList<ColumnaEstructura> columnas, ArrayList<FNodoExpresion> fila) {
        
        ArrayList<Columna> nuevafila = new ArrayList<Columna>();

        for (ColumnaEstructura col : this.Columnas) {
            boolean bandera = false;
            int i =0;
            while (i < columnas.size()) {
                ColumnaEstructura coltemp = columnas.get(i);
                if (col.NombreCampo.equals(coltemp.NombreCampo)) {
                    bandera = true;
                    if (col.TipoCampo.equals(Constante.TEntero) || col.TipoCampo.equals(Constante.TDecimal) || col.TipoCampo.equals(Constante.TBool) || col.TipoCampo.equals(Constante.TCadena)
                            || col.TipoCampo.equals(Constante.TDate) || col.TipoCampo.equals(Constante.TDateTime)) {

                        nuevafila.add(new Columna(col.NombreCampo, fila.get(i).Cadena));
                        i++;
                    } else {
                        FObjeto a = fila.get(i).Objeto;
                        nuevafila.add(new Columna(col.NombreCampo, a.GetDatos()));
                    }
                    break;
                }
                i++;
            }

            if (!bandera) {
                if (col.Complementos.isAutoincrementable) {
                    this.Autoincrementable++;
                    nuevafila.add(new Columna(col.NombreCampo, String.valueOf(this.Autoincrementable)));
                } else {
                    if (col.TipoCampo.equals(Constante.TEntero) || col.TipoCampo.equals(Constante.TDecimal) || col.TipoCampo.equals(Constante.TBool) || col.TipoCampo.equals(Constante.TCadena)
                            || col.TipoCampo.equals(Constante.TDate) || col.TipoCampo.equals(Constante.TDateTime)) {

                        nuevafila.add(new Columna(col.NombreCampo, ""));
                        i++;
                    } else {
                        Objeto o = Tools.BaseActual.ExisteObjeto(col.TipoCampo);
                        if (o != null) {
                            FObjeto a = o.ObtenerObjeto();
                            nuevafila.add(new Columna(col.NombreCampo, a.GetDatos()));
                        }
                    }
                }
            }
        }
        this.Filas.add(nuevafila);
    }

    public void InsertarNormal(ArrayList<FNodoExpresion> fila) {
        int i = 0;
        ArrayList<Columna> nuevafila = new ArrayList<Columna>();

        for (ColumnaEstructura col : Columnas) {
            if (col.Complementos.isAutoincrementable) {
                this.Autoincrementable++;
                nuevafila.add(new Columna(col.NombreCampo, String.valueOf(this.Autoincrementable)));
            } else {
                if (col.TipoCampo.equals(Constante.TEntero) || col.TipoCampo.equals(Constante.TDecimal) || col.TipoCampo.equals(Constante.TBool) || col.TipoCampo.equals(Constante.TCadena)
                        || col.TipoCampo.equals(Constante.TDate) || col.TipoCampo.equals(Constante.TDateTime)) {

                    nuevafila.add(new Columna(col.NombreCampo, fila.get(i).Cadena));
                    i++;
                } else {
                    FObjeto a = fila.get(i).Objeto;
                    nuevafila.add(new Columna(col.NombreCampo, a.GetDatos()));
                }
            }
        }
        this.Filas.add(nuevafila);
    }

    public boolean ExistePrimaria() {
        for (ColumnaEstructura col : Columnas) {
            if (col.Complementos.isPrimary) {
                return true;
            }
        }
        return false;
    }

    public void AgregarCampo(ColumnaEstructura c) {
        Columnas.add(c);
    }

    public void QuitarCampo(String c) {
        int pos = PosColumna(c);

        if (pos >= 0) {
            Columnas.remove(pos);
            for (int i = 0; i < Filas.size(); i++) {
                Filas.get(i).remove(pos);
            }
        }
    }

    public int PosColumna(String nombre) {
        for (int i = 0; i < Columnas.size(); i++) {
            if (Columnas.get(i).NombreCampo.equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public String getXML() {
        String cadena = "";

        cadena += "<Tabla>\n"
                + "\t<Nombre>\"" + Nombre + "\"</Nombre>\n"
                + "\t<Path>\"" + Path + "\"</Path>\n"
                + "\t<" + String.valueOf(this.Autoincrementable) + ">\n"
                + "\t<Rows>\n";

        for (int i = 0; i < Columnas.size(); i++) {
            cadena += Columnas.get(i).getXML();
        }

        cadena += "\t</Rows>\n"
                + "</Tabla>\n";

        return cadena;
    }

    public void GuardarTabla() {
        String cadena = "";
        for (int i = 0; i < Filas.size(); i++) {
            ArrayList<Columna> temp = Filas.get(i);
            cadena += "<Row>\n";
            for (Columna celda : temp) {
                cadena += celda.getXML();
            }
            cadena += "</Row>\n";
        }

        Tools.guardarArchivo(Path, cadena);
    }
}
