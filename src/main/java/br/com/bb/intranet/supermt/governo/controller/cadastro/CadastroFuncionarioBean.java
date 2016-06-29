/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.repository.Agencias;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroFuncionario;
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
@Named(value = "cadastroUsuarioBean")
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private CadastroFuncionario cadastro;
    
    @Inject
    private Agencias agenciaRepository;
    
    private Funcionario usuario;
    private List<Agencia> agencias;
    
    public void prepararCadastro(){
        this.usuario = new Funcionario();
        this.agencias = this.agenciaRepository.todas();
    }
    
    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            
            this.cadastro.salvar(usuario);
            
            context.addMessage(null, new FacesMessage("Conteudo salvo com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public void setUsuario(Funcionario usuario) {
        this.usuario = usuario;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

   
    
}
