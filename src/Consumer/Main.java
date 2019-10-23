package Consumer;

import Supplier.Fibonacci;

public class Main {
    public static void main(String[] args){
        Fichier f1 = new Fichier("data.txt");
        f1.affiche(fichier -> System.out.println(fichier.getNom()));

        Repertoire r1 = new Repertoire("dir");
        r1.ajouter(f1);
        r1.affiche(repertoire -> {
            System.out.println("Repertoire : "+repertoire.getNom());
            for(Fichier f : repertoire.getFichiers()){
                f.affiche(e -> System.out.println("fichier "+e.getNom()));
            }
        });
    }
}
