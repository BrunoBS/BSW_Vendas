package br.com.brunobs.bswvendas.suporte.util;

import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class ValidarCampos<tipo> {

    public void validar(tipo entidade) throws ValidacaoException {
        try {
            ValidadorRegra validador = new ValidadorRegra();
            validador.validar(entidade);
        } catch (Exception ex) {
            throw new ValidacaoException(ex.getMessage());
        }
    }
}
