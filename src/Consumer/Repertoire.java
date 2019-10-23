package Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Repertoire {
    String nom;
    List<Fichier> fichiers = new ArrayList<Fichier>();

    public Repertoire(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    void affiche(Consumer<Repertoire> sortie){
        sortie.accept(this);
    }

    void ajouter(Fichier f){
        fichiers.add(f);
    }
}
