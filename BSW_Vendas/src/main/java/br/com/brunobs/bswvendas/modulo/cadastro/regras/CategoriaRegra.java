package br.com.brunobs.bswvendas.modulo.cadastro.regras;

import br.com.brunobs.bswvendas.modulo.cadastro.model.dao.HibernateDAO;
import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Categoria;
import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.DescricaoPreco;
import br.com.brunobs.bswvendas.suporte.enuns.SituacaoCadastro;
import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;
import br.com.brunobs.bswvendas.suporte.util.AbstractFiltro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 *
 */
public class CategoriaRegra extends EntidadeRegra<Categoria> {

    public CategoriaRegra() {
        dao = new HibernateDAO<Categoria>();
    }

    @Override
    public void verificaCadastro(Categoria entidade) throws ValidacaoException {
        Integer id = entidade.getCodigo() == null ? 0 : entidade.getCodigo();
        List<LogicalExpression> listExpressao = new ArrayList<LogicalExpression>();
        Criterion nome = Restrictions.eq("nome", entidade.getNome());
        Criterion codigo = Restrictions.not(Restrictions.eq("codigo", id));
        listExpressao.add(Restrictions.and(nome, codigo));
        List<Categoria> lista = dao.pesquisarComCondicao(listExpressao, "nome");
        if (!lista.isEmpty()) {
            throw new ValidacaoException("Já existe um Cadastro com esse Nome: \n "
                    + lista.get(0).getDescricaoEntidade());
        }
    }

    @Override
    public void salvar(Categoria entidade) throws ValidacaoException {
        if (entidade.getListaDeDescricaoPreco().isEmpty()) {

            DescricaoPreco descricaoPreco = new DescricaoPreco();
            descricaoPreco.setCategoria(entidade);
            descricaoPreco.setDescricao("Valor");
            descricaoPreco.setSituacao(SituacaoCadastro.ATIVO);
            entidade.addListaDeDescricaoPreco(descricaoPreco);
        }
        super.salvar(entidade);
    }

    @Override
    public String getPathRelatorio() {
        return null;//RelatorioPath.CATEGORIA.path();
    }

    @Override
    public List consultaRelatorio(AbstractFiltro filtroPesquisa) throws ValidacaoException {
//        Filtro filtro = (Filtro) filtroPesquisa;
//        Criteria criteria = dao.getCriteria();
//
//        if (filtro.getCampoPesquisa().equals(CategoriaCampoPesquisa.CODIGO.getNomeCampo())) {
//            criteria.add(Restrictions.eq(filtro.getCampoPesquisa().getNomeCampo(), filtro.getCodigo()));
//        } else {
//            criteria.add(filtro.getFiltroPesquisa().criterioPesquisa(filtro.getCampoPesquisa().getNomeCampo(), filtro.getCampoPesquisa().getTipoCampo(filtro.getDescricao())));
//        }
//        criteria.addOrder(Order.asc(filtro.getOrdem().getNomeCampo()));
//        return criteria.list();
        return null;
    }
}