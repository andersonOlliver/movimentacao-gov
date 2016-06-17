/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Interacao;
import br.com.bb.intranet.supermt.governo.repository.Interacoes;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class ConsultaInteracaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Interacoes interacaoRepository;
    
    private List<Interacao> interacoes;
    
    public void consultar(){
        this.interacoes = interacaoRepository.todos();
    }

    public List<Interacao> getInteracoes() {
        return interacoes;
    }
    
}
