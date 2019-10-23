package nouveautes_langages;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * on connait deja l'API Reflection qui permet de recuperer la classe et
 * tous les attributs d'une classe a partir d'une instance pour manipuler l'objet
 * sans connaitre son type.
 *
 * On peut maintenant creuser jusqu'a avoir le nom des parametres
 *
 * La classe est le descripteur des objets
 * Chaque objet connait sa classe
 * La reflexion permet de trouver via un objet les caracteristiques de sa classe
 * permet d'invoquer une methode sans ecrire directement l'appel
 * de decouvrir les champs de l'objet...
 *
 * Les limites :
 * problemes de performance car on doit inspecter toutes les methodes de l'objet
 * au lieu d'appeler directement les methodes
 *
 * perte du controle de type lors de la compilation puisqu'on passe par des types
 * de haut niveau (Object), le compilateur est obligé de vous faire confiance
 *
 * probleme de refactoring : si on accede au membres par leur nom, on risque d'avoir
 * des soucis si on change les noms
 *
 * impossible d'avoir le nom des parametres (jusqu'a Java 8), avant il fallait utiliser des moyens
 * de contournements comme des annotations
 *
 * compiler avec javac -parameters
 */

public class ReflexionParametre {

    public static void main(String[] args){
        Personne personne = new Personne();
        Voiture voiture = new Voiture();
        voiture.acheter(personne);

        //avec la reflection
        Method method = null;
        try {
            method = voiture.getClass().getMethod("acheter", Personne.class);
            Parameter[] params = method.getParameters();
            String parameterName = params[0].getName();
            System.out.println(parameterName);
            method.invoke(personne);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



}
