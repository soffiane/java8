package demoLambdaStream;

/**
 * Created by boudissa.s on 12/07/2016.
 */
public class CompositionLambda {
    interface Calculateur{
        public int calcul(int n);
    }
    //une fabrique de Calculateur
    interface FabriqueCalculateur{
        Calculateur fabrique();
    }

    public static void main(String[] args){
        //pas de parametre en entree et effectue le calcul
        //on peut creer plusieurs calculateur
        FabriqueCalculateur fabriqueCarre = () -> (x -> x*x);
        FabriqueCalculateur fabriqueDouble = () -> (x -> 2*x);
        traite(5,fabriqueCarre.fabrique());
        traite(5,fabriqueDouble.fabrique());
    }

    public static void traite(int x,Calculateur cal){
        System.out.println(cal.calcul(x));
    }
}
