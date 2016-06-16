/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.repository.Funcionarios;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Funcionarios funcionarios;

    @Transactional
    public void salvar(Funcionario funcionario) throws NegocioException {
        if (funcionario == null) {
            throw new NegocioException("Funcionario Inválido!");
        }
        
        this.funcionarios.adicionar(funcionario);
    }
    
}
