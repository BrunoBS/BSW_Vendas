/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;

/**
 *
 * @author Bruno
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
