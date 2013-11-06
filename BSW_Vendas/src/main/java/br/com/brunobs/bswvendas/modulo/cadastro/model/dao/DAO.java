package br.com.brunobs.bswvendas.modulo.cadastro.model.dao;

import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Entidade;
import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public abstract class DAO<T extends Entidade> {

    protected Class<T> classe;
    protected Session session;
    private Transaction transacao;

    public void salvar(T t) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            session.save(t);
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void salvarLista(List<T> ts) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            for (T t : ts) {
                session.save(t);
            }
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void salvarOuAtualizarLista(List<T> ts) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            for (T t : ts) {
                session.merge(t);
            }
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void salvarOuAtualizar(T t) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            session.merge(t);
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void alterar(T t) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            session.merge(t);
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void alterarLista(List<T> ts) throws ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            for (T t : ts) {
                session.merge(t);
            }
            transacao.commit();
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void deletar(T t) throws ValidacaoException, ConstraintViolationException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            session.flush();
            session.delete(t);
            transacao.commit();
        } catch (org.hibernate.exception.ConstraintViolationException ex) {
            transacao.rollback();
            throw new ConstraintViolationException(ex.getMessage(), ex.getSQLException(), ex.getConstraintName());
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void deletarLista(List<T> ts) throws org.hibernate.exception.ConstraintViolationException, ValidacaoException {
        try {
            transacao = session.beginTransaction();
            session.clear();
            session.flush();
            for (T t : ts) {
                session.delete(t);
            }
            transacao.commit();
        } catch (org.hibernate.exception.ConstraintViolationException ex) {
            transacao.rollback();
            throw new ConstraintViolationException(ex.getMessage(), ex.getSQLException(), ex.getConstraintName());
        } catch (HibernateException e) {
            transacao.rollback();
            throw new ValidacaoException(e.getMessage());
        }

    }

    public T atualizaObjeto(T t) throws ValidacaoException {
        T bean = null;
        try {
            session.refresh(t);
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return bean;
    }

    public T buscaPorID(Serializable codigo) throws ValidacaoException {
        T bean = null;
        try {
            bean = (T) session.get(classe, codigo);
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return bean;
    }

    public T buscaPorObjeto(Serializable codigo) throws ValidacaoException {
        T bean = null;
        try {
            bean = (T) session.get(classe, codigo);
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return bean;
    }

    public List<T> pesquisarPorParamentro(String parametro, Object value, String ordem) throws ValidacaoException {
        List<T> lista = new ArrayList<T>();
        try {
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.like(parametro, value));
            ordenaPesquisa(ordem, criteria);
            lista = criteria.list();
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return lista;

    }

    public List<T> pesquisarPorParamentroComAlias(String alias, String parametro, Object value, String ordem) throws ValidacaoException {
        List<T> lista = new ArrayList<T>();
        try {
            String dado = "obj";
            Criteria criteria = session.createCriteria(classe);
            criteria.createAlias(alias, dado);
            criteria.add(Restrictions.like(dado + "." + parametro, value));
            criteria.addOrder(Order.asc(dado + "." + parametro));
            lista = criteria.list();
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return lista;

    }

    public List<T> pesquisarTodos(String ordem) throws ValidacaoException {
        List<T> lista = new ArrayList<T>();
        try {
            Criteria criteria = session.createCriteria(classe);
            ordenaPesquisa(ordem, criteria);
            lista = criteria.list();
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return lista;

    }

    public List<T> pesquisarComCondicao(List<LogicalExpression> listExpress, String ordem) throws ValidacaoException {
        List<T> lista = new ArrayList<T>();
        try {
            Criteria criteria = session.createCriteria(classe);
            if (listExpress != null) {
                for (LogicalExpression e : listExpress) {
                    criteria.add(e);
                }
            }
            ordenaPesquisa(ordem, criteria);
            lista = criteria.list();
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return lista;
    }

    public List<T> pesquisarComCondicaoComAlias(String alias, String propriedade, List<LogicalExpression> listExpress, String ordem) throws ValidacaoException {
        List<T> lista = new ArrayList<T>();
        try {
            Criteria criteria = session.createCriteria(classe);
            criteria.createAlias(propriedade, alias);
            if (listExpress != null) {
                for (LogicalExpression e : listExpress) {
                    criteria.add(e);
                }
            }
            ordenaPesquisa(ordem, criteria);
            lista = criteria.list();
        } catch (HibernateException e) {
            throw new ValidacaoException(e.getMessage());
        }
        return lista;

    }

    public Criteria getCriteria() {
        Criteria criteria = session.createCriteria(classe);
        return criteria;
    }

    public Session getSession() {
        return session;
    }

    public List<T> pesquisaPorCriteria(Criteria criteria) {
        return criteria.list();
    }

    private void ordenaPesquisa(String ordem, Criteria criteria) {
        if (ordem != null || !ordem.isEmpty()) {
            criteria.addOrder(Order.asc(ordem));
        }
    }
}
