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
public class Diretor extends Funcionario {
   
    @Override
    public float salarioLiquido() {
        float salarioL = super.salarioLiquido();
        float bonus = salarioL * (0.05f * super.getTempoTrabalho());
        
        
        if(bonus > (salarioL * 0.4f)){
            return salarioL + (salarioL * 0.4f);
        }
        
        return salarioL + bonus;
    }
    
}
