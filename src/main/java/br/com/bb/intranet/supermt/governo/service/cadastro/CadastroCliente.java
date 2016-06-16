/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clientes;
    
     @Transactional
    public void salvar(Cliente cliente) throws NegocioException {
        if (cliente == null) {
            throw new NegocioException("Cliente Inválido!");
        }
        
        this.clientes.adicionar(cliente);
    }
    
}
