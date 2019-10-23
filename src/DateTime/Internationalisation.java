package DateTime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;

/**
 * Internationalisation : chronology et formattage des dates
 * DateTimeFormatter
 *  Chaque chrono a son propre formattage
 *  On peut definir un style : FormatStyle, DecimalStyle
 *  methodes : ofLocalizedTime, Time
 *  formatters predefinis : BASIC_ISO_DATE...
 *  ofPattern("yyyy-MM-dd")
 */

public class Internationalisation {

    public static void main(String[] args){
        LocalDateTime date = LocalDateTime.of(2020, Month.AUGUST, 6, 6, 6, 6);
        //a la japonaise
        JapaneseDate jdate = JapaneseDate.from(date);
        System.out.println(jdate.toString());

        //en minguo
        MinguoDate minguo = MinguoDate.from(date);
        System.out.println(minguo.toString());

        //formattage
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        //20200806
        System.out.println(date.format(dtf));

        DateTimeFormatter dtfbis = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        //06/08/2020
        System.out.println(date.format(dtfbis));

        //format francais
        DateTimeFormatter dtfter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(date.format(dtfter));
    }
}
