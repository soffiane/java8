package interfaces;

public class PersonneMain {
    public static void main(String[] args){
        PersonnePhysique pp = new PersonnePhysique("Soffiane");
        System.out.println(pp);

        PersonneMorale pm = new PersonneMorale("pouet","SIRET");
        System.out.println(pm);

    }
}
