package multithreadingOpenclassrooms;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TPConversation {

    public static class Journaliste extends Thread{
        private String nom;
        private Lock verrou;
        //chaque Thread a sa propre condition
        private Condition question;
        private Condition reponse;
        private Scanner sc = new Scanner(System.in);

        public Journaliste(String pNom, Lock pVerrou, Condition pQuestion, Condition pReponse){
            nom = pNom;
            verrou = pVerrou;
            question = pQuestion;
            reponse = pReponse;
        }

        public void question(){
            verrou.lock();
            try{
                System.out.println(nom + ", posez votre question : ");
                sc.nextLine();
                //On libère le thread de réponse
                reponse.signal();
                //On bloque ce thread
                question.await();
            }catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }finally{
                //On n’oublie pas de libérer le verrou !
                verrou.unlock();
            }
        }

        @Override
        public void run(){
            while(true){
                question();
            }
        }
    }

    public static class Personne extends Thread {

        private String nom;
        private Lock verrou;
        private Condition question;
        private Condition reponse;
        private Scanner sc = new Scanner(System.in);

        public Personne(String pNom, Lock pVerrou, Condition pQuestion, Condition pReponse){
            nom = pNom;
            verrou = pVerrou;
            question = pQuestion;
            reponse = pReponse;
        }

        public void reponse(){
            verrou.lock();
            try{
                System.out.println(nom + ", votre réponse ?");
                sc.nextLine();
                //On libere le Thread de question
                question.signal();
                //On bloque la réponse
                reponse.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }finally{
                //et on libère le verrou !
                verrou.unlock();
            }
        }

        public void run(){
            while(true){
                reponse();
            }
        }
    }

    public static void main(String[] main){
        //Verrou commun entre les Threads
        Lock lock = new ReentrantLock();
        //verrou conditionnel
        Condition question = lock.newCondition();
        //verrou conditionnel
        Condition reponse = lock.newCondition();
        //on crée les deux Thread - Journaliste et Personne extends Thread
        Journaliste j = new Journaliste("PPDA", lock, question, reponse);
        Personne p = new Personne("cysboy", lock, question, reponse);

        j.start();
        p.start();
    }
}
