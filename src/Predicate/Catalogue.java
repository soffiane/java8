package Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Catalogue {
    List<Article> articles = new ArrayList<>();

    void ajoute(Article article){
        articles.add(article);
    }

    List<Article> rechercheArticlePrix(Predicate<Article> f){
        List<Article> rechValue = new ArrayList<>();
        //on retourne les articles qui correspondent au predicat f
        for(Article a : articles){
            //ici le predicat n'est pas connu mais
            //on attend un predicate que l'on va definir dans
            //l'implementation : on a un code generique
            if(f.test(a)){
                rechValue.add(a);
            }
        }
        return rechValue;
    }
}
