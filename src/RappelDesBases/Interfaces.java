package RappelDesBases;

import java.io.Serializable;

/**
 * Une interface est un type de reference ne pouvant contenir que des constantes, des signatures de methodes, des methodes par defaut, des methodes privées (java9)
 * methodes static et types imbriqué. Elle ne peuvent pas etre instanciées, sauf par les classes qui implemente ces interface
 */
public class Interfaces {

    public interface GroupedInterface extends Comparable, Serializable {
        /**
         * On utilise les interfaces pour partager un contrat entre des classes qui ne sont pas liées dans une hierarchie de classes.
         * Ca definit juste un contrat entre des classes pour utiliser des services
         * On se fiche de qui va implementer cette interface
         * L'avantage pour les interfaces est aussi qu'on peut en implementer plusieurs, contrairement à l'heritage de classes
         */

        // constant declarations

        // base of natural logarithms
        double E = 2.718282;

        // method signatures
        void doSomething(int i, double x);

        int doSomethingElse(String s);

        default void printSomething(){
            System.out.println("default");
        }

        static void printSomethingElse() {
            System.out.println("default");
        }
    }

    public class GroupClass implements GroupedInterface {


        @Override
        public void doSomething(int i, double x) {

        }

        @Override
        public int doSomethingElse(String s) {
            return 0;
        }

        @Override
        public void printSomething() {

        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }

        // the GroupedInterface method signatures, with implementation --
        // for example:

        // other members, as needed -- for example, helper classes not
        // visible to clients of the interface
    }
}
