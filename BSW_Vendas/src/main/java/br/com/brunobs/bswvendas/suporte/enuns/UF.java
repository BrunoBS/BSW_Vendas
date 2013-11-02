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

public enum UF {

    AC("AC"),
    AL("AL"),
    AM("AM"),
    AP("AP"),
    BA("BA"),
    CE("CE"),
    DF("DF"),
    ES("ES"),
    GO("GO"),
    MA("MA"),
    MG("MG"),
    MS("MS"),
    MT("MT"),
    PA("PA"),
    PB("PB"),
    PE("PE"),
    PI("PI"),
    PR("PR"),
    RJ("RJ"),
    RN("RN"),
    RO("RO"),
    RR("RR"),
    RS("RS"),
    SC("SC"),
    SE("SE"),
    SP("SP"),
    TO("TO"),
    EX("EX");
    private final String valor;
    private static final Map<String, UF> valueMap = new HashMap<String, UF>();

    static {
        for (UF tipo : values()) {
            valueMap.put(tipo.getDescricao(), tipo);
        }
    }

    private UF(String valor) {
        this.valor = valor;
    }

    public static UF fromDescricao(String descricao) {
        return valueMap.get(descricao);
    }

    public String getDescricao() {
        return valor;
    }
}
