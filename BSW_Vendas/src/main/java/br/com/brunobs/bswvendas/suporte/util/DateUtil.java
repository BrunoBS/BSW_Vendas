/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.brunobs.bswvendas.suporte.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bruno
 */
public class DateUtil {

    public static Date diferencaDatasPorHora(Date primeira, Date segunda) {
        long l1 = primeira.getTime();
        long l2 = segunda.getTime();
        long difference = l2 - l1;
        int timeInSeconds = (int) difference / 1000;
        int hours, minutes, seconds;
        hours = timeInSeconds / 3600;
        timeInSeconds = timeInSeconds - (hours * 3600);
        minutes = timeInSeconds / 60;
        timeInSeconds = timeInSeconds - (minutes * 60);
        seconds = timeInSeconds;
        return new Date(0, 0, 0, hours, minutes, seconds);
    }

    public static Date StringToDate(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
        }
        return date;
    }

    public static String DateToString(Date data, String mascara) {
        if (data != null) {
            SimpleDateFormat formatador = new SimpleDateFormat(mascara);
            return formatador.format(data);
        }
        return "";
    }

  
}
