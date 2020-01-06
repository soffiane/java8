package demoLambdaStream;

import java.util.function.*;

/**
 * Created by boudissa.s on 12/07/2016.
 */
public class LambdaRappel2 {

    public static void main(String[] args) {
        traite(5, x -> x * x);
        traite(5.5, x -> x * x);
        traite(5, 5.5, (x, y) -> x * y);

        //interface fonctionnelle qui fournit un booleen
        BooleanSupplier supplier = () -> false;
        System.out.println(supplier.getAsBoolean());
    }

    //IntUnaryOperator est une interface standard definie dans Java 8
    //permettant d'avoir un int en entree et un int en sortie
    //comme l'exemple precedent
    //Dans le package java.util.function,il y a de nombreuses
    //interfaces pour des fonctions, predicats....
    public static void traite(int x, IntUnaryOperator cal) {
        System.out.println(cal.applyAsInt(x));
    }

    //L'interface UnaryOperator<T> permet de faire pareil qu'au dessus
    //mais avec un type parametré (<T>)
    public static void traite(Double x, UnaryOperator<Double> cal) {
        System.out.println(cal.apply(x));
    }

    //chaque interface fonctionnelle implemente une methode
    //permettant de faire l'operation passée dans le lambda
    public static void traite(int x, double y, BiFunction<Integer, Double, Double> cal) {
        System.out.println(cal.apply(x, y));
    }
}


