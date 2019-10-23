package ConcurrenceEtReseau;

/**
 * pour manipuler des stamp (comme timestamp)
 * un verrou en 3 modes
 * ecriture, lecture et lecture optimiste
 * pour des composants thread safe
 */

public class StampedLockTest {
    public static void main(String[] args){
        Point point = new Point();
        point.move(5,5);
        System.out.println(point.distance());
    }
}
