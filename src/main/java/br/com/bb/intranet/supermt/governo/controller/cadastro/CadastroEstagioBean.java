/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.cadastro;

import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.service.cadastro.CadastroEstagio;
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
public class CadastroEstagioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CadastroEstagio cadastro;
    
    private Estagio estagio;
    
    public void prepararCadastro(){
        this.estagio = new Estagio();
    }
    
    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            
            this.cadastro.salvar(estagio);
            
            this.prepararCadastro();
            
            context.addMessage(null, new FacesMessage("Conteudo salvo com sucesso!"));
        } catch (NegocioException e) {

            FacesMessage mensagem = new FacesMessage(e.getMessage());
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }
    
}
