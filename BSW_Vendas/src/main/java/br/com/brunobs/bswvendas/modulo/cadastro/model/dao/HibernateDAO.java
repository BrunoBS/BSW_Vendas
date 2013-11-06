package br.com.brunobs.bswvendas.modulo.cadastro.model.dao;

import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Entidade;
import br.com.brunobs.bswvendas.modulo.util.FacesContextUtil;
import java.lang.reflect.ParameterizedType;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class HibernateDAO<T extends Entidade> extends DAO<T> {

    public HibernateDAO() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.session = FacesContextUtil.getRequestSession();
    }
}
