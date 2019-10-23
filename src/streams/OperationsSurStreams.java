package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * methodes intermediaires :
 * distinct() : retourne un Stream dont les elements sont distincts (pas de doublons)
 * filter(Predicate) : retourne un Stream dont les elements qui correspondent au Predicate
 * flatMap(Function) : retourne un Stream dont les elements sont remplacés par les élements
 * du Stream fournit par la fonction
 * limit(limit): retourne un Stream limité en nb d'elements
 * map(Function) : retourne un Stream dont on a applique la fonction a chaque element
 * peek(Consumer : fct qui accept un element) : retourne un Stream dont les elements sont les memes mais
 * la fonction est appliqué a chaque element
 * skip(long) : retourne le Stream dont on a sauté les long premier elements
 * sorted() : trie les elements selon l'ordre naturel
 *
 * methodes finales :
 * allMatch(Predicate) : retourne vrai si chaque element verifie le prédicat
 * anyMatch(Predicate) : retourne vrai si l'un des elements verifie le prédicat
 * findAny() : retourne un Optional qui represente un des elements du Stream
 * findFirst() : retourne un Optional qui represente le premier elements du Stream
 * noneMatch(Predicate) : vrai si aucune element ne verifie le predicat
 * forEach(Consumer) : applique la fonction sur chaque element
 * reduce(BinaryOperator) : reduit les elements en les accumulant grace à la fonction fournie et
 * retourne un Optional
 *
 * Collectors
 * java.util.stream
 * fournit des reductions
 * methodes : joining, toMap, toSet, summing, averaging, counting, groupingBy, partitioningBy
 * methodes Stream.collect(Collector)
 *
 */

public class OperationsSurStreams {

    public static void main(String[] args){
        List<Facture> factures = new ArrayList<>();
        factures.add(new Facture("2016-01-01",4567.89,"Soffiane Bds"));
        factures.add(new Facture("2016-01-02",456.89,"Soffiane Bds"));
        factures.add(new Facture("2016-01-03",45.89,"Sonia Bds"));
        factures.add(new Facture("2016-01-04",45678.9,"Soffiane Bds"));
        factures.add(new Facture("2016-01-05",4567.89,"Sonia Bds"));
        factures.add(new Facture("2016-01-06",1000,"Robert Bds"));

        factures.stream().forEach(f -> System.out.println(f));
        factures.stream().filter(f -> f.getTotal() < 500).forEach(System.out::println);
        factures.stream().map(Facture::getTotal).filter(d -> d < 5000).forEach(System.out::println);
        Optional resultat = factures.stream().map(Facture::getTotal).filter(d -> d < 5000).reduce(Double::sum);
        System.out.println("resultat : "+resultat.get());
    }

}
