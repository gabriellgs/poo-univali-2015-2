/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.DAO;

import com.univali.model.Departamento;
import com.univali.model.Funcionario;
import com.univali.view.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Alef
 */
public class FuncionarioDAO {
    private static List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
    
    /**
     * Metodo responsável por inserir o funcionario na lista base de dados.
     * @param funcionario 
     */
    public static void insereFuncionario(Funcionario funcionario){
        listaFuncionario.add(funcionario);
    }
    
    /**
     * Metodo responsável por remover o funcionario da lista base de dados.
     * @param funcionario 
     */
    public static void removeFuncionario(Funcionario funcionario){
        listaFuncionario.remove(funcionario);
    }
    
    /**
     * Metodo responsável por limpar a base de dados de Funcionarios
     */
    public static void limparBase(){
        listaFuncionario.clear();
    }

    /**
     * Metodo responsável por buscar todos os funcionarios de um determinado departamento.
     * @param dep
     * @return Lista de funcionarios
     */
    public static List<Funcionario> getAllFuncionariosByDep(Departamento dep){
        List<Funcionario> lista = new ArrayList<Funcionario>();
        
        for (Funcionario func : listaFuncionario) {
            if(func.getDepartamento().getId() == dep.getId()){
                lista.add(func);
            }
        }
        
        return lista;
    }
    
    /**
     * Metodo responsável por retornar o maior salário entre funcionarios normais e diretores.
     * @return Funcionario
     */
    public static Funcionario getMaiorSalario(){
        Funcionario func = listaFuncionario.get(0);
        
        for (Funcionario funcionario : listaFuncionario) {
            if(funcionario.salarioLiquido() > func.salarioLiquido()){
                func = funcionario;
            }
        }
        return func;
    }
    
    /**
     * Metodo responsável por fazer a busca de um funcionario por sua matricula.
     * @param matricula
     * @return Funcionario
     */
    public static Funcionario getFuncionarioByMatricula(int matricula){
        Funcionario func = null;
        
        for(Funcionario funcionario : listaFuncionario) {
            if(funcionario.getMatricula() == matricula){
                func = funcionario;
            }
        }
        return func;
    }
    
    /**
     * Metodo responsável por mostrar a lista de funcionarios presentes no sistema.
     */
    public static void mostrarFuncionarios(){
        for(Funcionario funcionario: listaFuncionario){
            Console.printString(funcionario.getNome() + " - " + funcionario.salarioLiquido());
        }
    }
    
    /**
     * Metodo responsável por mostrar a lista de funcionarios presentes no sistema em ordem crescente.
     */
    public static void mostrarFuncionarioOrdem(){
        Collections.sort(listaFuncionario, new Comparator<Funcionario>(){

            @Override
            public int compare(Funcionario o1, Funcionario o2) {
                if(o1.salarioLiquido() > o2.salarioLiquido()){
                    return 1;
                } else {
                    if(o1.salarioLiquido() < o2.salarioLiquido()){
                        return -1;
                    } 
                }
                return 0;
            }
            
        });
        
        mostrarFuncionarios();
    }
}
