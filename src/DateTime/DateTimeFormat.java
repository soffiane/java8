package DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;

/**
 * gestion du temps local
 * classes : LocalTime, LocalDate, LocalDateTime
 *
 * LocalDate : constante MAX et MIN
 * methodes :
 * creation : atTime()
 * getter : getDayOfMonth()...
 * info sur le mois, année....
 * date maintenant (now())
 * modifications : plus(), minus(), with()...
 *
 * gestion du temps zoné
 * ZonedDateTime
 * creation : of(), now()
 * modif : plus(), minus(), with()
 * temps restant : until()
 * offset : getOffset()
 *
 * Formattage date et heure : format de la chaine XXXX-XX-XX etc...
 * java.time.format
 * DateTimeFormatter (simple) et DateTimeFormatterBuilder (cas complexes)
 *
 * afficher et parser des dates (pas d'argument null)
 *
 * Formatter :
 * transformer date en chaine et vice et versa
 * constantes, styles et motifs predefinies
 *
 * DateTimeFormatterBuilder : builder de base pour les DateTimeFormatter
 * fait apparaitre les elements suivants :
 * valeur, fraction, text
 * offset, zoneid, zonetext,
 * chronologyId, ChronologyText
 * Literal
 * nested et optional
 */

public class DateTimeFormat {

    public static void main(String[] args){
        Facture facture = new Facture("2016-1");
        System.out.println("facture :"+facture);
        System.out.println("reste avant echance "+facture.resteAvantEchance());

        facture.accept("01 01 2030");
        System.out.println("facture :"+facture);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String pouet = date.format(formatter);
        LocalDate parsedTime =  LocalDate.parse(pouet,formatter);
        System.out.println("date :"+date);
        System.out.println("parsedTime :"+parsedTime);

        /*DateTimeFormatter formatter1 = new DateTimeFormatterBuilder()
                .appendLiteral("New year in ")
                .appendValue(ChronoField.YEAR)
                .appendLiteral(" is on ")
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
                .toFormatter();
        pouet = date.format(formatter1);
        LocalDate parsedTime1 =  LocalDate.parse(pouet,formatter1);
        System.out.println("date :"+date);
        System.out.println("parsedTime :"+parsedTime);*/


    }
}
