package br.com.brunobs.bswvendas.suporte.enuns;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public enum SituacaoCadastro {

    ATIVO("ATIVO"),
    INATIVO("INATIVO");
    private final String valor;
    private static final Map<String, SituacaoCadastro> valueMap = new HashMap<String, SituacaoCadastro>();

    static {
        for (SituacaoCadastro tipo : values()) {
            valueMap.put(tipo.getDescricao(), tipo);
        }
    }

    private SituacaoCadastro(String valor) {
        this.valor = valor;
    }

    public static SituacaoCadastro fromDescricao(String descricao) {
        return valueMap.get(descricao);
    }

    public static String nomeCampo() {
        return "situacao";
    }

    public String getDescricao() {
        return valor;
    }
}
