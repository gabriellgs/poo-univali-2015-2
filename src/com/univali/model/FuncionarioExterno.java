/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.model;

import com.univali.interfaces.InterfaceFuncionario;

/**
 *
 * @author Alef
 */
public class FuncionarioExterno implements InterfaceFuncionario{
    private int rg;
    private String nome;
    private float salarioBase;

    public FuncionarioExterno(String nome, float salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public FuncionarioExterno() {
   
    }
  
    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }
    
    public String getNome() {   
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public float salarioLiquido() {
        return this.getSalarioBase();
    }
    
}
