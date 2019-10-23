package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * BaseStream<T> : interface generique de toutes les interfaces Stream
 *      sequences d'elements qui supportent des operations aggrégées
 *      ex : widget.stream().fliter(...).mapToInt(...).sum();
 *      méthodes :
 *      fermeture : close()
 *      parallelisme : parallel(), isParallel()
 *      en séquence : sequential()
 *      itération : iterator(), spliterator()
 *      libérer la contrainte d'ordre : unordered()
 *
 * Stream<T>
 *     sous interface de BaseStream<T> dedié aux objets
 *     obtenu a partir d'une source consommé uniquement si necessaire
 *     permet de construire un pipeline
 *     les opérations attendent des interfaces fonctionnelles non nulle, sans utiliser la source et sans etat
 *     operé une seule fois en parallele ou de maniere sequentielle
 *
 * interface spécialisées pour les types primirifs
 * DoubleStream, LongStream, IntStream
 * comme Double/Int/Long Supplier
 * methodes:
 * map(DoubleUnaryOperator)
 * mapToInt, mapToLong, mapToDOuble, mapToObj
 *
 * Stream.Builder : construire un stream au fur et a mesure et de le modifier avant les operation
 * existe aussi pour Double, Long, Int
 * DoubleBuilder.Builder b = DoubleStream.builder();
 * b.accept(1.1)
 * b.build().forEach(.....)
 *
 *
 */

public class InterfacesStream {

    public static void main (String[] args){
        List<String> list = new ArrayList<>();
        list.add("pouet");
        list.add("soffiane");

        list.stream().forEach(System.out::println);

        Stream.of("toto","titi").forEach(System.out::println);

        Stream.Builder b = Stream.builder();
        b.accept("tutu");
        b.build().forEach(System.out::println);

        DoubleStream.Builder c = DoubleStream.builder();
        c.accept(1.5);
        c.build().forEach(System.out::println);
    }
}
