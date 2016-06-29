/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class DataString implements Serializable {

    private List<UsuarioAcesso> usuarios;
    private UsuarioAcesso usuario;

    @PostConstruct
    public void iniciar() {
        this.usuarios = new ArrayList<UsuarioAcesso>();
        this.usuario = new UsuarioAcesso();
    }

    public void createNew() {
        if (usuarios.contains(usuario)) {
            FacesMessage msg = new FacesMessage("Duplicado", "Esse usuario já foi inserido!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            usuarios.add(usuario);
            this.usuario = new UsuarioAcesso();
        }
    }

    public String reinit() {
        this.usuario = new UsuarioAcesso();

        return null;
    }

    public List<UsuarioAcesso> getUsuarios() {
        return usuarios;
    }

    public UsuarioAcesso getUsuario() {
        return usuario;
    }
}
