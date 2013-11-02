/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Bruno
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
