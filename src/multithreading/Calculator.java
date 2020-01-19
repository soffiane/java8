package multithreading;

/**
 * Heap vs Stack
 * <p>
 * Heap est l'espace memoire partagé entre les threads ou vivent les objets --> garbage collector pour virer les objets non utilisé
 * Stack est l'espace memoire privé pour chaque thread --> libéré à la fin du thread
 */
public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Thread user1 = new Thread(() -> calculator.add(1, 2));
        Thread user2 = new Thread(() -> calculator.add(3, 4));

        user1.start();
        user2.start();
    }

    private void add(int a, int b) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + (a + b));
    }
}
