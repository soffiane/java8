package InterfacesFonctionnelles;

/**
 * On mixe interface fonctionnelle, les lambdas et les références de méthodes
 */
public class BoutonTest {
    //implementation classique de lambda JDK8
    public static void main(String[] args){
        declencheExecute(() -> System.out.println("Hello"));

        //on peut aussi faire : declarer une variable qui pointe vers une fonction
        InterfaceFonctionnelle i = () -> System.out.println("Pouet");
        i.execute();

        //autre implementation
        AutreImplementation autre = new AutreImplementation();
        //référence de méthode
        //interface fonctionnelle pointe sur la méthode de la classe
        i = autre::execute;
        i.execute();

        //on fournit l'adresse de la méthode (la référence)
        declencheExecute(autre::execute);
    }
    public static void declencheExecute(InterfaceFonctionnelle i){
        i.execute();
    }
}

