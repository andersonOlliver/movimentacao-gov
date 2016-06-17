/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.service.cadastro;

import br.com.bb.intranet.supermt.governo.model.Produto;
import br.com.bb.intranet.supermt.governo.repository.Produtos;
import br.com.bb.intranet.supermt.governo.service.NegocioException;
import br.com.bb.intranet.supermt.governo.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class CadastroProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Produtos produtos;

    @Transactional
    public void salvar(Produto produto) throws NegocioException {
        Produto verifica = null;
        verifica = produtos.porNome(produto.getNome());

        if (produto == null) {
            throw new NegocioException("Produto Inválido!");
        } else if (verifica != null) {
            throw new NegocioException("Produto Já Cadastrado!");
        }

        this.produtos.adicionar(produto);
    }
}
