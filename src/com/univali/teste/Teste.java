/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.teste;

import com.univali.view.Console;


/**
 *
 * @author Alef
 */
public class Teste {
    
    public static void log(String operacao, String msg){
        Console.printString(">> " + operacao + " : " + msg);
    }
}
