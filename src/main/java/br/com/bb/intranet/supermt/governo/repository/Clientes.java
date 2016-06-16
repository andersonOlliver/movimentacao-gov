/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Olliver
 */
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Clientes(EntityManager manager) {
        this.manager = manager;
    }
    
    public Cliente porId(Long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> todas() {
        TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);

        return query.getResultList();
    }
    
    public void adicionar(Cliente cliente){
        this.manager.persist(cliente);
    }
    
    public void guardar(Cliente cliente){
        this.manager.merge(cliente);
    }
    
    public void remover(Cliente cliente){
        this.manager.remove(cliente);
    }
    
}
