package br.com.brunobs.bswvendas.suporte.util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Bruno Barbosa da Silva
 * @E-mail bbsgt@hotmail.com
 * @Site www.brunobs.com.br
 * @GitHub BrunoBS
 *
 */
public class verificaCaps {

    public static boolean verificarCapsLook() {
        boolean capsLigado = false;
        if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            capsLigado = Toolkit.getDefaultToolkit().getLockingKeyState(
                    KeyEvent.VK_CAPS_LOCK);
        }
        if (capsLigado) {
            return true;
        }

        return false;

    }
}
