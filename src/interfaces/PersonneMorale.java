package interfaces;

//ici aucun probleme, implementation normale
public class PersonneMorale implements IPersonne {
    private String raisonSociale;
    private String siret;

    public PersonneMorale(String raisonSociale, String siret){
        this.raisonSociale = raisonSociale;
        this.siret = siret;
        this.siret = siret;
    }

    @Override
    public String getNom() {
        return raisonSociale;
    }

    @Override
    public String getSiret() {
        return siret;
    }

    public String toString(){
        return siret+" "+raisonSociale;
    }
}
