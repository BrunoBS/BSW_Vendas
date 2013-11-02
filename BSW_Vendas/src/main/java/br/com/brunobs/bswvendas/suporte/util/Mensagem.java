/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class Mensagem {

    public static void ERRO(Component componente, String mensagem) {
        JOptionPane.showMessageDialog(componente, mensagem, "ERRO!", JOptionPane.ERROR_MESSAGE);
    }

    public static void ERRO_DESCONHECIDO(Component componente) {
        JOptionPane.showMessageDialog(componente, "Ops! aconteceu um erro desconhecido não foi possível realizar a sua solicitação!", "ERRO!", JOptionPane.ERROR_MESSAGE);
    }

    public static void REGISTRO_DEPENDENTE(Component componente) {
        JOptionPane.showMessageDialog(componente, "Não é possível Excluir Esse Registro, \n Ele está sendo usado por outro registro!", "ERRO!", JOptionPane.ERROR_MESSAGE);
    }

    public static void ATENCAO(Component componente, String mensagem) {
        JOptionPane.showMessageDialog(componente, mensagem, "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
    }

    public static void REGISTRO_TABELA(Component componente) {
        JOptionPane.showMessageDialog(componente, "Selecione um registro!", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
    }

    public static void REGISTRO_TABELA_VAZIO(Component componente) {
        JOptionPane.showMessageDialog(componente, "Nenhum Registro foi encontrado!", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE);
    }

    public static void SUCESSO(Component componente, String mensagem) {
        JOptionPane.showMessageDialog(componente, mensagem, "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean PERGUNTA(Component componente, String mensagem) {
        return JOptionPane.showConfirmDialog(componente, mensagem, "PERGUNTA!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null) == JOptionPane.YES_OPTION;
    }

    public static boolean PERGUNTA_EXCLUIR(Component componente, String mensagem) {
        return JOptionPane.showConfirmDialog(componente, "Deseja Excluir o Registro", "PERGUNTA!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null) == JOptionPane.YES_OPTION;
    }

    public static boolean PERGUNTA_SAIR(Component componente, String mensagem) {
        return JOptionPane.showConfirmDialog(componente, "Deseja Sair do(a) " + mensagem + "?", "PERGUNTA!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null) == JOptionPane.YES_OPTION;
    }

    public static void SALVAR(Component componente) {
        JOptionPane.showMessageDialog(componente, "Registro Salvo com Sucesso!", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void EDITAR(Component componente) {
        JOptionPane.showMessageDialog(componente, "Registro Editado com Sucesso!", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void EXCLUIR(Component componente) {
        JOptionPane.showMessageDialog(componente, "Registro Deletado com Sucesso!", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
    }
}
