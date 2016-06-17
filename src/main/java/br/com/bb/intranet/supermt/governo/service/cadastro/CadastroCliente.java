package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.repository.Clientes;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class CadastroCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Clientes clientes;
    
     @Transactional
    public void salvar(Cliente cliente) throws NegocioException {
        Cliente verifica = null;
        verifica = clientes.porMci(cliente.getCarteira());
        if (cliente == null) {
            throw new NegocioException("Cliente Inválido!");
        }else if (verifica != null) {
            throw new NegocioException("Carteira já Registrada!");
        }
        
        this.clientes.adicionar(cliente);
    }
    
}
