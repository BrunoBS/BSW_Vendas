/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.exception;

/**
 *
 * @author Bruno
 */
public class ValidacaoException extends BsException {

    public ValidacaoException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
