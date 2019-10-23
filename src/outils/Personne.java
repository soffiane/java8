package outils;

public class Personne {
    String nom;
    String prenom;
    private static int compteur = 0;

    //methode native : fonction ecrite en C
    native void affiche(int i);

    public Personne(){
        affiche(compteur++);
    }

    //javac -h cible\nomclasse.java en ligne de commande
    //genere dans le repertoire cible un fichier.h qui
    //contient le code en C
}
