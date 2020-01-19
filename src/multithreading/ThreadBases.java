package multithreading;

public class ThreadBases {

    public static void main(String[] args) {
        //Creer un Thread
        //1) instance de Thread anonyme et implementer methode run()
        Thread t = new Thread() {
            public void run() {
                System.out.println("Mon traitement");
            }
        };
        //ou en Java 8 avec un lambda
        Thread j = new Thread(() -> System.out.println("Mon autre traitement"));
        //1) puis start() pour demarrer le Thread
        t.start();
        j.start();
    }

    //2) creer une classe fille qui va heriter de Thread et override methode run
    public static class MonThread extends Thread {
        @Override
        public void run() {
            System.out.println("Mon traitement thread");
        }
    }

    public static class TestThread {
        public static void main(String[] args) {
            MonThread t = new MonThread();
            t.start();
        }
    }

    //3) Creer une classe qui implemente l'interface Runnable qui ne definit que la methode run()
    //celle ci va contenir les actions a effectuer

    //Il est préférable d'utiliser l'implémentation de Runnable car :
    //elle permet à la classe d'hériter au besoin d'une classe mère
    //elle permet une meilleure séparation des rôles
    //elle évite des erreurs car il suffit simplement d'implémenter la méthode run()
    public static class MonTraitementRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Mon traitement runnable");
        }
    }

    public static class TestThreadRunnable {

        public static void main(String[] args){
            Thread thread = new Thread(new MonTraitementRunnable());
            thread.start();
        }
    }
}
