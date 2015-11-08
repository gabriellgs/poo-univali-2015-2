/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.model;

/**
 *
 * @author Alef
 */
public class Departamento {
    private static int idSistema = 0;
    private int id;
    private String nome;

    public Departamento() {
        this.idSistema++;
        this.id = this.idSistema;
    }

    public Departamento(String nome) {
        this.nome = nome;
        this.idSistema++;
        this.id = this.idSistema;

    }

    @Override
    public String toString() {
        return this.id + " - " + this.nome;
    }

    public static int getIdSistema() {
        return idSistema;
    }

    public static void setIdSistema(int idSistema) {
        Departamento.idSistema = idSistema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
