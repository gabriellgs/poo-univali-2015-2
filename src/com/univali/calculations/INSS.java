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
public class INSS {
     
    /**
     * Metodo responsável por calcular o imposto de renda
     * @param salario
     * @return salário com o reajuste.
     */
    public static float calculoINSS(float salario){
        if((salario * 0.11f) <= 482.93){
            return salario - salario * 0.11f;
        } else {
            return salario - 482.93f;
        }
    }
}
