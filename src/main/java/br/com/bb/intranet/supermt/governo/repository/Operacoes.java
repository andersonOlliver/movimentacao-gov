/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Operacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Operacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Operacoes(EntityManager manager) {
        this.manager = manager;
    }
    
    public Operacao porId(Long id) {
        return manager.find(Operacao.class, id);
    }

    public List<Operacao> todas() {
        TypedQuery<Operacao> query = manager.createQuery("from Operacao", Operacao.class);

        return query.getResultList();
    }

    public void adicionar(Operacao operacao) {
        this.manager.persist(operacao);

    }

    public void guardar(Operacao operacao) {
        this.manager.merge(operacao);

    }

    public void remover(Operacao operacao) {
        this.manager.remove(operacao);
    }
}
