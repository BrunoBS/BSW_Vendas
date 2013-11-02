package br.com.brunobs.bswvendas.modulo.cadastro.model.entities;

import br.com.brunobs.bswvendas.suporte.enuns.SituacaoCadastro;
import br.com.brunobs.bswvendas.suporte.util.Validador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
@Entity
@Table(name = "categorias")
public class Categoria extends Entidade<Categoria> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nome")
    @Validador(Descricao = "Nome")
    private String nome;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<DescricaoPreco> listaDeDescricaoPreco = new ArrayList<DescricaoPreco>();
    @Basic(optional = false)
    @Column(name = "meioPreco")
    private Boolean meioPreco;
    @Column(name = "situacao")
    @Enumerated(EnumType.STRING)
    private SituacaoCadastro situacao;

    public Categoria() {
    }

    @Override
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Categoria(Categoria outra) {
        this.codigo = outra.codigo;
        this.listaDeDescricaoPreco = new ArrayList<DescricaoPreco>(outra.listaDeDescricaoPreco);
        this.situacao = outra.situacao;
        this.meioPreco = outra.meioPreco;
        this.codigo = outra.codigo;
        this.codigo = outra.codigo;
        this.nome = outra.nome;
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    public Boolean getMeioPreco() {
        return meioPreco;
    }

    public void setMeioPreco(Boolean meioPreco) {
        this.meioPreco = meioPreco;
    }

    public List<DescricaoPreco> getListaDeDescricaoPreco() {
        return listaDeDescricaoPreco;
    }

    public void setListaDeDescricaoPreco(List<DescricaoPreco> listaDeDescricaoPreco) {
        this.listaDeDescricaoPreco = listaDeDescricaoPreco;
    }

    public void addListaDeDescricaoPreco(DescricaoPreco DescricaoPreco) {
        this.listaDeDescricaoPreco.add(DescricaoPreco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public String getDescricaoEntidade() {
        return "\nCódigo: " + getCodigo()
                + "\nNome: " + getNome()
                + "\nSituação: " + getSituacao().getDescricao();
    }
}
