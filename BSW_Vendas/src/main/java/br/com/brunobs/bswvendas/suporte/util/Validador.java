/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validador {

    public boolean valorNumerico() default false;

    public boolean valorMonetario() default false;

    public boolean Documento() default false;

    public boolean obrigatorio() default true;

    public boolean data() default false;

    public String Descricao() default "";
}
