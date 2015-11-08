/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univali.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Alef
 */
public class ContraCheque {
    float salario;
    Calendar dtPagamento;

    public ContraCheque() {
        Calendar hoje = new GregorianCalendar();
        hoje.setTime(new Date());
        
        setDtPagamento(hoje);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Calendar getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Calendar dtPagamento) {
        this.dtPagamento = dtPagamento;
    }
}
