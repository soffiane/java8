package ConcurrenceEtReseau;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * package java.util.concurrent
 * classe ConcurrentHashMap, ForkJoinPool
 * package java.util.concurrent.atomic
 *
 * nouveau :
 * CompletableFuture.AsynchronousCompletionTask : marque les taches crée par les methodes async
 * CompletionStage<T> :
 * CompletableFuture<T> : Future qui peut etre terminé
 * ConcurrentHashMap:KeySetView<T> : une vue de la map en Set
 * CountedCompleter<T> : un ForkJoinTask avec une action de fin lors de la levée d'un trigger
 * CompletionException : exception levée lors de l'accomplissement d'une tache
 *
 * ConcurrentHashMap :
 * methodes : gestion de stream et lambda
 *
 * java.util.concurrent.atomic
 * classe DoubleAccumulator, LongAccumulator, LongAdder, DoubleAdder
 *
 * classe ForkJoinPool
 * commonPool()
 *
 *
 */

public class Concurrency {

    private static Map<String,Integer> compteur = Collections.synchronizedMap(new ConcurrentHashMap<String,Integer>());

    public static void main(String[] args){
        comptageIncrement("chaine");
        comptageIncrement("chaine");
        comptageIncrement("chaine");

        compteur.forEach((s, integer) -> System.out.println(" clé "+s+" valeur "+integer));
    }

    public static void comptageIncrement(String chaine){
        Integer cp = compteur.get(chaine);
        //problematique en environnement multi threadé si pas avec ConcurrentHashMap
        if(cp == null){
            compteur.put(chaine,1);
        } else {
            compteur.put(chaine,cp+1);
        }
    }
}
