package demoLambdaStream;

/**
 * Created by boudissa.s on 12/07/2016.
 */
public class ReturnLambda {

    interface Calculateur{
        public int calcul(int n);
    }

    public static void main(String[] args){
        for(int i=0;i<5;i++) {
            traite(5, fabriqueStatique());
        }
    }

    public static void traite(int x, Calculateur cal){
        System.out.println(cal.calcul(x));
    }

    //on fabrique le calculateur par cette methode statique
    //expression lambda dans un return
    public static Calculateur fabriqueStatique(){
        double a = Math.random();
        System.out.println(a);
        if(a<0.5){
            return x -> x*x;
        } else {
            return x -> 2*x;
        }
    }
}
