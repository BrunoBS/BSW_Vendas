/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.enuns;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site: www.brunobs.com.br
 *
 */
public enum FiltroOpcaoSimNao {

    AMBOS("Ambos") {
        @Override
        public Criterion criterioPesquisa(String propertyName) {
            Criterion sim = Restrictions.eq(propertyName, SIM);
            Criterion nao = Restrictions.eq(propertyName, NAO);
            return Restrictions.or(sim, nao);

        }
    },
    SIM("Sim") {
        @Override
        public Criterion criterioPesquisa(String propertyName) {
            return Restrictions.eq(propertyName, this);
        }
    },
    NAO("Não") {
        @Override
        public Criterion criterioPesquisa(String propertyName) {
            return Restrictions.eq(propertyName, this);
        }
    };
    private final String valor;
    private static final Map<String, FiltroOpcaoSimNao> valueMap = new HashMap<String, FiltroOpcaoSimNao>();

    static {
        for (FiltroOpcaoSimNao tipo : values()) {
            valueMap.put(tipo.getDescricao(), tipo);
        }
    }

    public abstract Criterion criterioPesquisa(String propertyName);

    private FiltroOpcaoSimNao(String valor) {
        this.valor = valor;
    }

    public static FiltroOpcaoSimNao fromDescricao(String descricao) {
        return valueMap.get(descricao);
    }

    public String getDescricao() {
        return valor;
    }
}
