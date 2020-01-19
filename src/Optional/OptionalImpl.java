package Optional;

import java.util.Optional;

/**
 * Optional<T> encapsule un type T
 *  En java, seules les references peuvent etre nulles, pas les types primitifs
 *  Comment exprimer l'absence de valeur d'un primitif ? en general on met 0 ou 999 etc...
 *  methodes :
 *  retourne une valeur avec get()
 *  teste la presence avec ifPresent()
 *  construit avec of(T t), ofNullable(T t)
 *  recupere la valeur avec orElse(), orElseGet(), orElseThrow()...
 *  construit un Optional vide : empty()
 *
 *  Optional est un nullable object (design pattern)
 */
public class OptionalImpl {

    public static void main(String[] args){

        /*int données = trouver("hello");

        if(données == -1){
            //traitement defaut (exception par exemple)
        } else {
            //situation normale
        }*/
        Optional<Integer> données = trouver("hello");
        if(données.isPresent()){
            System.out.println(données.get());
        } else {
            System.out.println("rien trouvé");
        }
    }

    /*private static int trouver(String chaine) {
        if(chaine == "bonjour") {
            return 1;
        }
        else {
            //rien a retourner ?
            return -1;
        }
    }*/

    private static Optional<Integer> trouver(String chaine) {
        if("bonjour".equals(chaine)) {
            return Optional.of(1);
        }
        else {
            //rien a retourner ?
            return Optional.empty();
        }
    }
}
