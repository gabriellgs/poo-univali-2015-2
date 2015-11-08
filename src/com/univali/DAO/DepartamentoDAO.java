/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.DAO;

import com.univali.model.Departamento;
import com.univali.view.Console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alef
 */
public class DepartamentoDAO {
    private static List<Departamento> listaDep = new ArrayList<Departamento>();
    
    /**
     * Metodo responsável por inserir um departamento na base de departamentos.
     * @param dep 
     */
    public static void insereDepartamento(Departamento dep){
        listaDep.add(dep);
    }
    
    /**
     * Metodo responsável por remover um departamento da base de departamentos.
     * @param dep 
     */
    public static void removerDepartamento(Departamento dep){
        listaDep.remove(dep);
    }
    
    /**
     * Metodo responsável por limpar a base de dados de departamentos.
     */
    public static void limparBase(){
        listaDep.clear();
    }
    
    /**
     * Metodo responsável por buscar um departamento na base de dados pelo seu id.
     * @param id
     * @return Departamento
     */
    public static Departamento getDepartamentoByID(int id){
        Departamento departamento = null;
        for (Departamento dep : listaDep) {
            if(dep.getId() == id){
                departamento = dep;
            }
        }
        
        return departamento;
    }
    
    /**
     * Metodo responsável por mostrar todos os departamentos cadastrados na base.
     */
    public static void mostrarDepartamentos(){
        for (Departamento dep : listaDep) {
            Console.printString(dep.getId() + " - " + dep.getNome());
        }
    }
}
