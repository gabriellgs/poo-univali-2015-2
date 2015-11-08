/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.DAO;

import com.univali.model.FuncionarioExterno;
import com.univali.view.Console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alef
 */
public class FuncionarioExternoDAO {
    private static List<FuncionarioExterno> listaFuncionarioExterno = new ArrayList<FuncionarioExterno>(); 
    
    /**
     * Metodo responsável por inserir um funcionario externo na lista base de dados.
     * @param funcExt 
     */
    public static void insereFuncionarioExterno(FuncionarioExterno funcExt){
        listaFuncionarioExterno.add(funcExt);
    }
    
    /**
     * Metodo responsável por remover um funcionario externo da lista base de dados.
     * @param funcExt 
     */
    public static void removeFuncionarioExterno(FuncionarioExterno funcExt){
        listaFuncionarioExterno.remove(funcExt);
    }
    
     /**
     * Metodo responsável por limpar a base de dados de Funcionarios Externos
     */
    public static void limparBase(){
        listaFuncionarioExterno.clear();
    }
    
    /**
     * Metodo responsável por encontrar e retornar um funcionario externo pelo seu rg.
     * @param rg
     * @return FuncionarioExterno
     */
    public static FuncionarioExterno getFuncionarioExtByRg(int rg){
        FuncionarioExterno func = null;
        
        for(FuncionarioExterno funcExt : listaFuncionarioExterno) {
            if(funcExt.getRg() == rg){
                func = funcExt;
            }
        }
        
        return func;    
    }
    
    /**
     * Metodo responsável por retornar o funcionario externo que tem o maior salario.
     * @return FuncionarioExterno
     */
    public static FuncionarioExterno getMaiorSalario(){
        FuncionarioExterno ext = listaFuncionarioExterno.get(0);
        
        for (FuncionarioExterno funcExt : listaFuncionarioExterno) {
            if(funcExt.salarioLiquido()> ext.salarioLiquido()){
                ext = funcExt;
            }
        }
        
        return ext;
    }
    
    /**
     * Metodo responsável por mostrar todos os funcionarios Externos.
     */
    public static void mostrarFuncionariosExt(){
        for (FuncionarioExterno funcExt : listaFuncionarioExterno) {
            Console.printString(funcExt.getNome() + " - " + funcExt.getSalarioBase());
        }
    }
    
}
