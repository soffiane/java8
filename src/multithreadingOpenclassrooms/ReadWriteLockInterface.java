package multithreadingOpenclassrooms;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Quand on pose un verrou, un seul thread peut utiliser le code protégé
 * Parfois, on a besoin que plusieurs thread puissent lire les données sans verrou
 * mais de bloquer ces threads quand il y a une opération d'ecriture
 * Interface ReadWriteLock contient deux methodes pour cela : readLock() et writeLock()
 */
public class ReadWriteLockInterface {

    public static class Dictionnaire {

        private Map<Integer, String> dico = new TreeMap<>();
        private String[] listMot = {"abc", "bcd", "cde", "def", "efg"};
        private Random rand = new Random();
        private static AtomicInteger indiceCollection = new AtomicInteger(0);

        ReadWriteLock rwl = new ReentrantReadWriteLock();
        //Le verrou en écriture
        Lock writeLock = rwl.writeLock();
        //Le verrou en lecture
        Lock readLock = rwl.readLock();

        public void ecrire(){
            //On pose le verrou en écriture, ce qui va bloquer tous les autres threads
            //en écriture mais aussi en lecture
            writeLock.lock();
            try{
                //On fait notre traitement
                String mot = listMot[rand.nextInt(5)];
                int indice = indiceCollection.getAndIncrement();
                String motAjouter = mot + indice;
                dico.put(indice, motAjouter);
                System.err.println(Thread.currentThread().getName() + " : indice = "
                        + indice + " ; mot = " + motAjouter
                );
            }finally{
                //On n’oublie surtout pas de libérer le verrou !
                writeLock.unlock();
            }
        }

        public void lire(){
            //On pose le verrou en lecture, ce qui n'a pas d'effet pour les threads
            //qui ne font que lire mais qui va permettre
            //aux threads en écriture de bloquer l'accès lorsque ceux-ci invoque un verrou
            readLock.lock();
            try{
                //On fait note traitement
                if(dico.keySet().isEmpty()){

                    int length = dico.keySet().size();

                    int indiceMot = rand.nextInt(length);
                    System.out.println(Thread.currentThread().getName() + " : indice = "
                            + indiceMot + " ; mot = " + dico.get(indiceMot)
                    );
                }
            }finally{
                //On n’oublie surtout pas de libérer le verrou !
                readLock.unlock();
            }
        }
    }

    public static class ThreadWriter extends Thread {
        private Dictionnaire dico;
        public ThreadWriter(String nom, Dictionnaire pDico){
            setName(nom);
            dico = pDico;
        }

        public void run(){
            while(true){
                dico.ecrire();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadReader extends Thread {
        private Dictionnaire dico;
        public ThreadReader(String nom, Dictionnaire pDico){
            setName(nom);
            dico = pDico;
        }

        public void run(){
            while(true){
                dico.lire();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Dictionnaire dico = new Dictionnaire();

        ThreadWriter tw1 = new ThreadWriter("Writer 1", dico);
        tw1.start();
        ThreadWriter tw2 = new ThreadWriter("Writer 2", dico);
        tw2.start();

        for(int i = 0; i < 6; i++){
            ThreadReader tr = new ThreadReader("Reader "+ i , dico);
            tr.start();
        }
    }
}
