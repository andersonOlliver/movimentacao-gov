/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Interacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Interacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Interacoes(EntityManager manager) {
        this.manager = manager;
    }
    
    public Interacao porId(Long id) {
        return manager.find(Interacao.class, id);
    }

    public List<Interacao> todos() {
        TypedQuery<Interacao> query = manager.createQuery("from Interacao", Interacao.class);

        return query.getResultList();
    }

    public void adicionar(Interacao interacao) {
        this.manager.persist(interacao);

    }

    public void guardar(Interacao interacao) {
        this.manager.merge(interacao);

    }

    public void remover(Interacao interacao) {
        this.manager.remove(interacao);
    }
}
