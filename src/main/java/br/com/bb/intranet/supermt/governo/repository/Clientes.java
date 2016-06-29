/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Cliente;
import br.com.bb.intranet.supermt.governo.model.Estagio;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

    public Cliente porMci(String mci) {
        Criteria criteria = criarCriteria();
        criteria.add(Restrictions.ilike("mci", mci));

        return (Cliente) criteria.uniqueResult();
    }

//    public List<String> mciQueContenha(String mci) {
//        Criteria criteria = criarCriteriaBusca();
//        criteria.add(Restrictions.ilike("mci", "%" + mci + "%"));
//        
//        return criteria.list();
//    }
    
    public List<String> mciQueContenha(String mci){
        TypedQuery<String> query = manager.createQuery(
                "select distinct mci from Cliente "
                        + " where mci like :mci", String.class);
        query.setParameter("mci", "%" + mci+ "%");
        return query.getResultList();
    }

    public List<Cliente> todos() {
        TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);

        return query.getResultList();
    }

    public void adicionar(Cliente cliente) {
        this.manager.persist(cliente);
    }

    public void guardar(Cliente cliente) {
        this.manager.merge(cliente);
    }

    public void remover(Cliente cliente) {
        this.manager.remove(cliente);
    }

    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);

        return criteria;
    }
    
    private Criteria criarCriteriaBusca() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(String.class);

        return criteria;
    }
}
