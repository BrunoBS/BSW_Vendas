/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Bruno
 */
public class Mascara {

    //Formato CPF  
   public  static DefaultFormatterFactory getFormatoCpf() {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter("###.###.###-##");
          //  comFoco.setPlaceholderCharacter('_');
            comFoco.setOverwriteMode(true);
            comFoco.setValidCharacters("0123456789");
        } catch (Exception pe) {
          
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }

    //Formato CNPJ  
  public  static DefaultFormatterFactory getFormatoCnpj() {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter("##.###.###/####-##");
               //  comFoco.setPlaceholderCharacter('_');
            comFoco.setOverwriteMode(true);
            comFoco.setValidCharacters("0123456789");
        } catch (Exception pe) {
            
            
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }

    //Formato CEP
  public  static DefaultFormatterFactory getFormatoCep() {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter("#####-###");
               //  comFoco.setPlaceholderCharacter('_');
            comFoco.setOverwriteMode(true);
            comFoco.setValidCharacters("0123456789");
        } catch (Exception pe) {
     
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }

    //Formato DATA
  public  static DefaultFormatterFactory getFormatoData() {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter("##/##/####");
      
            comFoco.setOverwriteMode(true);
            comFoco.setValidCharacters("0123456789");
        } catch (Exception pe) {
         
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }
     
    
    //Formato TELEFONE
  public  static DefaultFormatterFactory getFormatoTelefone() {
        MaskFormatter comFoco = null;
        try {
            comFoco = new MaskFormatter("## ####-####");
              //  comFoco.setPlaceholderCharacter('_');
            comFoco.setOverwriteMode(true);
            comFoco.setValidCharacters("0123456789");
        } catch (Exception pe) {
         
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco, comFoco);
        return factory;
    }
}
