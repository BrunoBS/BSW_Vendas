package br.com.brunobs.bswvendas.suporte.util;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class Mascara {

    private static String validCharactersNumerico = "0123456789";

    public static DefaultFormatterFactory getFormato(String mascara) throws Exception {
        MaskFormatter comFoco = null;
        comFoco = new MaskFormatter(mascara);
        //  comFoco.setPlaceholderCharacter('_');
        comFoco.setOverwriteMode(true);
        comFoco.setValidCharacters(validCharactersNumerico);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }
}
