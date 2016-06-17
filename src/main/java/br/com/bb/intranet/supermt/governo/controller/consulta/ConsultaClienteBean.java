/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
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
public class ConsultaClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clienteRepository;
    
    private List<Cliente> clientes;
    
    public void consultar(){
        this.clientes = clienteRepository.todos();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
}
