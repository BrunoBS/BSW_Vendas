/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.modulo.cadastro.controller;

import br.com.brunobs.bswvendas.modulo.cadastro.model.entities.Categoria;
import br.com.brunobs.bswvendas.modulo.cadastro.regras.CategoriaRegra;
import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS 
 * 
 */
@ManagedBean(name = "mbCategoria") 
@SessionScoped
public class MbCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;

    public MbCategoria() {
    }

    private CategoriaRegra regra() {
        return new CategoriaRegra();
    }

    public String novaCategoria() {
        categoria = new Categoria();
        return "/restrito/categoria/categoria.faces";
    }

    public String editarCategoria() {
        return "/restrito/categoria/categoria.faces";
    }

    public String salvarCategoria() {
        if (categoria.getCodigo() == null || categoria.getCodigo() == 0) {
            salvar();
        } else {
            editar();
        }
        return null;
    }

    private void salvar() {
        try {
            regra().salvar(categoria);
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro salvo com Sucesso!", "");
            novaCategoria();
        } catch (ValidacaoException ex) {
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o Registro!\n" + ex.getMessage(), "");
        }
    }

    private void editar() {
        try {
            regra().editar(categoria);
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro editar com Sucesso!", "");
            novaCategoria();
        } catch (ValidacaoException ex) {
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar o Registro!\n" + ex.getMessage(), "");
        }
    }

    public void excluir() {
        try {
            regra().excluir(categoria);
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluir com Sucesso!", "");
            novaCategoria();
        } catch (ValidacaoException ex) {
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir o Registro!\n" + ex.getMessage(), "");
        }
    }

    public List<Categoria> getCategorias() {
        try {
            categorias = regra().pesquisarTodos(categoria.getNome());
            novaCategoria();
        } catch (ValidacaoException ex) {
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
