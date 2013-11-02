package br.com.brunobs.bswvendas.suporte.exception;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class ValidacaoException extends Exception {

    protected String msg;

    public ValidacaoException(String msg) {
        super(msg);
        this.msg = msg;

    }
}