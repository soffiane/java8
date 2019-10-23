package streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * grosse nouveauté en JAVA
 * différent des flux
 * objet qui represente un ensemble d'operations sur une collection
 * crée un flux à partir d'un flux apres les opérations
 * l'ordre des opérations est important en terme de sens et de perf
 * produit un resultat ou un effet de bord (stateless)
 * sans etat (filtre) avec etat (tri)
 * ecriture compacte et simple
 * flux parallele facile a mettre en place
 */

public class Streams {

    public static void main(String[] args){
        List<String> collection = new ArrayList<String>();
        collection.add("Soffiane");
        collection.add("Boudissa");
        collection.add("pouet");
        collection.stream().forEach(System.out::println);
        //forEach ne produit pas de nouveau stream
        collection.stream().filter(s -> s.length() > 8).forEach(System.out::println);

        //autre maniere de creer un Stream
        //map permet d'appliquer une methode sur tous les elements du Stream
        Stream.of("test","pouet","soffiane").map(String::toUpperCase).forEach(System.out::println);

        //reduce prend un BinaryOperator : 2 int et produit 1 int en sortie
        System.out.println(Stream.of("test","pouet","soffiane").map(s -> s.length()).reduce((i, i2) -> i +i2).get());

    }
}
