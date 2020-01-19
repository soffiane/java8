package multithreading;

public class Cafe {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.getEspresso();
    }

    static class CoffeeMachine {

        public void getEspresso() {
            grind();
            workupSteam();
            blend();
        }

        private void blend() {
            System.out.println("Delivering coffee");
        }

        private void workupSteam() {
            System.out.println("Workup steam !");
        }

        private void grind() {
            System.out.println("Grinding beans!");
        }
    }
}
