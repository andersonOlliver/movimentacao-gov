/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Registro;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Registros implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Registros(EntityManager manager) {
        this.manager = manager;
    }
    
    public Registro porId(Long id) {
        return manager.find(Registro.class, id);
    }

    public List<Registro> todas() {
        TypedQuery<Registro> query = manager.createQuery("from Registro", Registro.class);

        return query.getResultList();
    }

    public void adicionar(Registro registro) {
        this.manager.persist(registro);

    }

    public void guardar(Registro registro) {
        this.manager.merge(registro);

    }

    public void remover(Registro registro) {
        this.manager.remove(registro);
    }
}
