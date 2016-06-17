/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import br.com.bb.intranet.supermt.governo.model.Estagio;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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

    public Estagio porValor(String valor) {
        Criteria criteria = criarCriteria();

        criteria.add(Restrictions.ilike("valor", valor, MatchMode.ANYWHERE));

        return (Estagio) criteria.uniqueResult();
    }

    public List<Estagio> todos() {
        TypedQuery<Estagio> query = manager.createQuery("from Estagio", Estagio.class);

        return query.getResultList();
    }

    /*
        * INSERÇÕES
     */
    public void adicionar(Estagio estagio) {
        this.manager.persist(estagio);

    }

    public void guardar(Estagio estagio) {
        this.manager.merge(estagio);

    }

    /*
        * REMOÇÃO
     */
    public void remover(Estagio estagio) {
        this.manager.remove(estagio);
    }

    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Estagio.class);

        return criteria;
    }
}
