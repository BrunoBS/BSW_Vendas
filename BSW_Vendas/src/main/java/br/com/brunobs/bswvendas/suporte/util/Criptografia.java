package br.com.brunobs.bswvendas.suporte.util;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class Criptografia {

    public static String cifra(String mensagem, int chave) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mensagem.length(); i++) {
            char c = (char) (mensagem.charAt(i) + chave);
            builder.append(c);
        }

        return builder.toString();
    }

    public static String decifra(String mensagem, int chave) {
        return cifra(mensagem, -chave);
    }
}
