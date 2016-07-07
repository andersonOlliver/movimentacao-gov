/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.model.Oportunidade;
import br.com.bb.intranet.supermt.governo.model.ProbabilidadeSucesso;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.repository.Estagios;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroOportunidade;
import java.io.Serializable;
import java.util.ArrayList;
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
public class CadastroOportunidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroOportunidade cadastro;
    
    @Inject
    private Estagios estagioRepositorio;
    
    @Inject
    private Clientes clienteRepositorio;

    private String nomeCliente;
    private String nomeProduto;
    private Oportunidade oportunidade;
    private Cliente cliente;
    private List<Cliente> clientes;
    private List<Estagio> estagios;
    private boolean temParametro = false;
    
    public void prepararCadastro() {
        temParametro = cliente == null;
        this.oportunidade = new Oportunidade();
        this.estagios = estagioRepositorio.todos();
        
        if(temParametro){
            this.clientes = this.clienteRepositorio.todos();
            this.cliente = new Cliente();
        }
    }
    
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            this.cadastro.salvar(oportunidade);
            this.prepararCadastro();
            
            context.addMessage(null, new FacesMessage("Oportunidade salva com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }
    
    public ProbabilidadeSucesso[] getProbabilidadeDeSucesso(){
        return ProbabilidadeSucesso.values();
    }

    public Oportunidade getOportunidade() {
        return oportunidade;
    }

    public void setOportunidade(Oportunidade oportunidade) {
        this.oportunidade = oportunidade;
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean isTemParametro() {
        return temParametro;
    }
    
    
}
