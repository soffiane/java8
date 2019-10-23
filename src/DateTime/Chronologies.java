package DateTime;

import java.time.chrono.Chronology;
import java.util.Set;

/**
 * les chronologies represente des systemes calendaires
 * package java.time.chrono
 * on peut créer de nouveaux calendrier avec des impl de Chronology et Era
 * creer une date : dateNow, date, DateYearDay
 * manipuler des ChronoLocalDate et des ChronoPeriod
 * Obtenir des ChronoZonedDateTime
 */

public class Chronologies {
    public static void main(String[] args){

        Set<Chronology> lesChronos = Chronology.getAvailableChronologies();
        //la liste des chronologies : japanese, Hijrah, thaibuddist,ISO,minguo
        for(Chronology c : lesChronos){
            System.out.println(c.toString());
        }

        //recuperer une chronologie specifique
        Chronology japanese = Chronology.of("Japanese");
        System.out.println(japanese.toString());
        //Japanese Reiwa 1-08-01
        System.out.println(japanese.dateNow());
        //ere
        System.out.println(japanese.dateNow().getEra());
        //longueur de l'année
        System.out.println(japanese.dateNow().lengthOfYear());


        Chronology hijrah = Chronology.of("Hijrah-umalqura");
        System.out.println(hijrah.toString());
        //Hijrah-umalqura AH 1440-11-29
        System.out.println(hijrah.dateNow());
        System.out.println(hijrah.dateNow().getEra());
        //longueur de l'année
        System.out.println(hijrah.dateNow().lengthOfYear());

    }
}
