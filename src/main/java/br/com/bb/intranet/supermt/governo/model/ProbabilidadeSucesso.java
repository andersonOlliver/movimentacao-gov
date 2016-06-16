/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.model;

/**
 *
 * @author Olliver
 */
public enum ProbabilidadeSucesso {
    
    BAIXA("baixa"),
    MEDIA("media"),
    ALTA("alta");
    
    private String valor;

    private ProbabilidadeSucesso(String valor) {
        this.valor = valor;
    }
    
    
}
