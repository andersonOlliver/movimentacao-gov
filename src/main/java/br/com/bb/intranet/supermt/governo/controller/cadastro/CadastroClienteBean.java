/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Agencias;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroCliente;
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
public class CadastroClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CadastroCliente cadastro;
    
    @Inject
    private Agencias agenciaRepository;
    
    private Cliente cliente;
    private List<Agencia> agencias;
    
    public void prepararCadastro(){
        this.cliente = new Cliente();
        this.agencias = agenciaRepository.todas();
    }
    
    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            
            this.cadastro.salvar(cliente);
            this.prepararCadastro();
            context.addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }
    
    
    
}
