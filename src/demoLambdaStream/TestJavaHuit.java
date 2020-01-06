package demoLambdaStream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boudissa.s on 04/07/2016.
 */
public class TestJavaHuit {

    // Encapsule la définition de la méthode implémentant le critère de sélection
    private interface Predicate<T>{
        public boolean keep(T element);
    }

    public static <T> void printNames(List<T> elements, Predicate<T> filter) {
        for (T elt : elements) {
            if (filter.keep(elt)) {
                System.out.println(elt);
            }
        }

    }


    public static void main(String[] args) {

        List<String> names = Arrays.asList("un", "deux", "trois", "quatre");

        // Critère de sélection, sous forme de classe anonyme
        //Un predicat est une fonction qui renvoie un booleen en
        //fonction de son implementation
        //exemple avec lambda
        /*
        Predicate<String> isShortName = element -> {
            // La seule ligne réellement utile !
            return element.length() <= 5;
        };
        */

        /**
         * Exemple sans les lambdas
         */
         Predicate<String> isShortName = element -> {
         // La seule ligne réellement utile !
         return element.length() <= 2;
         };

        printNames(names, isShortName);
    }

}
