/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

/**
 *
 * @author Bruno
 */
public class IsNumero {

    public static boolean isDinheiro(String valor) {
        final String NUMEROS = "0123456789.";
        for (int i = 0; i < valor.length(); i++) {
            char caracter = valor.charAt(i);
            if (NUMEROS.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumero(String valor) {
        final String NUMEROS = "0123456789";
        for (int i = 0; i < valor.length(); i++) {
            char caracter = valor.charAt(i);
            if (NUMEROS.indexOf(caracter) == -1) {
                return false;
            }
        }
        return true;
    }

    public static String valorMonetario(String valor) {
        int pontos = -1;
        valor = valor.replaceAll(",", ".");
        valor = valor.replace("..", ".");
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) == '.') {
                pontos++;
            }

        }
        if (!IsNumero.isDinheiro(valor) || valor.equals("") || pontos > 0) {
            return "";

        } else {
            if (pontos == -1) {
                valor += ".00";
            } else if (valor.indexOf(".") > 0) {
                if (valor.indexOf(".") == valor.length() - 1) {
                    valor += "00";
                } else if (valor.indexOf(".") == valor.length() - 2) {
                    valor += "0";
                }
                valor = valor.substring(0, valor.indexOf(".") + 3);
            }

        }
        return valor;

    }
}