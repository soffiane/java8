package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream : sequentiels ou paralleles
 * paralleles pour etre traites par plusieurs threads
 * par defaut sequentiels
 * créer un stream parallele avec parallelStream()
 * convertir sequentiel en parallele : parallel()
 * convertir parallele en sequentiel : sequential()
 * <p>
 * Pourquoi ?
 * plus rapide, efficace
 * attention à l'ordonnancement du Stream, des operations...
 * acces concurrents à risques
 */

public class StreamsParalleles {

    public static void main(String[] args) {
        /*List<String> liste = new ArrayList<>();
        for(int i =0;i<10;i++){
            liste.add(""+i);
        }

        //liste.stream().forEach(System.out::println);
        liste.parallelStream().forEach(System.out::println);
        //le stream parallele n'affiche pas les elements dans l'ordre*/

        List<Facture> liste = new ArrayList<>();
        liste.add(new Facture("2016", 1234.56, "Soffiane"));
        liste.add(new Facture("2017", 4567.56, "Mounir"));
        liste.add(new Facture("2018", 89.56, "Hassiba"));
        liste.add(new Facture("2019", 12034.56, "Sonia"));

        String result = liste.stream().filter(facture -> facture.getTotal() > 2000)
                .map(Facture::getNumero)
                .collect(Collectors.joining(":"));

        System.out.println(result);

        //streams paralleles : provoquent des desordonnancements parfois
        liste.stream().filter(facture -> facture.getTotal() > 2000)
                .parallel()
                .map(Facture::getTotal)
                .forEach(System.out::println);

        liste.parallelStream()
                .filter(facture -> facture.getTotal() > 4000)
                .map(Facture::getTotal)
                .forEach(System.out::println);

        //stream sequentiels
        liste.stream().filter(facture -> facture.getTotal() > 4000)
                .sequential()
                .map(Facture::getTotal)
                .forEach(System.out::println);
    }

}
