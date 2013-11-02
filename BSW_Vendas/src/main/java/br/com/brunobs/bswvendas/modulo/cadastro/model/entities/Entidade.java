/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 * @GitHub: Brunobs
 *
 */
public abstract class Entidade<T> {

    @Transient
    private List<T> listaEntidade = new ArrayList<T>();

    public abstract Integer getCodigo();

    public void addEntidadeNaAgendaDaLista(T t) {
        listaEntidade.add(t);
    }

    public void addListaDeEntidadeNaAgendaDaLista(List<T> Ts) {
        listaEntidade.addAll(Ts);
    }

    public List<T> getListaEntidade() {
        return listaEntidade;
    }

    public void setListaEntidade(List<T> Ts) {
        this.listaEntidade = Ts;
    }

    public abstract String getDescricaoEntidade();

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getCodigo() != null ? getCodigo().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DescricaoPreco)) {
            return false;
        }
        DescricaoPreco other = (DescricaoPreco) object;
        if ((this.getCodigo() == null && other.getCodigo() != null) || (this.getCodigo() != null && !this.getCodigo().equals(other.getCodigo()))) {
            return false;
        }
        return true;
    }
}
