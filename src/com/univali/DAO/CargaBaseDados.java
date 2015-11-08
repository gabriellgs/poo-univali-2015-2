/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.DAO;

import com.univali.DAO.DepartamentoDAO;
import com.univali.DAO.FuncionarioDAO;
import com.univali.DAO.FuncionarioExternoDAO;
import com.univali.model.Departamento;
import com.univali.model.Diretor;
import com.univali.model.Funcionario;
import com.univali.model.FuncionarioExterno;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Alef
 */
public class CargaBaseDados {
    
    
    /**
     * Metodo responsável por limpar todos os dados das bases.
     */
    public static void limparBases(){  
        FuncionarioDAO.limparBase();
        FuncionarioExternoDAO.limparBase();
        DepartamentoDAO.limparBase();
    }
    
    /**
     * Metodo responsável por carregar todas as bases de dados.
     */
    public static void carregarBases(){
        limparBases();
        preencherBaseDepartamentos();
        mostrarListagemDepartamentos();
        preencherBaseFunciorarios();
        mostrarListagemFuncionarios();
    }
    
    /**
     * Metodo responsável por carregar os dados da base de departamentos.
     */
    public static void preencherBaseDepartamentos(){

        Departamento dep = new Departamento("Recursos Humanos");
        Departamento dep2 = new Departamento("Produção");
        Departamento dep3 = new Departamento("Desenvolvimento");
        Departamento dep4 = new Departamento("Controladoria");
        Departamento dep5 = new Departamento("Financeiro");
        
        DepartamentoDAO.insereDepartamento(dep);
        DepartamentoDAO.insereDepartamento(dep2);
        DepartamentoDAO.insereDepartamento(dep3);
        DepartamentoDAO.insereDepartamento(dep4);
        DepartamentoDAO.insereDepartamento(dep5);   
    }
    
    /**
     * Metodo responsável por carregar os dados da base de funcionários.
     */
    public static void preencherBaseFunciorarios(){
        Calendar tempo;
        float salario = 15000;
        int rg = 1234;
        int ano = 1990;
        
        for(int i = 0; i < 10; i++){
            Funcionario funcionario = new Funcionario();
            funcionario.setSalarioBase(salario);
            tempo = new GregorianCalendar();
            tempo.set(ano, 01, 20);
            funcionario.setDtContratacao(tempo);
            funcionario.setHorasTrab(160);
            funcionario.setNome("Funcionario Normal " + (i+1));
            
            FuncionarioDAO.insereFuncionario(funcionario);
            
            ano++;
            salario -= 1000;
        }
        
        for(int i = 0; i < 10; i++){
            Diretor dir = new Diretor();
            dir.setSalarioBase(salario);
            tempo = new GregorianCalendar();
            tempo.set(1995, 01, 20);
            dir.setDtContratacao(tempo);
            dir.setHorasTrab(160);
            dir.setNome("Diretor " + (i+1));
            
            FuncionarioDAO.insereFuncionario(dir);
            salario += 1000;
        }
        
        
        salario = 1000;
        for (int i = 0; i < 10; i++) {
            FuncionarioExterno func = new FuncionarioExterno("Externo "+ (i+1), salario);
            FuncionarioExternoDAO.insereFuncionarioExterno(func);
            salario += 1000;
            rg++;
        }
    }
    
    
    /**
     * Metodo utilizado para mostrar a listagem de departamentos apenas para consulta.
     */
    public static void mostrarListagemDepartamentos(){
        DepartamentoDAO.mostrarDepartamentos();
    }
    
    /**
     * Metodo utilizado para mostrar a listagem de funcionarios apenas para consulta.
     */
    public static void mostrarListagemFuncionarios(){
        FuncionarioDAO.mostrarFuncionarios();
        FuncionarioExternoDAO.mostrarFuncionariosExt();
    }
}
