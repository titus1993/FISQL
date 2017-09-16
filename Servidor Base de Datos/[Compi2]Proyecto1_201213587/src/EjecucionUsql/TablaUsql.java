/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjecucionUsql;

import Static.*;
import Funciones.Usql.*;
//import Interface.TitusNotificaciones;
import java.util.ArrayList;

/**
 *
 * @author Titus
 */
public class TablaUsql {

    public ArrayList<Variable> Tabla;

    public TablaUsql() {
        this.Tabla = new ArrayList<>();

    }

    public void ApartarInicio() {
        Tabla.add(null);
    }

    public void InsertarVariable(Variable var) {
        var.Nombre = var.Nombre.toLowerCase();
        Tabla.add(var);
    }

    public void SacarVariable() {
        Tabla.remove(Tabla.size() - 1);
    }

    public Variable BuscarFuncion(FLlamadaMetodo metodo, ArrayList<FNodoExpresion> parametros) {
        int i = 0;
        boolean encontrado = false;
        Variable aux = null;
        while (i < Tabla.size() && !encontrado) {
            Variable funcion = Tabla.get(i);
            if (funcion.Nombre.toLowerCase().equals(metodo.Nombre.toLowerCase()) && funcion.Rol.equals(Constante.TMetodo)) {
                FMetodo m = (FMetodo) funcion.Valor;

                if (m.Parametros.size() == parametros.size()) {
                    int j = 0;
                    boolean estado = true;
                    while (j < m.Parametros.size() && estado) {
                        FNodoExpresion exp = parametros.get(j);                        
                        if (!(exp.Tipo.equals(m.Parametros.get(j).Tipo) || (exp.Tipo.equals(Constante.TObjeto) && exp.Nombre.equals(m.Parametros.get(j).Tipo)))) {
                            estado = false;
                        }
                        j++;
                    }
                    if (estado) {
                        encontrado = !encontrado;
                        return funcion;
                    }
                }
            }
            i++;
        }
        return aux;
    }


    public Variable BuscarVariable(String nombre) {
        int cont = Tabla.size() - 1;
        boolean encontrado = false;
        Variable variable = null;
        while (cont >= 0 && /*TitusNotificaciones.ContarErrores() &&*/ !encontrado) {
            if (Tabla.get(cont).Nombre.toLowerCase().equals(nombre.toLowerCase()) && (Tabla.get(cont).Rol.equals(Constante.TVariable))) {
                variable = Tabla.get(cont);
                encontrado = !encontrado;
                break;
            }
            cont--;
        }
        return variable;
    }

   

    
    public void BorrarVariable(String nombre) {
        int i = Tabla.size() - 1;
        while (i >= 0) {
            if (Tabla.get(i).Nombre.toLowerCase().equals(nombre.toLowerCase()) && Tabla.get(i).Rol.equals(Constante.TVariable)) {
                Tabla.remove(i);
                break;
            }
            i--;
        }
    }

    public void SacarVariable(String nombre) {
        int cont = Tabla.size() - 1;
        boolean encontrado = false;
        while (cont >= 0 && /*TitusNotificaciones.ContarErrores() &&*/ !encontrado) {
            if (Tabla.get(cont).Nombre.equals(nombre) && (Tabla.get(cont).Rol.equals(Constante.TVariable))) {
                encontrado = !encontrado;
                Tabla.remove(cont);
            }
            cont--;
        }
    }

    public boolean IsDetener() {
        if(Tabla.size()==0){
            return false;
        }
        return Tabla.get(Tabla.size() - 1).Rol.equals(Constante.TDetener);
    }

    

    public boolean ExisteVariableTope(String nombre) {
        return Tabla.get(Tabla.size() - 1).Nombre.toLowerCase().equals(nombre.toLowerCase());
    }

    public Variable ObtenerTope() {
        return Tabla.get(Tabla.size() - 1);
    }

    public boolean IsRertorno() {
        if(Tabla.size()==0){
            return false;
        }
        return Tabla.get(Tabla.size() - 1).Rol.equals(Constante.TRetorno);
    }
}
