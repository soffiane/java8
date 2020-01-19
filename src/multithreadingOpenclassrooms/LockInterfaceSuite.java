package multithreadingOpenclassrooms;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock() est bien mais le thread qui obtient le verrou ne peut plus etre stoppé
 * il y a une methode pour pallier a ce probleme : lockInterruptibly()
 * cette methode permet de stopper un thread ayant obtenu un verrou et liberer les ressources
 *
 * Autre chose : on peut utiliser des verrous avec des conditions
 */
public class LockInterfaceSuite {

    /**
     * ici on teste un code avec verrou sans condition sur le code sensible
     * CompteEnBanque ou on peut faire des depots/retraits mais pas de retrait si pas assez de solde
     */
    public static class CompteEnBanque {
        //solde initial du compte
        private AtomicLong solde = new AtomicLong(1_000L);
        //autorisation de decouvert
        private final long decouvert = -130L;

        //le verrou partagé par les Thread
        private Lock verrou = new ReentrantLock();
        //interface Condition permettant de créer un verrou avec condition
        //ici la condition est pour un retrait d'avoir un solde positif
        private Condition condition = verrou.newCondition();
        //cette variable va nous servir à savoir
        //le nombre de tentatives de retrait successives
        private AtomicLong tentativeDeRetrait = new AtomicLong(0);

        /**
         * C'est sur cette méthode que nous allons devoir travailler
         * dans nos threads et vérifier le solde avant de retirer de l'argent
         * Ces methodes depots et retrait ne gerent pas de condition
         * ce qui fait qu'on ne respecte pas la contrainte de solde positif pour retrait
         */
        /*public void retrait(long montant){
            verrou.lock();
            String threadName = Thread.currentThread().getName();
            try{
                long avant = solde.get();
                solde.set((avant - montant));
                solde();
            }finally{
                verrou.unlock();
            }

        }

        //Puisqu’on utilise un objet AtomicLong
        //Inutile de synchroniser. ^^
        public void depot(long montant){
            synchronized(this){
                long result = solde.addAndGet(montant);
                solde();
            }
        }*/

        /**
         * Cette version des methodes respectent la condition sur le montant du compte pour les retraits
         */
        public void retrait(long montant){
            verrou.lock();
            String threadName = Thread.currentThread().getName();
            try{
                //On met en attente les threads tant que la condition n'est pas remplie
                //Le thread étant mis en attente si cette condition est remplie
                //on aurait pu utiliser un simple "if" mais on ne sait jamais
                while((solde.get() - montant) < decouvert){

                    //dans ce cas, le thread qui tente de retirer ce montant
                    //mettra notre solde en deçà du découvert autorisé
                    System.err.println(threadName + " tente de retirer " + montant);

                    //on stock le cumul des tentatives de retrait car
                    //lorsque le verrou sera levé, tous les threads en attente
                    //seront autorisés à faire leur retrait, il faut donc contrôler le cumul
                    //de toutes les tentatives de retrait
                    tentativeDeRetrait.addAndGet(montant);
                    System.err.println("Argent qui va etre retiré " + tentativeDeRetrait.get());
                    //on pose un verrou via la condition, cette instruction rend le thread inéligible
                    //à travailler. Peut prendre un delai en parametre
                    condition.await();

                }

                //Si nous sommes ici, c'est que le montant du retrait
                //est autorisé ou que la condition a libéré le verrou sur le thread
                solde.set((solde.get() - montant));
                solde();
            }
            //L'ajout d'un verrou via une condition peut lever ce genre d'exception
            catch (Exception e) {e.printStackTrace();}
            finally{
                //On oublie pas le libéré le verrou général
                verrou.unlock();
            }
        }

        //Puisqu’on utilise un objet AtomicLong
        //Inutile de synchroniser, mais on utilisera tout de même un verrou. ^^
        //C'est dans cette méthode que la condition sera libérée
        public void depot(long montant){

            //On utilise le même verrou que celui qui a engendré la condition
            //sans cela, la condition créée à partir de ce verrou
            //lèvera une exception si nous tentons de la libérer
            verrou.lock();

            try{

                //Nous faisons notre traitement
                long result = solde.addAndGet(montant);
                solde();

                //Nous vérifions si le solde après les tentatives de retraits
                //sera toujours au dessus de l'autorisation de découvert
                long soldeApresRetrait = getSolde() - tentativeDeRetrait.get();

                //Si tel est le cas, libération du verrou
                if(soldeApresRetrait > decouvert){
                    //on réinitialise notre variable de contrôle à 0
                    tentativeDeRetrait.set(0);
                    //on libère le verrou posé par la condition
                    //cette instruction va libérer tous les threads mis en attente
                    condition.signalAll();
                    System.err.print("\n Montant après retrait (" + soldeApresRetrait + ")");
                    System.err.println(soldeApresRetrait < 0 ? " < découvert" : "");
                }

            }finally{
                //on n’oublie pas de libérer le verrou général
                verrou.unlock();
            }
        }

        public synchronized void solde(){
            System.out.println("Solde actuel, dans " + Thread.currentThread().getName()
                    + " : " +  solde.longValue());
        }

        public synchronized long getSolde(){
            return solde.longValue();
        }

        public long getDecouvert(){
            return decouvert;
        }
    }

    /**
     * Le thread qui va faire les depots sur le compte en banque
     */
    public static class ThreadDepot extends Thread{

        private CompteEnBanque ceb;
        private Random rand = new Random();

        public ThreadDepot(CompteEnBanque c){
            ceb = c;
            this.setName("Dépôt");
        }

        public void run() {
            while(true){

                int nb = rand.nextInt(100);
                long montant = Integer.valueOf(nb).longValue();
                ceb.depot(montant);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        }
    }

    /**
     * Le Thread qui va faire les retraits sur le compte en banque
     */
    public static class ThreadRetrait extends Thread {

        private CompteEnBanque ceb;
        private Random rand = new Random();
        private static int nbThread = 1;

        public ThreadRetrait(CompteEnBanque c){
            ceb = c;
            this.setName("Retrait" + nbThread++);
        }

        public void run() {
            while(true){
                int nb = rand.nextInt(300);
                long montant = Integer.valueOf(nb).longValue();
                ceb.retrait(montant);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            }
        }
    }

    /**
     * On va simuler des operations de depots retraits, voir si elles sont bien synchronisées
     * Le solde initial du compte est de 1000
     * On fait deux operations de retrait entre 0 et 300 chacun
     * puis un ajout entre 0 et 100
     *
     * Lors de l'execution on voit qu'on peut faire des retraits à montants negatifs :PAS BIEN !
     * On modifie les methodes depot et retrait de CompteEnBanque pour y ajouter une Condition
     */
    public static void main(String[] args) {
        CompteEnBanque ceb = new CompteEnBanque();

        //On crée deux threads de retrait
        Thread t1 = new ThreadRetrait(ceb);
        t1.start();

        Thread t2 = new ThreadRetrait(ceb);
        t2.start();

        //et un thread de dépôt
        Thread t3 = new ThreadDepot(ceb);
        t3.start();
    }

}
