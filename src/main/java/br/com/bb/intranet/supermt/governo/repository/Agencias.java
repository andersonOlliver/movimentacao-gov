package br.com.bb.intranet.supermt.governo.repository;

import br.com.bb.intranet.supermt.governo.model.Agencia;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class Agencias implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    @Inject
    public Agencias(EntityManager manager) {
        this.manager = manager;
    }

    public Agencia porId(Long id) {
        return manager.find(Agencia.class, id);
    }

    public Agencia porPrefixo(String prefixo) {
        Criteria criteria = criarCriteria();

        criteria.add(Restrictions.ilike("prefixo", prefixo, MatchMode.ANYWHERE));

        return (Agencia) criteria.uniqueResult();
    }

    public List<Agencia> todas() {
        TypedQuery<Agencia> query = manager.createQuery("from Agencia", Agencia.class);

        return query.getResultList();
    }

    public void adicionar(Agencia agencia) {
        this.manager.persist(agencia);
    }

    public void guardar(Agencia agencia) {
        this.manager.merge(agencia);

    }

    public void remover(Agencia agencia) {
        this.manager.remove(agencia);
    }

    /*
	 * CONFIGURAÇÃO DE SESSÃO
     */
    private Criteria criarCriteria() {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Agencia.class);

        return criteria;
    }
}
