package Predicate;

/**
 * Predicate<T>
 * Un predicat represente une fonction qui prend un objet T et
 * renvoie un boolean --> on parle de condition
 * methode fonctionnelle : boolean b = test(T t)
 * Autres interfaces :
 * BiPredicate<T,U> : boolean b = test(T t, U u)
 * DoublePredicate : idem predicate mais T est un Double
 * IntPredicate : idem mais T est un int
 * LongPredicate : idem mais T est un long
 *
 * autre méthode implementée (par defaut) :
 * and (Predicate p) : compose avec un AND court-circuit
 * negate() : le NOT logique
 * or(Predicate p) : OU logique
 * isEqual(Object p) : test egalité
 *
 */

public class Article {

    String nom;
    int prix;

    public Article(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
