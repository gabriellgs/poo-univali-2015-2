/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.model;

import com.univali.calculations.ImpostoRenda;
import com.univali.calculations.INSS;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Alef
 */
public class Funcionario {
    private static int id = 0;
    private int matricula;
    private String nome;
    private List<ContraCheque> listaContraChq = new ArrayList<ContraCheque>();
    private int horasTrab;
    private float salarioBase;
    private Calendar dtContratacao;
    private Departamento departamento;

    public Funcionario() {
        this.id++;
        this.matricula = this.id;
    }
    
     @Override
    public String toString() {
        return "Funcionario: " + this.matricula + " - " + this.nome;
    }
    
    public int getTempoTrabalho(){
        Calendar hoje = new GregorianCalendar();
        hoje.setTime(new Date());
        int idade = hoje.get(Calendar.YEAR) - this.dtContratacao.get(Calendar.YEAR);
        if(hoje.get(Calendar.DAY_OF_YEAR) < this.dtContratacao.get(Calendar.DAY_OF_YEAR)){
            idade--;
        }
        return idade;
    }

    public Calendar getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Calendar dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getHorasTrab() {
        return horasTrab;
    }

    public void setHorasTrab(int horasTrab) {
        this.horasTrab = horasTrab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Funcionario.id = id;
    }

    public List<ContraCheque> getListaContraChq() {
        return listaContraChq;
    }

    public void setListaContraChq(List<ContraCheque> listaContraChq) {
        this.listaContraChq = listaContraChq;
    }
    
    /**
     * Função responsável por calcular o salario liquido do funcionario com os 
 ajustes de ImpostoRenda e imposto de renda.
     * @return salaário liquido calculado.
     */
    public float salarioLiquido(){
        float salarioLiquido = 0;
        float valorPorHora = getSalarioBase()/160;
        
        if(getHorasTrab() > 160){
            salarioLiquido = getSalarioBase() + (getSalarioBase() * 0.5f);
        } else {
            if(getHorasTrab() <= (0.9 * 160)){
                salarioLiquido = getHorasTrab() * valorPorHora;
            } else {
                salarioLiquido = getSalarioBase();
            }
        }

        salarioLiquido = ImpostoRenda.calculoIR(salarioLiquido);
        salarioLiquido = INSS.calculoINSS(salarioLiquido);
        
        ContraCheque cc = new ContraCheque();
        cc.setSalario(salarioBase);
        getListaContraChq().add(cc);
       
        return salarioLiquido;
    }
}
