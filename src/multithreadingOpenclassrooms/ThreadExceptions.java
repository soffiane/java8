package multithreadingOpenclassrooms;

import java.util.Random;

/**
 * Probleme avec les Thread : ils meurent si une exception non geree est lancée
 * gestion classique avec try catch ne suffit pas (exception due a des interruptions)
 * Pour cela, on utilise l'inteface UncaughtExceptionHandler pour definir une exception specifique pour gerer ce probleme
 */
public class ThreadExceptions {

    /**
     * Notre exception pour gerer l'interruption des Thread
     */
    public static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Une exception de type : " + e.getClass().getName());
            System.out.println("Est survenue dans " + t.getName());
        }
    }

    public static class ThreadException extends Thread {

        public ThreadException(String name) {
            setName(name);
            //on definit notre propre gestionnaire d'exception grace a cette methode
            setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        }

        public void run() {
            Random rand = new Random();
            while (true) {
                System.out.println(" - " + getName());
                int cas = rand.nextInt(5);

                switch (cas) {
                    case 0:
                        int i = 10 / 0;
                        break;
                    case 1:
                        Object str = "toto";
                        double d = (double) str;
                        break;
                    default:
                        System.out.println("aucune erreur...");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Thread t = new ThreadException("Thread-" + i);
            t.start();
        }
    }

}
