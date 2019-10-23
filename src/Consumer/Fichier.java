package Consumer;

import java.util.function.Consumer;

public class Fichier {

    String nom;

    public Fichier(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //ce fichier doit pouvoir s'afficher
    void affiche(Consumer<Fichier> sortie){
        //le consummer va faire l'affichage
        sortie.accept(this);
    }
}
