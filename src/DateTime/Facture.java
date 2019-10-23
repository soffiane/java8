package DateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

public class Facture {
    String numero;
    ZonedDateTime date;
    LocalDate dateCreation;
    LocalDate echeance;
    //la facture doit etre payée dans 2 mois
    static Period dureeMax = Period.of(0,2,0);

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
    //on prepare notre formatter custom
    DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder()
            .appendLiteral(" le ")
            .appendValue(ChronoField.DAY_OF_MONTH)
            .appendLiteral(" du mois numero ")
            .appendValue(ChronoField.MONTH_OF_YEAR)
            .appendLiteral(" de l'an ")
            .appendValue(ChronoField.YEAR);

    public Facture(String numero) {
        this.numero = numero;
        this.dateCreation = LocalDate.now();
        echeance = dateCreation.plus(dureeMax);
        date = ZonedDateTime.now();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "numero='" + numero + '\'' +
                ", date=" + date +
                ", dateCreation=" + dateCreation.format(dtf) +
                ", echeance=" + echeance.format(dtfb.toFormatter()) +
                '}';
    }

    long resteAvantEchance(){
        //calcul de l'ecart entre aujourd'hui et date echeance en jour
        //return LocalDate.now().until(echeance, ChronoUnit.DAYS);
        //echance avant le dernier jour de l'année
        return LocalDate.now().until(echeance.with(lastDayOfYear()),ChronoUnit.DAYS);
    }

    public void accept(String str){
        //recuperer la date depuis un String
        dateCreation = LocalDate.parse(str,dtf);

    }
}
