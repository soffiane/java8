package String;

import java.lang.reflect.Field;

/*
Fonctionnement de la classe String : String est un Wrapper de char[]


    -String object itself is rather cheap. It's the text it points to that consumes most of the memory
    -String is just a thin wrapper around char[] to preserve immutability
    -new String("abc") isn't really that expensive as the internal text representation is reused. But still avoid such construct.
    -When String is concatenated from constant values known at compile time, concatenation is done by the compiler, not by the JVM
    -substring() is tricky, but most importantly, it is very cheap, both in terms of used memory and run time (constant in both cases)

    Memory leak traps in the Java Standard API

A big one is that getting substrings of Java strings refers to the original string.
Example: you read in a 3000 character record and get a substring of 12 characters, returning that to the caller (within the same JVM).
Even though you don't directly have a reference to the original string, that 12 character string is still using 3000 characters in memory.
For systems that receive and then parse lots of messages, this can be a real problem.
You have a couple of ways to avoid this:
String sub = new String(str.substring(6,12));
or
String sub = str.substring(6,12).intern();
The first is more clearcut. The second has other implications because you're using PermGen space. Overused you could run out unless you give your VM enough.
Remember this is only relevant if you're taking small substrings and then throwing away the original string and you're doing this a lot.

 */
public class StringMemoryInternals {

    public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
        String one = "abc";
        String two = "abc";
        //same hashcode generé par notre methode
        System.out.println("one.value : "+showInternalCharArrayHashCode(one));
        System.out.println("two.value : "+showInternalCharArrayHashCode(two));
        //default hashcode de String - meme hash code ici
        System.out.println("one : "+System.identityHashCode(one));
        System.out.println("two : "+System.identityHashCode(two));
        //equals renvoie true car les sequences de caracteres sont les memes
        System.out.println("one equals two : "+one.equals(two));

        //maintenant on teste avec un new String
        String three = "abc";
        //String est immuable donc quand on cree un nouveau a partir d'un String existant,
        String four = new String("abc");
        //same hashcode generé par notre methode - donc meme tableau de char[]
        System.out.println("three.value : "+showInternalCharArrayHashCode(three));
        System.out.println("four.value : "+showInternalCharArrayHashCode(four));
        //ici on a le hashCode different
        System.out.println("three : "+System.identityHashCode(three));
        System.out.println("four : "+System.identityHashCode(four));
        //equals renvoie true car les sequences de caracteres sont les memes
        System.out.println("three equals four : "+three.equals(four));

        String five = "abc";
        String six = "?abc".substring(1);  //also six = "abc"
        //hashcode different
        System.out.println("five.value : "+showInternalCharArrayHashCode(five));
        System.out.println("six.value : "+showInternalCharArrayHashCode(six));
        //ici on a le hashCode different
        System.out.println("five : "+System.identityHashCode(five));
        System.out.println("six : "+System.identityHashCode(six));
        //equals renvoie true car les sequences de caracteres sont les memes
        System.out.println("five equals six : "+five.equals(six));

        String seven = "abc";
        String eight = "?abc".substring(1);  //also six = "abc"
        eight = eight.intern();
        //hashcode egal aavec intern()
        System.out.println("seven.value : "+showInternalCharArrayHashCode(seven));
        System.out.println("eight.value : "+showInternalCharArrayHashCode(eight));
        //ici on a le hashCode egal avec intern()
        System.out.println("seven : "+System.identityHashCode(seven));
        System.out.println("eight : "+System.identityHashCode(eight));
        //equals renvoie true car les sequences de caracteres sont les memes
        System.out.println("seven equals eight : "+seven.equals(eight));
    }

    /*
    Cette methode utilise la Reflection pour acceder a un champ de la classe String et retourne son hashcode
     */
    private static int showInternalCharArrayHashCode(String s) throws NoSuchFieldException, IllegalAccessException {
        final Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        return value.get(s).hashCode();
    }
}
