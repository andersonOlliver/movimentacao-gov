/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class InicioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clienteRepository;

    private String mci;
    private Cliente cliente;

    public void prepararPesquisa() {
        this.cliente = new Cliente();

    }

    public List<String> pesquisarMci(String mci) {
        return this.clienteRepository.mciQueContenha(mci);
    }

    public void pesquisarCliente(String mci) {
        this.cliente = this.clienteRepository.porMci(mci);
        if (cliente == null) {
            this.addErrorMessage("Cliente não existe em nossos registros!", "Contate o Administrador do Sistema!");
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/governo/movimentacao/lista-interacao.super?cliente=" + cliente.getMci());
            } catch (IOException ex) {
                System.out.println("Erro ao redirecionar!");
            }
        }
    }

    void addErrorMessage(String textoMensagem, String detalhe) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(textoMensagem, detalhe);
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
        context.addMessage(null, mensagem);
    }

    public String getMci() {
        return mci;
    }

    public void setMci(String mci) {
        this.mci = mci;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
