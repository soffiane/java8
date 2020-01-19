package multithreadingOpenclassrooms;

/**
 * gestion de l'ordre d'execution des thread = ordonnancement
 * Le systeme alloue un temps d'execution a chaque Thread, quand ce temps est ecoulé, on passe sur un autre Thread
 *
 * un thread est traité ou non en fonction de son etat : getState()
 * Thread.start() -> etat executable
 * waiting -> Thread attend indefiniment un resultat
 * time_waiting -> Thread mis en pause par un sleep()
 * blocked -> Thread essaie d'acceder a une ressource verrouillé par un autre Thread
 * terminated -> le Thread est "mort", il a fini ses taches
 *
 * Pour palier aux problematiques liés au multithreading, plusieurs methodes
 * - groupe de Thread (ThreadGroup)
 * - priorité des Threads
 * - les démons
 *
 */
public class ThreadGroup {
    public static Integer entier = 0;
    public static void main(String[] args) {

        //On crée notre groupe en lui donnant un nom
        java.lang.ThreadGroup tg = new java.lang.ThreadGroup("Mon groupe");

        //Le constructeur de l'objet Thread peut prendre ce paramètre
        Thread t1 = new Thread(tg, new Test());
        Thread t2 = new Thread(tg, new Test());
        Thread t3 = new Thread(tg, new Test());
        Thread t4 = new Thread(tg, new Test());

        //On lance nos threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Et après une petite pause
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //On demande à notre groupe d'interrompre le traitement
        //de tous les threads du groupe, c'est ce qui lève l'exception
        //dans la classe Test
        tg.interrupt();
    }

    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + ++(TestProcessusThread.entier));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //Ici, lorsque nous invoquons l'interruption de thread
                    //la méthode sleep lève une exception
                    //nous terminons donc notre boucle à ce moment
                    break;
                }
            }
        }
    }
}
