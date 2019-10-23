package Collections;

import java.util.function.IntSupplier;

/**
 * manipuler des données non signées
 * java toujours des types signés
 * dans Integer et Long sont ajoutés des méthodes pour manipuler des données non signées
 * pas de bytes de signe pris en compte
 * methodes :
 * compareUnsigned, divideUnsigned, parseUnsignedInt, remainderUnsigned,toUnsignedLong, toUnsignedString
 */

public class UnsignedArithmetic {

    public static void main(String[] args){
        //qui vaut -2171090000
        Integer value = Integer.MIN_VALUE;
        for(int i =0 ;i<100;i++){
            //le signe est pris en compte
            System.out.println(value.toString());
            //on ne prend pas en compte le signe
            System.out.println(Integer.toUnsignedString(value));
            value++;
        }
    }
}
