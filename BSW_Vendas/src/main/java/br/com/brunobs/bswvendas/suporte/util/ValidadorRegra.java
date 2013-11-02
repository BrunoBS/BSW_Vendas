package br.com.brunobs.bswvendas.suporte.util;

import br.com.brunobs.bswvendas.suporte.exception.ValidacaoException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorRegra {

    private Validador validacao;

    public void validar(Object obj) throws Exception {
        Class classe = obj.getClass();
        Field[] fields = classe.getDeclaredFields();
        for (Field field : fields) {
            validacao = field.getAnnotation(Validador.class);
            field.setAccessible(true);
            if (validacao != null) {
                if (validacao.obrigatorio()) {
                    if (field.get(obj) == null) {
                        throw new ValidacaoException("Campo " + validacao.Descricao() + " não está preenchido!");
                    }
                    String nome = field.get(obj).toString();
                    if ("".equals(nome)) {
                        throw new ValidacaoException("Campo " + validacao.Descricao() + " não está preenchido!");
                    }
                }
                if (validacao.valorNumerico()) {
                    if (field.get(obj) == null) {
                        throw new ValidacaoException("O Campo " + validacao.Descricao() + " não é  valor número válido!");
                    }
                    valorNumerico(field.get(obj).toString());
                }
                if (validacao.valorMonetario()) {
                    if (field.get(obj) == null) {
                        throw new ValidacaoException("O Campo " + validacao.Descricao() + " não é  valor Monetário válido!");
                    }
                    field.set(obj, valorMonetario((Double) field.getDouble(obj)));
                }
                if (validacao.Documento()) {
                    if (!validacao.obrigatorio() && (Validadores.removeFormatacaoDocumento(field.get(obj).toString())).isEmpty()) {
                        return;
                    }
                    Validadores.validaDocumento(field.get(obj).toString());
                }

                if (validacao.data()) {
                    validaData((Date) field.get(obj));
                }
            }
        }
    }

    private void validaData(Date dateToValidate) throws ValidacaoException {
        if (!validacao.obrigatorio() && dateToValidate == null) {
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String result = sdf.format(dateToValidate);
        if (result.length() != 10) {
            throw new ValidacaoException("O Campo " + validacao.Descricao() + " não é uma Data válida!");
        }
    }

    private void valorNumerico(String valor) throws ValidacaoException {
        if (!Validadores.isNumero(valor)) {
            throw new ValidacaoException("O Campo " + validacao.Descricao() + " não é  valor número válido!");
        }
    }

    private String valorMonetario(Double valor) throws ValidacaoException {
        String dinheiro = Validadores.isValorMonetario(valor);
        if (dinheiro.isEmpty() || dinheiro.equals("0")) {
            throw new ValidacaoException("O Campo " + validacao.Descricao() + " não é  valor Monetário válido!");
        } else {
            return dinheiro;

        }

    }
}
