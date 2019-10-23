package ConcurrenceEtReseau;

import java.util.concurrent.locks.StampedLock;

public class Point {
    double x,y;
    //pour proteger l'acces aux variables
    private final StampedLock sl = new StampedLock();

    void move(double dx, double dy){
        //on verrouille en ecriture
        long stamp = sl.writeLock();

        try{
            x += dx;
            y += dy;
        } finally {
            //on deverouille
            sl.unlockWrite(stamp);
        }
    }

    double distance(){
        //on demande un acces en lecture
        long stamp = sl.tryOptimisticRead();
        double cx = x;
        double cy = y;
        //si on a pas eu un acces valide
        //la plupart du temps on aura pas a passer dans le if
        if(!sl.validate(stamp)){
            //si on arrive a avoir un acces bloquant en lecture
            stamp = sl.readLock();
            //on recupere cx et cy
            try{
                cx = x;
                cy =y;
            } finally {
                //on deverouille
                sl.unlockWrite(stamp);
            }
        }
        return Math.sqrt(cx*cx + cy*cy);
    }
}
