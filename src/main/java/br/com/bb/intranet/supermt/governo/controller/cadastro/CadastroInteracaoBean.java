/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.model.Interacao;
import br.com.bb.intranet.supermt.governo.model.Oportunidade;
import br.com.bb.intranet.supermt.governo.model.ProbabilidadeSucesso;
import br.com.bb.intranet.supermt.governo.model.Produto;
import br.com.bb.intranet.supermt.governo.model.TipoInteracao;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.repository.Estagios;
import br.com.bb.intranet.supermt.governo.repository.Oportunidades;
import br.com.bb.intranet.supermt.governo.repository.Produtos;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroInteracao;
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
public class CadastroInteracaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroInteracao cadastroInteracao;
    
    @Inject
    private CadastroOportunidade cadastroOportunidade;

    @Inject
    private Clientes repositorioCliente;
   
    @Inject
    private Estagios repositorioEstagio;
    
    @Inject
    private Oportunidades repositorioOportunidade;
    
    @Inject
    private Produtos repositorioProduto;
    

    private String nomeProduto;
    private Interacao interacao;
    private Cliente cliente;
    private Oportunidade oportunidade;
    private List<Estagio> estagios;
    private List<Oportunidade> oportunidades;
    private List<Produto> produtos;

    public void prepararCadastroInteracao() {
        this.interacao = new Interacao();
        this.interacao.setEmpresa(cliente);
        this.oportunidade = new Oportunidade();
        this.buscaOportunidades();
    }

    public void prepararCadastroOportunidade(){
        
        this.oportunidade = new Oportunidade();
        this.oportunidade.setCliente(cliente);
        this.estagios = this.repositorioEstagio.todos();
        this.produtos = this.repositorioProduto.todos();
        
    }
    
    public void salvarInteracao() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            this.cadastroInteracao.salvar(interacao);
            this.interacao = new Interacao();

            context.addMessage(null, new FacesMessage("Conteudo salvo com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public void salvarOportunidade() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            this.cadastroOportunidade.salvar(oportunidade);
            oportunidade = new Oportunidade();
            this.buscaOportunidades();
            
            context.addMessage(null, new FacesMessage("Oportunidade salva com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }
    
    private void buscaOportunidades(){
        this.oportunidades = new ArrayList<>();
        this.oportunidades = repositorioOportunidade.todas();
    }
    
//    GETTER E SETTER
    public Interacao getInteracao() {
        return interacao;
    }

    public void setInteracao(Interacao interacao) {
        this.interacao = interacao;
    }

    public TipoInteracao[] getTipoInteracao() {
        return TipoInteracao.values();
    }
    
    public ProbabilidadeSucesso[] getProbabilidadeSucesso(){
        return ProbabilidadeSucesso.values();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Oportunidade getOportunidade() {
        return oportunidade;
    }
    
    public void setOportunidade(Oportunidade oportunidade) {
        this.oportunidade = oportunidade;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    
}
