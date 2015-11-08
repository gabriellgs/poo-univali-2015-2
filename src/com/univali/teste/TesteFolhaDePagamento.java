/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.teste;

import com.univali.DAO.DepartamentoDAO;
import com.univali.DAO.FuncionarioDAO;
import com.univali.DAO.FuncionarioExternoDAO;
import com.univali.DAO.CargaBaseDados;
import com.univali.model.Diretor;
import com.univali.model.Funcionario;
import com.univali.model.FuncionarioExterno;
import com.univali.view.Console;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Alef
 */
public class TesteFolhaDePagamento extends Teste {
    
    /**
     * Teste responsável por verificar se o sistema consegue inserir um funcionario na base.
     */
    public static void inserirFuncionario(){
        Funcionario funcionario = new Funcionario();
        Calendar tempo = new GregorianCalendar();
        tempo.set(1995, 01, 20);
        
        funcionario.setDepartamento(DepartamentoDAO.getDepartamentoByID(1));
        funcionario.setDtContratacao(tempo);
        funcionario.setHorasTrab(160);
        funcionario.setNome("Alef");
        funcionario.setSalarioBase(1000);
        
        FuncionarioDAO.insereFuncionario(funcionario);
        
        if(FuncionarioDAO.getFuncionarioByMatricula(funcionario.getMatricula()) == funcionario){
            log("inserirFuncionario", "Executado com sucesso");
        } else {
            log("inserirFuncionario", "Falha");
        }
        
    }
    
    /**
     * Teste responsável por verificar se o sistema consegue inserir um diretor na base.
     */
    public static void inserirDiretor(){
        Diretor dir = new Diretor();
        Calendar tempo = new GregorianCalendar();
        tempo.set(1990, 01, 20);
        
        dir.setDepartamento(DepartamentoDAO.getDepartamentoByID(1));
        dir.setDtContratacao(tempo);
        dir.setHorasTrab(160);
        dir.setNome("José");
        dir.setSalarioBase(10000);
        
        FuncionarioDAO.insereFuncionario(dir);
        
        if(FuncionarioDAO.getFuncionarioByMatricula(dir.getMatricula()) == dir){
            log("inserirDiretor", "Executado com sucesso");
        } else {
            log("inserirDiretor", "Falha");
        }
    }
    
    /**
     * Teste responsável por verificar se o sistema consegue inserir um funcionario Externo na base.
     */
    public static void inserirFuncExterno(){
        FuncionarioExterno ext = new FuncionarioExterno();
        ext.setNome("Joao");
        ext.setRg(8139309);
        ext.setSalarioBase(3000);
        
        FuncionarioExternoDAO.insereFuncionarioExterno(ext);
        
        if(FuncionarioExternoDAO.getFuncionarioExtByRg(8139309) == ext){
            log("inserirFuncExterno", "Executado com sucesso");
        } else {
            log("inserirFuncExterno", "Falha");

        }
    }
    
    /**
     * Este teste tem como finalidade verificar se o salario liquido esta sendo calculado corretamente.
     */
    public static void salarioLiquido(){
        Funcionario funcionario = new Funcionario();
        funcionario.setSalarioBase(1499.15f);
        funcionario.setHorasTrab(160);

        if(funcionario.salarioLiquido() == 1334.2435f){
            log("salarioLiquido - % IR", "Executado com sucesso");
        } else {
            log("salarioLiquido - % IR", "Falha");
        }
        
        funcionario.setSalarioBase(1499.16f);
        funcionario.setHorasTrab(160);
        
        if(funcionario.salarioLiquido() == 1234.1835f){
            log("salarioLiquido 7,5 % IR", "Executado com sucesso");
        } else {
            log("salarioLiquido 7,5 % IR", "Falha");
        }
        
        funcionario.setSalarioBase(2246.76f);
        funcionario.setHorasTrab(160);
        
        if(funcionario.salarioLiquido() == 1699.6739f){
            log("salarioLiquido 15 % IR", "Executado com sucesso");
        } else {
            log("salarioLiquido 15 % IR", "Falha");
        }
        
        funcionario.setSalarioBase(2995.71f);
        funcionario.setHorasTrab(160);

        if(funcionario.salarioLiquido() == 2066.2909f){
            log("salarioLiquido 22.5 % IR", "Executado com sucesso");
        } else {
            log("salarioLiquido 22.5 % IR", "Falha");
        }
        
        funcionario.setSalarioBase(3743.20f);
        funcionario.setHorasTrab(160);

        if(funcionario.salarioLiquido() == 2415.2996f){
            log("salarioLiquido 27.5 % IR", "Executado com sucesso");
        } else {
            log("salarioLiquido 27.5 % IR", "Falha");
        }
    }
    
    public static void listaOrdem(){
        Console.printString("#################################  LISTA EM ORDEM CRESCENTE  #################################");
        FuncionarioDAO.mostrarFuncionarioOrdem();
    }
    
    public static void executar(){
        CargaBaseDados.carregarBases();
        inserirFuncionario();
        inserirDiretor();
        inserirFuncExterno();
        salarioLiquido();
        listaOrdem();
    }
}
