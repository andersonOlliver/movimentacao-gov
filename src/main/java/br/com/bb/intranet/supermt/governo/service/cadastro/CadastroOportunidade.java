/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Oportunidade;
import br.com.bb.intranet.supermt.governo.repository.Oportunidades;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroOportunidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Oportunidades oportunidades;

    @Transactional
    public void salvar(Oportunidade oportunidade) throws NegocioException {
        if (oportunidade == null) {
            throw new NegocioException("Oportunidade Inválida!");
        }
        
        this.oportunidades.adicionar(oportunidade);
    }
    
}
