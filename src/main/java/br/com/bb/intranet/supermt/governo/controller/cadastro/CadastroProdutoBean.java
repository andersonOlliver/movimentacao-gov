/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Produto;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroProduto;
import java.io.Serializable;
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
public class CadastroProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroProduto cadastro;

    private Produto produto;

    public void prepararCadastro() {
        this.produto = new Produto();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            this.cadastro.salvar(produto);
            this.prepararCadastro();

            context.addMessage(null, new FacesMessage("Oportunidade salva com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
