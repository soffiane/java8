package lambda;

/**
 * Les lambdas ne sont utilisables que pour les interfaces fonctionnelles
 * Interfaces avec une seule methode
 *
 */
@FunctionalInterface
public interface MonInterface {
    //void affiche(String s);

    void affiche(String string, String string2);
}
