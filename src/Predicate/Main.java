package Predicate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalogue cat = new Catalogue();
        cat.ajoute(new Article("Bouteille", 5));
        cat.ajoute(new Article("Sandwich", 10));
        cat.ajoute(new Article("Cahier", 2));

        //on cherche les articles qui coutent moins de 6
        cat.rechercheArticlePrix(a -> a.getPrix() < 6).forEach(i -> System.out.println("Article : "+i.getNom()));
    }
}
