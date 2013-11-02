/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import br.com.brunobs.bswvendas.suporte.util.Validador;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 *
 */
@Entity
@Table(name = "precos")
public class Precos extends Entidade<Precos> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "descricao", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private DescricaoPreco descricao;
    @Basic(optional = false)
    @Validador(obrigatorio = true, Descricao = "Valor da Venda")
    @Column(name = "valorVenda")
    private BigDecimal valorVenda;
    @Basic(optional = false)
    @Validador(obrigatorio = true, Descricao = "Valor da Compra")
    @Column(name = "valorCompra")
    private BigDecimal valorCompra;
    @Basic(optional = false)
    @Validador(obrigatorio = true, Descricao = "Quantidade")
    private BigDecimal quantidade;
    @Validador(obrigatorio = true, Descricao = "Produto")
    @JoinColumn(name = "produto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produto produto;
    @Column(name = "alteradoEm")
    @Temporal(TemporalType.DATE)
    private Date alteradoEm;

    public Precos(Precos preco) {
        this.codigo = preco.getCodigo();
        this.descricao = preco.getDescricao();
        this.valorCompra = preco.getValorCompra();
        this.valorVenda = preco.getValorVenda();
        this.quantidade = preco.getQuantidade();
        this.produto = preco.getProduto();
    }

    public Precos() {
    }

    public Precos(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public DescricaoPreco getDescricao() {
        return descricao;
    }

    public void setDescricao(DescricaoPreco descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof Precos)) {
            return false;
        }
        Precos other = (Precos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getValorVenda().toString();
    }

    @Override
    public String getDescricaoEntidade() {
        return "\nCódigo: " + getCodigo()
                + "\nCompra: " + getValorCompra()
                + "\nVenda: " + getValorVenda()
                + "\nQuantidade: " + getQuantidade();
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public Date getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(Date alteradoEm) {
        this.alteradoEm = alteradoEm;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
