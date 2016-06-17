/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Estagio;
import br.com.bb.intranet.supermt.governo.repository.Estagios;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroEstagio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Estagios estagios;

    @Transactional
    public void salvar(Estagio estagio) throws NegocioException {
        Estagio verifica = null;
        verifica = estagios.porValor(estagio.getValor());

        if (estagio == null) {
            throw new NegocioException("Estágio Inválido!");
        } else if (verifica != null) {
            throw new NegocioException("Estágio Já Cadastrado!");
        }

        this.estagios.adicionar(estagio);
    }

}
