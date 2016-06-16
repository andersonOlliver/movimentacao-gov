/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Registro;
import br.com.bb.intranet.supermt.governo.repository.Registros;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroRegistro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Registros registros;

    @Transactional
    public void salvar(Registro registro) throws NegocioException {
        if (registro == null) {
            throw new NegocioException("Agencia Inválida!");
        }
        
        this.registros.adicionar(registro);
    }
    
}
