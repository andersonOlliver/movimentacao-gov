/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Operacao;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroOperacao;
import java.io.Serializable;
import java.util.List;
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
public class CadastroOperacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroOperacao cadastro;
    
    @Inject
    private Clientes clientes;

    private Operacao operacao;
    private Cliente cliente;
    
    public void prepararCadastro() {
        this.operacao = new Operacao();
        this.cliente = new Cliente();
    }
    

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
     
            this.cadastro.salvar(operacao);
            this.prepararCadastro();
            
            context.addMessage(null, new FacesMessage("Operação salva com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
