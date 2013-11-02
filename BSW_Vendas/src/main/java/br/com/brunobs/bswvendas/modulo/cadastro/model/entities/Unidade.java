/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import br.com.brunobs.bswvendas.suporte.enuns.SituacaoCadastro;
import br.com.brunobs.bswvendas.suporte.util.Validador;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 *
 */
@Entity
@Table(name = "unidades")
public class Unidade extends Entidade<Unidade> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "situacao")
    @Type(type = "oficinas.regras.typeEnum.SituacaoCadastroEnum")
    private SituacaoCadastro situacao;
    @Basic(optional = false)
    @Column(name = "nome")
    @Validador(Descricao = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "simbolo")
    @Validador(Descricao = "simbolo")
    private String simbolo;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> listaDeProduto;

    public Unidade() {
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Produto> getListaDeProduto() {
        return listaDeProduto;
    }

    public void setListaDeProduto(List<Produto> listaDeProduto) {
        this.listaDeProduto = listaDeProduto;
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return simbolo + " - " + nome;
    }

    @Override
    public String getDescricaoEntidade() {
        return "\nCódigo: " + getCodigo()
                + "\nNome: " + getNome()
                + "\nSimbolo: " + getSimbolo()
                + "\nSituação: " + getSituacao().getDescricao();
    }
}
