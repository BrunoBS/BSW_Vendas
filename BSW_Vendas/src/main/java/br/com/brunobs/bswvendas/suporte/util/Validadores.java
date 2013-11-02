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
public class Validadores {

    public static String isValorMonetario(Double valorM) {
        String valor = valorM.toString();
        return isValorMonetario(valor);

    }

    public static String isValorMonetario(String valor) {

        int pontos = -1;
        valor = valor.replaceAll(",", ".");
        valor = valor.replace("..", ".");
        for (int i = 0; i < valor.length(); i++) {
            if (valor.charAt(i) == '.') {
                pontos++;
            }
        }
        if (!isDinheiro(valor) || valor.equals("") || pontos > 0) {
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

    private static boolean isDinheiro(String valor) {
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

    public static String removeFormatacaoDocumento(String digits) {
        digits = digits.replaceAll("\\.", "").trim();
        digits = digits.replaceAll("-", "").trim();
        digits = digits.replaceAll("/", "").trim();
        return digits;
    }

    public static void validaDocumento(String digits) throws ValidacaoException {


        if (!Validadores.isNumero(digits)) {
            throw new ValidacaoException("Documento Inválido!");
        }
        if (digits.length() == 11) {
            validarCPF(digits);
        } else if (digits.length() == 14) {
            validarCNPJ(digits);
        } else {
            throw new ValidacaoException("Documento Inválido!");
        }
    }

    private static void validarCPF(String digits) throws ValidacaoException {
        try {
            boolean isvalid = false;

            if (Long.parseLong(digits) % 10 == 0) {
                isvalid = somaPonderadaCPF(digits) % 11 < 2;
            } else {
                isvalid = somaPonderadaCPF(digits) % 11 == 0;
            }
            if (!isvalid) {
                throw new ValidacaoException("CPF Inválido!");
            }
        } catch (Exception ex) {
            throw new ValidacaoException("Verifique: " + ex.getMessage() + "!");
        }
    }

    private static void validarCNPJ(String digits) throws ValidacaoException {
        try {
            boolean isvalid = false;
            if (Long.parseLong(digits) % 10 == 0) {
                isvalid = somaPonderadaCNPJ(digits) % 11 < 2;
            } else {
                isvalid = somaPonderadaCNPJ(digits) % 11 == 0;
            }

            if (!isvalid) {
                throw new ValidacaoException("CNPJ Inválido!");
            }
        } catch (Exception ex) {
            throw new ValidacaoException("CNPJ Inválido! \nVerifique: " + ex.getMessage() + "!");
        }
    }

    private static int somaPonderadaCPF(String digits) {
        char[] cs = digits.toCharArray();
        int soma = 0;
        for (int i = 0; i < cs.length; i++) {
            soma += Character.digit(cs[i], 10) * (cs.length - i);
        }
        return soma;
    }

    private static int somaPonderadaCNPJ(String digits) {
        char[] cs = digits.toCharArray();
        int soma = 0;
        for (int i = 0; i < cs.length; i++) {
            int index = cs.length - i - 1;
            soma += Character.digit(cs[i], 10) * ((index % 9 + 1) + (index / 9));
        }
        return soma;
    }
}
