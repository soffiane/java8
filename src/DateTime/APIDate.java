package DateTime;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * nouveau package : java.time
 * classes du package sont immutables
 * moins de confusion dans les noms de classes
 * chronologies != du ISO-8601
 *
 * classes LocalDate et LocalTime represente la date et l'heure locale
 * aussi LocalDateTime
 * methodes : now(), of(annee,mois,jour), parse(String), from()
 * modification avec withYear, withDayOfMonth...
 * ajusteurs permet d'ajuster une date/heure : java.time.temporal -> lastDayOfMonth()
 * on peut tronquer la date truncateTo(ChronoUnit.SECONDS)
 *
 * classes de zones :
 * classe ZoneID : ZoneId.of("Europe/Paris")
 * ZoneDateTime : date/heure avec la zone
 * OffsetDateTime : avec le decalage par rapport a UTC
 * OffsetTime : heure avec l'offset (decalage par rapport a UTC)
 *
 * Period : une durée en jour mois année
 * Duration : une durée en heure minute seconde
 *
 * chronoogies :
 * represente un systeme calendaire
 * IsoChronology, JapaneseChronology
 * factories pour les CHrnonoLocalDate(interface)
 * methode : dateNow(), date()...
 * classes implementant : JapaneseDate,
 */

public class APIDate {
    public static void main(String[] args){
        LocalDateTime tp = LocalDateTime.now();
        LocalTime lt = LocalTime.of(12,12,12);

        tp.minusMinutes(12);

        ZoneId zi = ZoneId.of("Europe/Paris");
        ZonedDateTime zdt = ZonedDateTime.of(tp,zi);

        zdt.withZoneSameLocal(ZoneId.of("Australia/Sydney"));

        Period p = Period.of(1,0,0);

        tp.plus(p);

        Duration d = Duration.of(12, ChronoUnit.MINUTES);

        Chronology chronology = Chronology.ofLocale(Locale.FRANCE);
        ChronoLocalDate cld = chronology.dateNow();
        int annee = cld.get(ChronoField.YEAR);
        System.out.println("annee FR : "+annee);

        cld = JapaneseDate.now();
        annee = cld.get(ChronoField.YEAR);
        System.out.println("annee JAP : "+annee);

    }
}
