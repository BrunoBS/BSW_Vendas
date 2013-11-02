package br.com.brunobs.bswvendas.suporte.exception;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class AutenticacaoException extends Exception {

    protected String msg;

    public AutenticacaoException(String msg) {
        super(msg);
        this.msg = msg;

    }
}
