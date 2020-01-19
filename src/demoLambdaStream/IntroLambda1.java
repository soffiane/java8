package demoLambdaStream;

/**
 * Created by boudissa.s on 08/07/2016.
 */
public class IntroLambda1 {

	//interface fonctionnelle
	interface Calculateur {
		public int calcul(int n);
	}

	public static void main(String[] args) {
		int n1 = 5, n2 = 3;
		//pour instancier l'interface,il faut surcharger la methode calcul
		//classe anonyme
		Calculateur carre = new Calculateur() {
			@Override
			public int calcul(int n) {
				return n * n;
			}
		};
		//ou alors on peut utiliser une expression lambda pour la variable de type interface
		//L'utilisation d'un lambda permet de remplacer une classe anonyme
		Calculateur carreBis = x -> x * x;

		int res = carre.calcul(n1);
		System.out.println(res);
		System.out.println(carre.calcul(n2));

		int resBis = carreBis.calcul(n1);
		System.out.println(resBis);
		System.out.println(carreBis.calcul(n2));

		//on peut passer un bloc d'instruction dans une lambda
		//mais il faudra (au moins) une instruction return dans ce bloc
		Calculateur complexe = x -> {
			if (x > 0) {
				if (2 * (x / 2) == x) return x;
				else return x + 1;
			} else return -x;
		};

		int resCom = complexe.calcul(n1);
		System.out.println(resCom);
		System.out.println(complexe.calcul(n2));
	}
}
