/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.calculations;

/**
 *
 * @author Alef
 */
public class ImpostoRenda {
    
    
    /**
     * Função responsável por calcular o desconto de ImpostoRenda de cada funcionário.
     * @param salario
     * @return salário com o reajuste.
     */
    public static float calculoIR(float salario){
        if(salario >= 1499.16f && salario <= 2246.75f){
            salario = salario - salario * 0.075f;
        } else {
            if(salario >= 2246.76f && salario <= 2995.70f){
                salario = salario - salario * 0.15f;
            } else {
                if(salario >= 2995.71f && salario <= 3743.19f){  
                    salario = salario - salario * 0.225f;
                } else {
                    if(salario >= 3743.20f){
                        salario = salario - salario * 0.275f;
                    }
                }
            }
        }
        return salario;
    }
}
