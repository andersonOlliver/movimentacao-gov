/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Estagio;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Estagios implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Estagios(EntityManager manager) {
        this.manager = manager;
    }
    
    public Estagio porId(Long id) {
        return manager.find(Estagio.class, id);
    }

    public List<Estagio> todas() {
        TypedQuery<Estagio> query = manager.createQuery("from Estagio", Estagio.class);

        return query.getResultList();
    }

    public void adicionar(Estagio estagio) {
        this.manager.persist(estagio);

    }

    public void guardar(Estagio estagio) {
        this.manager.merge(estagio);

    }

    public void remover(Estagio estagio) {
        this.manager.remove(estagio);
    }
}
