package lambda;

/**
 * @author soffiane
 *
 */

public class Lambdas {

    public static void affiche(MonInterface i) {
        i.affiche("Hello World","Pouet");

    }

    public static void main(String[] args) {
        /* expression lambda : c'est une vraie fonction globale
         on prend une liste de parametres, type optionel
         puis on met ->, marqueur de la lambda expression
         {} si il y a plus d'une expression sinon rien (fonction)
         Un lambda est defini comme une FONCTION ANONYME
         (a,b) -> {a+b}; */

        /*
          Utilite des lambdas : expressions courtes ou qui retourne un Predicat (fct
          qui retourne vrai ou faux) ou une fonction qui accept une donn�e
         */
        /*
          Une seul expression dans la fonction
         */
        //affiche(x -> System.out.println(x));

        /*
          PLusieurs expressions (Attention a la lisibilite)
         */
//		affiche(x -> {
//			System.out.println(x);
//			System.out.println("pouet");
//		});

        /*
          Plusieurs parametres
         */
        affiche((String x, String y) -> {
            System.out.println(x);
            System.out.println(y);
        });

    }

}
