/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.controller.consulta;

import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.repository.Funcionarios;
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
public class ConsultaFuncionarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Funcionarios funcionarioRepository;
    
    private List<Funcionario> funcionarios;
    
    public void consultar(){
        this.funcionarios = funcionarioRepository.todos();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    
}
