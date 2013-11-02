package br.com.brunobs.bswvendas.modulo.cadastro.model.dao;

import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Entidade;
import java.lang.reflect.ParameterizedType;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 * @GitHub: Brunobs
 *
 */
public class DAOImpl<T extends Entidade> extends DAO<T> {

    public DAOImpl() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        session = null;// HibernateUtil.getSessionFactory().
    }
}
