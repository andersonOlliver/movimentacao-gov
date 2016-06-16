/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Oportunidade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Oportunidades implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Oportunidades(EntityManager manager) {
        this.manager = manager;
    }
    
    public Oportunidade porId(Long id) {
        return manager.find(Oportunidade.class, id);
    }

    public List<Oportunidade> todas() {
        TypedQuery<Oportunidade> query = manager.createQuery("from Oportunidade", Oportunidade.class);

        return query.getResultList();
    }

    public void adicionar(Oportunidade oportunidade) {
        this.manager.persist(oportunidade);

    }

    public void guardar(Oportunidade oportunidade) {
        this.manager.merge(oportunidade);

    }

    public void remover(Oportunidade oportunidade) {
        this.manager.remove(oportunidade);
    }
}
