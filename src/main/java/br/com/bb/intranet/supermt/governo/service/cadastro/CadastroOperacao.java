/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Operacao;
import br.com.bb.intranet.supermt.governo.repository.Operacoes;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroOperacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Operacoes operacoes;

    @Transactional
    public void salvar(Operacao operacao) throws NegocioException {
        if (operacao == null) {
            throw new NegocioException("Operação Inválida!");
        }else if(operacao.getCliente() == null){
            throw new NegocioException("Cliente inválido!");
        }
        
        this.operacoes.adicionar(operacao);
    }
    
    @Transactional
    public Operacao atualizar(Operacao operacao) throws NegocioException {
        if (operacao == null) {
            throw new NegocioException("Operação Inválida!");
        }else if(operacao.getCliente() == null){
            throw new NegocioException("Cliente inválido!");
        }
        
        return this.operacoes.guardar(operacao);
    }
}
