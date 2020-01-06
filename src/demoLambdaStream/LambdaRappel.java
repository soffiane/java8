package demoLambdaStream;

/**
 * Created by boudissa.s on 08/07/2016.
 */
public class LambdaRappel {

    //Cette interface n'implemente qu'une seule methode, c'est donc
    //une interface fonctionnelle
    @FunctionalInterface
    interface Calculateur{
        public int calcul(int n);
    }

    public static void main(String[] args){
        //on peut passer un lambda en parametre d'appel d'une fonction
        //on transmet la valeur et le lambda a la fonction
        traite(5, x-> x*x);
        traite(5, x-> 2*x*x+3*x+5);

        Calculateur polynome = x -> x*x - 2*x + x;
        traite(5,polynome);
    }

    public static void traite(int n,Calculateur cal){
        System.out.println(cal.calcul(n));
    }
}
