/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Interacao;
import br.com.bb.intranet.supermt.governo.repository.Interacoes;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroInteracao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Interacoes interacoes;

    @Transactional
    public void salvar(Interacao interacao) throws NegocioException {
        if (interacao == null) {
            throw new NegocioException("Interação Inválida!");
        }
        
        this.interacoes.adicionar(interacao);
    }
    
}
