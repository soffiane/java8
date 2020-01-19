package multithreading;

/**
 * Quand un objet partage un etat entre plusieurs threads, une modification ne peut etre faite
 * que par un seul Thread (atomique) sinon on corrompt l'etat de l'objet par des acces multiples.
 * ==> THREAD INTERFERENCE
 * Pour empecher cela, il faut mettre en place de L'EXCLUSION MUTUELLE entre les threads
 * On peut locker l'appel a une methode grace au mot clé synchronized
 * Quand un thread appelle une methode lockée, il prend le verrou et les autres doivent attendre
 * Mais un Thread qui prend un verrou peut ensuite appeler une autre methode snchronisée sans rendre le verrou
 * --> on parle de REENTRANT LOCKING ou RENTRANT SYNCHRONISATION
 * Toute modification de l'etat d'un objet par un thread est visible par les autres thread
 * 2 moyens : synchronized methode ou synchronized(this)
 */
public class MonitorAndLock {

    public static void main(String[] args){
        /*Unsafe unsafe = new Unsafe();
        Thread thread1 = new Thread(() -> unsafe.open(),"Thread1");
        Thread thread2 = new Thread(() -> unsafe.open(),"Thread2");
        Thread thread3 = new Thread(() -> unsafe.open(),"Thread3");
        thread1.start();
        thread2.start();
        thread3.start();*/
        /**
         * 11 Thread1 Entering the safe
         * 13 Thread3 Entering the safe
         * 12 Thread2 Entering the safe
         * 11 Thread1 Leaving the safe
         * 13 Thread3 Leaving the safe
         * 12 Thread2 Leaving the safe
         * all threads read the method at the same time
         */
        Safe safe = new Safe();
        Thread thread4 = new Thread(() -> safe.open(),"Thread4");
        Thread thread5 = new Thread(() -> safe.open(),"Thread5");
        Thread thread6 = new Thread(() -> safe.open(),"Thread6");
        thread4.start();
        thread5.start();
        thread6.start();
        /**
         * 12 Thread5 Entering the safe
         * 12 Thread5 Leaving the safe
         * 13 Thread6 Entering the safe
         * 13 Thread6 Leaving the safe
         * 11 Thread4 Entering the safe
         * 11 Thread4 Leaving the safe
         * thread prend le verrou et le relache avant thread suivant
         */
    }

    static class Safe {

        public synchronized void open() {
            System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" Entering the safe");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" Leaving the safe");
        }
    }

    static class Unsafe {

        public void open() {
            System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" Entering the safe");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId()+" "+Thread.currentThread().getName()+" Leaving the safe");
        }
    }
}
