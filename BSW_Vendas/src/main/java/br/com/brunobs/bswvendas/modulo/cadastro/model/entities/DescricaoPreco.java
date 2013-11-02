package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import br.com.brunobs.bswvendas.suporte.enuns.SituacaoCadastro;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
@Entity
@Table(name = "descricaopreco")
public class DescricaoPreco extends Entidade<DescricaoPreco> implements Serializable {

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
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "categoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(mappedBy = "descricao")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Precos> precosprodutosList;

    public DescricaoPreco() {
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Precos> getPrecosprodutosList() {
        return precosprodutosList;
    }

    public void setPrecosprodutosList(List<Precos> precosprodutosList) {
        this.precosprodutosList = precosprodutosList;
    }

 

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public String getDescricaoEntidade() {
        return "\nCódigo: " + getCodigo()
                + "\nNome: " + getDescricao()
                + "\nCategoria: " + getCategoria().getNome();
    }
}
