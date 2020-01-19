package multithreadingOpenclassrooms;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Environnement multithread, acces aux variables non thread-safe par defaut
 * Plusieurs threads peuvent lire/modifier la meme variable en meme temps : incoherence de données (dirty read)
 * pour controler l'acces des Thread, on connait le mot clé synchronized
 * pour les variables, on a le mot clé volatile : permet de dire à la JVM de rafraichir la valeur de la variable AVANT lecture ou ecriture
 * en realite ca ne fonctionne pas tres bien en fonction des JVM
 *
 * On utilise plutot le package java.util.concurrent.atomic : AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference<E>
 * Ces classes garantissent l'atomicité des actions
 */
public class MultithreadingVariableProtecting {
    //variable volatile
    public static volatile Integer entier = 0;
    //variable atomique
    public static AtomicInteger atomicInteger = new AtomicInteger();

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

    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 5; i++) {
                /**
                 * on incremente la valeur et la renvoie de facon atomique
                 * il existe encore beaucoup de méthodes intéressantes dans cet objet
                 * decrementAndGet() : décrémente et retourne la valeur
                 * addAndGet(int delta) : ajoute delta à la variable et la retourne
                 * getAndAdd(int delta) : ajoute delta à la variable mais retourne l'ancienne valeur
                 * getAndSet(int newValue) : définit la nouvelle valeur mais retourne l'ancienne
                 etc...
                 */
                MultithreadingVariableProtecting.atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " - entier volatile " + ++(entier)+" - entier atomique : "+atomicInteger);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
