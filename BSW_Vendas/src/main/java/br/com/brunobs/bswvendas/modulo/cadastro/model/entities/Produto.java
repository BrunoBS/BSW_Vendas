package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import br.com.brunobs.bswvendas.suporte.enuns.FiltroOpcaoSimNao;
import br.com.brunobs.bswvendas.suporte.enuns.SituacaoCadastro;
import br.com.brunobs.bswvendas.suporte.util.Validador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "produtos")
public class Produto extends Entidade<Produto> implements Serializable {

    @Basic(optional = false)
    @Column(name = "situacao")
    @Type(type = "oficinas.regras.typeEnum.SituacaoCadastroEnum")
    private SituacaoCadastro situacao;
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Precos> listaDePrecos = new ArrayList<Precos>();
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "codigoReduzido")
    @Validador(Descricao = "Código Reduzido", valorNumerico = true)
    private String codigoReduzido;
    @Basic(optional = false)
    @Column(name = "nome")
    @Validador(Descricao = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "nomeReduzido")
    @Validador(Descricao = "Nome Reduzido")
    private String nomeReduzido;
    @JoinColumn(name = "categoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    @Validador(Descricao = "Categoria")
    private Categoria categoria;
    @Column(name = "materiaPrima")
    @Type(type = "oficinas.regras.typeEnum.FiltroOpcaoSimNaoEnum")
    private FiltroOpcaoSimNao materiaPrima;
    @JoinColumn(name = "unidade", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    @Validador(Descricao = "Unidade")
    private Unidade unidade;
    @Lob
    @Column(name = "descricao")
    @Basic(optional = true)
    @Validador(Descricao = "Descrição", obrigatorio = false)
    private String descricao;
    @Transient
    private Categoria categoriaOriginal;

    public Produto() {
    }

    public Produto(Produto outro) {
        this.situacao = outro.situacao;
        this.codigo = outro.codigo;
        this.listaDePrecos = new ArrayList<Precos>(outro.listaDePrecos);
        this.codigoReduzido = outro.codigoReduzido;
        this.nome = outro.nome;
        this.nomeReduzido = outro.nomeReduzido;
        this.categoria = outro.categoria;
        this.unidade = outro.unidade;
        this.descricao = outro.descricao;
        this.categoriaOriginal = outro.categoriaOriginal;
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoriaOriginal() {
        return categoriaOriginal;
    }

    public void setCategoriaOriginal(Categoria categoriaOriginal) {
        this.categoriaOriginal = categoriaOriginal;
    }

    public String getCodigoReduzido() {
        return codigoReduzido;
    }

    public void setCodigoReduzido(String codigoReduzido) {
        this.codigoReduzido = codigoReduzido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeReduzido() {
        return nomeReduzido;
    }

    public void setNomeReduzido(String nomeReduzido) {
        this.nomeReduzido = nomeReduzido;
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

    public FiltroOpcaoSimNao getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(FiltroOpcaoSimNao materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoReduzido + " - " + nome;
    }

    @Override
    public String getDescricaoEntidade() {
        return "\nCódigo: " + getCodigo()
                + "\nCódigo Reduzido: " + getCodigoReduzido()
                + "\nNome: " + getNome()
                + "\nCategoria: " + getCategoria().toString()
                + "\nUnidade: " + getUnidade().toString()
                + "\nDescrição: " + getDescricao()
                + "\nSituacao: " + getSituacao().getDescricao();
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    public List<Precos> getListaDePrecos() {
        return listaDePrecos;
    }

    public void setListaDePrecos(List<Precos> precosList) {
        this.listaDePrecos = precosList;
    }

    public void addistaDePrecos(Precos preco) {
        this.listaDePrecos.add(preco);
    }
}
