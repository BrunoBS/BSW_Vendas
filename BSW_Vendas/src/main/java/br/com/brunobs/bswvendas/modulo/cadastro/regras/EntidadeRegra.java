/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.modulo.cadastro.regras;

import br.com.brunobs.bswvendas.modulo.cadastro.model.dao.DAO;
import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Entidade;
import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;
import br.com.brunobs.bswvendas.suporte.util.AbstractFiltro;
import br.com.brunobs.bswvendas.suporte.util.ValidadorRegra;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.LogicalExpression;

/**
 *
 * @author Bruno
 */
public abstract class EntidadeRegra<t extends Entidade> {

    public Class classe = (Class<t>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    public DAO<t> dao;

    public abstract void verificaCadastro(t entidade) throws ValidacaoException;

    public abstract List consultaRelatorio(AbstractFiltro filtroPesquisa) throws ValidacaoException;

    public abstract String getPathRelatorio();

    private void validarEntidade(t entidade) throws ValidacaoException {
        try {
            ValidadorRegra validador = new ValidadorRegra();
            validador.validar(entidade);
        } catch (Exception ex) {
            throw new ValidacaoException(ex.getMessage());
        }

    }

    private void antesSalvar(t entidade) throws ValidacaoException {
        verificaCadastro(entidade);
        validarEntidade(entidade);

    }

    private void antesExcluir(t entidade) throws org.hibernate.exception.ConstraintViolationException, ValidacaoException {
    }

    private void antesEditar(t entidade) throws ValidacaoException, ValidacaoException {
        verificaCadastro(entidade);
        validarEntidade(entidade);
    }

    public void excluir(t entidade) throws ValidacaoException, org.hibernate.exception.ConstraintViolationException {
        antesExcluir(entidade);
        dao.deletar(entidade);
    }

    public void salvar(t entidade) throws ValidacaoException {
        antesSalvar(entidade);
        dao.salvar(entidade);
    }

    public void editar(t entidade) throws ValidacaoException {
        antesEditar(entidade);
        dao.alterar(entidade);
    }

    public void atualizaObjeto(t obj) throws ValidacaoException {
        dao.atualizaObjeto(obj);
    }

    public t retorna(Integer id) throws ValidacaoException {
        return (t) dao.buscaPorID(id);
    }

    public List<t> pesquisar(String chave, String valor) throws ValidacaoException {
        return dao.pesquisarPorParamentro(chave, valor, chave);

    }

    public List<t> pesquisar(String ordem) throws ValidacaoException {
        return dao.pesquisarTodos(ordem);

    }

    public List<t> pesquisarPorParamentro(String propriedade, Object valor, String ordem) throws ValidacaoException {
        return dao.pesquisarPorParamentro(propriedade, valor, ordem);
    }

    public List<t> pesquisarPorParamentroComAlias(String alias, String propriedade, Object valor, String ordem) throws ValidacaoException {
        return dao.pesquisarPorParamentroComAlias(alias, propriedade, valor, ordem);
    }

    public List<t> pesquisarPorParamentroComAlias(String alias, String propriedade, List<LogicalExpression> listExpress, String ordem) throws ValidacaoException {
        return dao.pesquisarComCondicaoComAlias(alias, propriedade, listExpress, ordem);

    }

    public List<t> pesquisarPorParamentro(List<LogicalExpression> listExpress, String ordem) throws ValidacaoException {
        return dao.pesquisarComCondicao(listExpress, ordem);
    }

    public t pesquisaPor(String valor) throws ValidacaoException {
        return (t) dao.buscaPorObjeto(valor);
    }

    public List<t> pesquisarTodos(String ordenacao) throws ValidacaoException {
        return dao.pesquisarTodos(ordenacao);
    }

    public Criteria getCriteria() {
        return dao.getCriteria();
    }

    public List<t> pesquisaPorCriteria(Criteria criteria) {
        return dao.pesquisaPorCriteria(criteria);
    }
//    public JasperPrint chamaRelatorio(String path, ParametroRelatorio parametros, List lista) throws RelatorioException {
//        JasperPrint jp = null;
//        if (lista.size() <= 0) {
//            throw new RelatorioException("O documento não contém páginas");
//        }
//        try {
//            jp = JasperReport(path, parametros, lista);
//
//        } catch (Exception ex) {
//            System.out.println(path);
//            ex.printStackTrace();
//            throw new RelatorioException(ex.getMessage());
//        }
//
//        return jp;
//    }
//
//    private JasperPrint JasperReport(String path, ParametroRelatorio ParametroRelatorio, List lista) throws RelatorioException {
//        JasperPrint jp = null;
//        if (lista.size() < 1) {
//            throw new RelatorioException("O documento não contém páginas");
//        }
//        try {
//            InputStream arquivo = getClass().getResourceAsStream(path);
//            JRDataSource jrds = new JRBeanCollectionDataSource(lista);
//            jp = JasperFillManager.fillReport(arquivo, ParametroRelatorio.retornaMap(), jrds);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new RelatorioException(ex.getMessage());
//        }
//        return jp;
//    }
}
