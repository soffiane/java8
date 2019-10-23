package Supplier;

import java.util.function.IntSupplier;

public class Main {
    public static void main(String[] args){
        /*for(int i=0; i<5; i++){
            System.out.println("Suivant "+Fibonacci.getAsInt());
        }*/
        //parcours(Fibonacci::getAsInt);
        parcours(Entier::get);
    }

    //l'utilisation du supplier permet d'avoir un algo generique
    public static void parcours(IntSupplier f){
        for(int i=0; i<5; i++){
            System.out.println("Suivant "+f.getAsInt());
        }
    }
}
