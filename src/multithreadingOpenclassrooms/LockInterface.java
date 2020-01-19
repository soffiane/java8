package multithreadingOpenclassrooms;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Depuis java 5 : Deux objets pour poser et retirer des verrou : Lock et ReentrantLock
 * deux methode : lock() pose un verrou et unlock() retire un verrou
 * ! Un Thread peut se mettre en sommeil pendant l'execution d'un traitement !!!!
 */
public class LockInterface {

    public class Increment {
        private int entier = 0;
        //Nous créons notre objet qui va nous fournir un verrou
        private Lock verrou = new ReentrantLock();
        public void incremente(){
            //Nous verrouillons le code qui suit cette instruction
            verrou.lock();
            //Nous utilisons un bloc try surtout
            //pour pouvoir avoir un bloc finally
            try{
                //tout ce code est maintenant considéré comme atomique !
                entier++;
            }finally{
                //ainsi, même s'il y a eu une interruption sur notre thread
                //le verrou sera relâché, dans le cas contraire
                //tous les autres threads ne pourraient plus travailler !
                verrou.unlock();
            }
        }

        /**
         * tryLock() pour gerer les verrous
         * si le thread obient le verrou (tryLock() renvoie true, alors execution normale
         * sinon le thread est mis en sommeil jusqu'a ce que soit :
         * - le verrou est enfin obtenu ;
         * - le thread est interrompu ;
         * - le délai d'attente est dépassé.
         * tryLock est pas mal mais quand le thread obtient le verrou, on ne peut plus le stopper
         */
        public void incrementeTryLock(){
            //S'il est possible de poser un verrou
            try {
                //Cette instruction peut lever une InterruptedException
                if(verrou.tryLock(1000L, TimeUnit.MILLISECONDS)){
                    try{
                        entier++;
                    }finally{
                        verrou.unlock();
                    }
                }
                else{
                    //Dans le cas contraire, c'est qu'il y a risque d'interblocage
                    //donc on ne prend pas le risque de traiter les données
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized Integer get(){
            return entier;
        }
    }
}
