package Function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Client {
    private String nom;
    private String prenom;
    private Facture facture;

    public Client(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public String getPrenom() {
        return prenom;
    }

    //L'interface fonction Function prend un parametre de type T et
    //retourne un parametre de type R
    String rendre(Function<Client,String> rendu){
        return rendu.apply(this);
    }

    //Fonction de l'interface BiFunction qui va prendre une facture et un client
    //et renvoyer un String -> BiFunction<T,U,R>
    String lierClientAFacture(BiFunction<Client,Facture,String> liaison){
        return liaison.apply(this,facture);
    }

    //Utilisation de l'interface BinaryOperator<T>
    //meme utilisation que BiFunction<T,U,R> sauf que les
    //trois parametres sont de meme types
    String afficherNomComplet(BinaryOperator<String> operator){
        return operator.apply(nom,prenom);
    }
}
