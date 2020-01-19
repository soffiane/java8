package multithreadingOpenclassrooms;

/**
 * synchronized permet de poser un verrou sur une methode ou bout de code
 * s'assure qu'un seul Thread à la fois passe dans le verrou
 */
public class MultithreadSynchronisation {

    public static class TestProcessusThread {

        //public static Increment entier = new Increment();
        //public static IncrementSynchronizedMethod entier = new IncrementSynchronizedMethod();
        public static IncrementSynchronizedThis entier = new IncrementSynchronizedThis();

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
    }

    /**
     * classe increment non synchronisée
     * output :
     * Thread-0 - 1
     * Thread-1 - 2
     * Thread-3 - 3
     * Thread-2 - 4
     * Thread-1 - 6
     * Thread-3 - 6
     * Thread-0 - 7
     * ...
     * les entiers ne se suivent pas
     */
    public static class Increment {
        private int entier = 0;
        public void incremente(){
            entier++;
        }
        public Integer get(){
            return entier;
        }
    }

    /**
     * Increment synchronisé sur la methode
     * output :
     * Thread-0 - 1
     * Thread-2 - 2
     * Thread-3 - 3
     * Thread-1 - 4
     * Thread-0 - 5
     * Thread-1 - 6
     * Thread-2 - 8
     * Thread-3 - 7
     * Thread-0 - 9
     * Thread-1 - 10
     * Thread-3 - 12
     * Thread-2 - 11
     * Thread-0 - 13
     * ...
     * un peu mieux
     */
    public static class IncrementSynchronizedMethod {
        private int entier = 0;
        public synchronized void incremente(){
            entier++;
        }
        public synchronized Integer get(){
            return entier;
        }
    }

    /**
     * le verrou est placé sur l'objet à proteger
     * output :
     * Thread-1 - 1
     * Thread-0 - 3
     * Thread-3 - 4
     * Thread-2 - 2
     * Thread-2 - 6
     * Thread-0 - 7
     * Thread-3 - 7
     * Thread-1 - 8
     * Thread-2 - 9
     * Thread-3 - 11
     * Thread-0 - 11
     * Thread-1 - 12
     * ...
     */
    public static class IncrementSynchronizedThis {
        private int entier = 0;
        public void incremente(){
            synchronized (this) {
                entier++;
            }
        }
        public synchronized Integer get(){
            synchronized (this) {
                return entier;
            }
        }
    }
    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                TestProcessusThread.entier.incremente();
                System.out.println(Thread.currentThread().getName() + " - " + TestProcessusThread.entier.get());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        }
    }
}
