/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.repository.Agencias;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroAgencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Agencias agencias;

    @Transactional
    public void salvar(Agencia agencia) throws NegocioException {
        Agencia verifica = null;
        verifica = agencias.porPrefixo(agencia.getPrefixo());
        
        if (agencia == null) {
            throw new NegocioException("Agencia Inválida!");
        } else if(verifica != null){
            throw new NegocioException("Agencia Já Cadastrada!");
        }
        
        this.agencias.adicionar(agencia);
    }
}
