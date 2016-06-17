/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Funcionarios(EntityManager manager) {
        this.manager = manager;
    }
    
    public Funcionario porId(Long id) {
        return manager.find(Funcionario.class, id);
    }

    public List<Funcionario> todos() {
        TypedQuery<Funcionario> query = manager.createQuery("from Funcionario", Funcionario.class);

        return query.getResultList();
    }

    public void adicionar(Funcionario funcionario) {
        this.manager.persist(funcionario);

    }

    public void guardar(Funcionario funcionario) {
        this.manager.merge(funcionario);

    }

    public void remover(Funcionario Funcionario) {
        this.manager.remove(Funcionario);
    }
}
