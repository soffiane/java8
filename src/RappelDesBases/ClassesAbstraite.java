package RappelDesBases;

/**
 * Une classe abstraite est declarée avec le mot clé abstract et ne peut pas etre instanciée
 * On peut declarer dees methodes implementées et des methodes abstraites non implementées
 * Contrairement aux interfaces, elles peuvent contenir des attributs non static, protected
 * On utilise les classes abstraites dans les cas suivants :
 * - partager du code entre des classes tres proches
 * - les sous-classes vont partager tous les champs de la classe abstraites et requiert des methodes privée ou protected (pas possible dans interface)
 * - declarer des attributs non-final et non static. On peut donc ecrire des methodes qui peuvent acceder et modifier ses attributs.
 */
public class ClassesAbstraite {

    abstract class GraphicObject {
        int x, y;
        void moveTo(int newX, int newY) {
            x = newX;
            y = newY;
        }
        abstract void draw();
        abstract void resize();
    }
    /**
    * Les sous-classes doivent surcharger et implementer les methodes abstraites
     */
    class Circle extends GraphicObject {
        @Override
        void draw() {

        }

        @Override
        void resize() {

        }
    }
    class Rectangle extends GraphicObject {
        @Override
        void draw() {

        }

        @Override
        void resize() {

        }
    }

    /**
     * Une classe abstraite peut implementer des interfaces
     */
    abstract class X implements Runnable {
        // implements all but one method of Runnable

        @Override
        public void run() {

        }
    }

    class XX extends X {
        @Override
        public void run() {

        }
        // implements the remaining method in Runnable
    }
}
