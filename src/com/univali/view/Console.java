/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.view;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alef
 */
public class Console {
    private static Scanner in;
    
    /**
     * Metodo responsável por ler uma linha.
     * @param texto texto a ser impresso para o usuário.
     * @return linha lida.
     */
    private String readLine(String texto){
        in = new Scanner(System.in);
        System.out.println(texto);
        return in.nextLine();
    }
    
    /**
     * Metodo responsável por ler uma string.
     * @param texto texto a ser impresso para o usuário.
     * @return string liga.
     */
    public static String readInString(String texto){
        in = new Scanner(System.in);
        System.out.println(texto);
        return in.next();
    }
    
    /**
     * Metodo responsável por ler um int
     * @param texto texto a ser impresso para o usuário
     * @return int lido.
     */
    public static int readInInt(String texto){
        in = new Scanner(System.in);
        System.out.println(texto);
        return in.nextInt();
    }
    
    /**
     * Metodo responsável por ler um float
     * @param texto texto a ser impresso para o usuário.
     * @return float lido.
     */
    public static float readInFloat(String texto){
        in = new Scanner(System.in);
        System.out.println(texto);
        return in.nextFloat();
    }
    
    /**
     * Metodo responsável por esperar um enter.
     */
    public static void waitEnter(){
        try {
        	System.out.println("Pressione Enter para continuar!");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    /**
     * Metodo responsável por printar uma string para o usuário.
     */
    public static void printString(String texto){
        System.out.println(texto);
    }
}
