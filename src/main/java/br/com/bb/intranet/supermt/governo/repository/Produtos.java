/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Produtos(EntityManager manager) {
        this.manager = manager;
    }
    
    public Produto porId(Long id) {
        return manager.find(Produto.class, id);
    }

    public List<Produto> todas() {
        TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);

        return query.getResultList();
    }

    public void adicionar(Produto produto) {
        this.manager.persist(produto);

    }

    public void guardar(Produto produto) {
        this.manager.merge(produto);

    }

    public void remover(Produto produto) {
        this.manager.remove(produto);
    }
}
