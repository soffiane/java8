package nouveautes_langages;

//on peut annoter une classe mais une seule fois car pas repetable
//on pourrait la rendre repetable pour, par exemple, specifier plusieurs auteurs
@Documentation(auteur = "Soffiane Boudissa", date = "09/07/2019", version = 2.0, responsables = {"Soffiane","Veronica"})
@Documentation(auteur = "Robert Robichon", date = "10/07/2019", version = 2.0, responsables = {"Soffiane","Veronica","Robert"})
public class Voiture {

    //on peut aussi annoter une méthode
    //@Documentation(auteur = "Soffiane Boudissa", date = "09/07/2019", version = 2.0, responsables = {"Soffiane","Veronica"})
    void method(){
        System.out.println("pouet");
    }

    public void acheter(Personne acheteur){

    }
}
