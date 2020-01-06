package RappelDesBases;

public class JavaTypes {

    public static void main(String... args) {

        /**
         * En java, il y a 8 types primitifs : byte, short, int, long, float, double, char and boolean
         * qui contiennent directement leur valeur au format binaire
         */
        byte b;
        short s;
        int i;
        long l;
        float f;
        double d;
        char c;
        boolean t;

        int a = 5;
        int e = 5;
        boolean b1 = a == e; //b1 est true
        System.out.println(b1);

        /**
         * Et il y a les types objets ou References Types : Classes, Interfaces, Enum, Collections etc...
         * qui stocke non pas des valeurs mais l'adresse de l'objet (la référence)
         *
         */
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        boolean b2 = i1 == i2; //il faut utiliser equals et pas ==
        System.out.println(b2);//b2 est false car i1 et i2 n'ont pas la meme reference

        /**
         * On peut utiliser les proces d'auto-boxing et auto-unboxing pour passer
         * d'un type primitifs a un type reference (Wrapper Type)
         */
        // Example of auto-boxing, here i3 is a reference type
        Integer i3 = 128; // Compiler converts this line to Integer c = Integer.valueOf(128);
        // Example of auto-unboxing, here e is a primitive type
        int i4 = i3; // Compiler converts this line to int e = c.intValue();
        System.out.println(i3+" "+i4);//on affiche 128 et 128
        System.out.println(i3 == i4);//true car on compare les valeurs

        Integer i5 = 128; // Compiler converts this line to Integer a = Integer.valueOf(128);
        Integer i6 = 128; // Compiler converts this line to Integer b = Integer.valueOf(128);
        System.out.println(i5 == i6); // Output -- false

        Integer i7 = 127; // Compiler converts this line to Integer a = Integer.valueOf(128);
        Integer i8 = 127; // Compiler converts this line to Integer b = Integer.valueOf(128);
        System.out.println(i7 == i8); // Output -- true
        /**
         * Integer.valueOF() utilise IntegerCache et si cette valeur est entre -128 et 127
         * elle renvoie la valeur du cache et ne crée pas un Integer
         * Il existe des caches pour tous les types primitifs
         * ByteCache, ShortCache, LongCache, CharacterCache for Byte, Short, Long, Character respectively.
         */
    }
}
