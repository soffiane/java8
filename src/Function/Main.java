package Function;

public class Main {
	public static void main(String[] args) {
		Client client = new Client("Soffiane", "Boudissa");
		//on doit passer une Function qui prend un client et renvoie un String
		//methode apply
		String str = client.rendre(Client::getNom);
		System.out.println(str);

		//la methode mais elle fait un truc different
		str = client.rendre(c -> "<b>" + c.getNom() + "</b>");
		System.out.println(str);

		Facture facture = new Facture("2016-01");
		System.out.println(facture.getNumero());
		facture.increment(s -> s + "-01");
		System.out.println(facture.getNumero());

		client.setFacture(facture);
		//ce lambda prend le client et la facture et renvoie la chaine qui
		//concatene le nom client et le num facture
		String res = client.lierClientAFacture((c, f) -> c.getNom() + f.getNumero());
		System.out.println(res);

		String resBis = client.afficherNomComplet((a, b) -> a + " " + b);
		System.out.println(resBis);
	}
}
