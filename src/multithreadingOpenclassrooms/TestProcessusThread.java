package multithreadingOpenclassrooms;

/**
 * multitache preemptif : interrompt les processus sans demander
 * non preemptif (cooperatif) : demander autorisation au processus avant interruption
 *
 * Multithreading mal codé peut bloquer le systeme si on ne demande pas interruption d'une tache qui pose probleme
 * Plusieurs Threads mais un seul processus (javaw.exe) dans le gestionnaire de taches Windows
 * 1 programme Java lance 3 Threads : principal (main), taches de fond et composants graphiques
 *
 * Chaque thread correspond a une pile d'invocations de methodes rattaché à un processus
 */
public class TestProcessusThread {
    public static Integer entier = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());
        Thread t3 = new Thread(new Test());
        Thread t4 = new Thread(new Test());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
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
                System.out.println(Thread.currentThread().getName() + " - " + ++(TestProcessusThread.entier));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


