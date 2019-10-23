package interfaces;

public class PersonnePhysique implements IPersonne{
    private String nom;

    public PersonnePhysique(String nom){
        this.nom = nom;
    }
    @Override
    public String getNom() {
        return nom;
    }

    public String toString(){
        return nom+" "+getSiret();
    }

    //ici, on voit le probleme : la personne physique n'a pas de siret
    //donc methode à implementation vide avec levée d'exception (UnsupportedException)
    //l'implémentation par défaut dans l'interface va servir ici --> plus besoin de reecrire la methode
    //@Override
    //public String getSiret() {
    //    throw new UnsupportedOperationException("operation non supportée");
    //}
}
