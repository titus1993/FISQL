/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones.XML;

import java.util.ArrayList;

/**
 Clase que contiene el listado de objetos en que un usuario tiene permisos, si no existe el nombre del objeto no tiene permisos.
 * @author Titus
 */
public class PermisosUsr {

    String name;
    ArrayList<String> tables, objects, functions, procedures;

    public PermisosUsr(String _name, ArrayList<String> _tables, ArrayList<String> _objects, ArrayList<String> _functions, ArrayList<String> _procedures) {
        name = _name;
        tables = _tables;
        objects = _objects;
        functions = _functions;
        procedures = _procedures;
    }
    
    public void addTable(String _name){
        tables.add(_name);
    }
    
    public void addObject(String _name){
        objects.add(_name);
    }
    
    public void addFunction(String _name){
        functions.add(_name);
    }
    
    public void addProcedure(String _name){
        procedures.add(_name);
    }
    
    public void removeTable(String _name){
        tables.remove(_name);
    }
    
    public void removeObject(String _name){
        objects.remove(_name);
    }
    
    public void removeFunction(String _name){
        functions.remove(_name);
    }
    
    public void removeProcedure(String _name){
        procedures.remove(_name);
    }
    
    public boolean existsTable(String _name){
        for(int i=0;i< tables.size();i++){
            if(tables.get(i).equals(_name)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsObject(String _name){
        for(int i=0;i< objects.size();i++){
            if(objects.get(i).equals(_name)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsFunction(String _name){
        for(int i=0;i< functions.size();i++){
            if(functions.get(i).equals(_name)){
                return true;
            }
        }
        return false;
    }
    
    public boolean existsProcedure(String _name){
        for(int i=0;i< procedures.size();i++){
            if(procedures.get(i).equals(_name)){
                return true;
            }
        }
        return false;
    }
}
