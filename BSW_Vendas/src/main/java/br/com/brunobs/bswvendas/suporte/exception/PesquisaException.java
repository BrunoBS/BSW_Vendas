/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.exception;

/**
 *
 * @author Bruno
 */
public class PesquisaException extends BsException {

    public PesquisaException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
