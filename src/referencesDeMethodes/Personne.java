package referencesDeMethodes;

public class Personne {

    private String nom;
    private int age;
    public Personne(String nom,int age){
        this.nom = nom;
        this.age = age;
    }

    public static int compare(Personne p1, Personne p2){
        return p1.age - p2.age;
    }

    public String toString(){
        return nom+" "+age;
    }
}
