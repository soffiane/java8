package demoLambdaStream;

/**
 * Created by boudissa.s on 04/07/2016.
 * Une interface fonctionnelle est une interface qui ne contient qu'une seule methode.
 * Comme l'interface Runnable (run) ou Comparator (compare)
 */
@FunctionalInterface
public interface Operator {
    int additionner(int x, int y);
}
