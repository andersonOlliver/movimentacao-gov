/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Funcionario;
import br.com.bb.intranet.supermt.governo.model.Operacao;
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
    
    public List<Operacao> porMci(String mci){
        Criteria criteria = criarCriteria();
        
        criteria.add(Restrictions.like("cliente_id.mci", mci));
        
        return criteria.list();
    }

    public void adicionar(Operacao operacao) {
        this.manager.persist(operacao);

    }

    public Operacao guardar(Operacao operacao) {
        return this.manager.merge(operacao);

    }

    public void remover(Operacao operacao) {
        this.manager.remove(operacao);
    }
    
    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Operacao.class);

        return criteria;
    }
}
