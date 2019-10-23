package referencesDeMethodes;

import java.util.Arrays;

//En java, les adresses des variables et des methodes ne sont pas manipulables
//(contrairement aux pointeurs C++)
//Avant java8, pour declencher une methode, il faut instancier un objet
//Avec java8, on peut appeler une refence à la methode, statique ou d'instance
public class ExempleReferenceDeMethode {

    public static void main(String[] args){
        Personne[] tableau = new Personne[2];
        tableau[0] = new Personne("Soffiane",33);
        tableau[1] = new Personne("Mounir",30);

        System.out.println(tableau[0]);
        System.out.println(tableau[1]);

        //Reference de methode vers la methode compare de la classe Personne
        //ici la methode doit etre static car on est dans un contexte static (main)
        Arrays.sort(tableau,Personne::compare);

        System.out.println(tableau[0]);
        System.out.println(tableau[1]);
    }
}
