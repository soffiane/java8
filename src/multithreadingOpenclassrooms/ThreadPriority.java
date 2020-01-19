package multithreadingOpenclassrooms;

/**
 *  Concernant les priorités, il y a 10 niveaux allant de Thread.MIN PRIORITY (1) à Thread.MAX_PRIORITY(10) avec Thread.NORM_PRIORITY(5)
 *  methode setPriority(int level) pour mettre la priorité
 *  Le gestionnaire de Thread privilégiera le Thread à la plus forte priorité
 *  Cependant il vaut me ne pas y toucher car ca change en fonction de l'OS sur lequel il est executé
 *  De plus, si deux thread de prio != doivent acceder a une ressource, le Thread a plus faible priorité
 *  risque de ne jamais acceder à la ressource : on parle de FAMINE
 *
 *  On peut definir la priorité avec la methode setDaemon(true)
 *  Demon = Thread qui sert d'autre Threads - tourne en permanence et ne se ferme pas à la fermeture des Thread
 *  si un programme lance 2 threads et 2 démons, le programme se terminera lorsque les deux threads seront terminés même si les démons tournent toujours.
 */
public class ThreadPriority {
    public static Integer entier = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }

    /**
     * Le resultat de l'affichage semble incoherent, pourquoi ?
     * l'operation ++(TestProcessusThread.entier) est en fait 3 operations niveau processeur :
     * - mettre la variable dans une case mémoire
     * - ajouter la valeur 1 à cette case mémoire
     * - réaffecter le résultat à la variable d'origine.
     * Dans un environnement multithread, le systeme va mettre en pause un Thread pendant n'importe laquelle
     * de ces operations car l'operation n'est pas ATOMIQUE
     *
     */
    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + ++(ThreadPriority.entier));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
