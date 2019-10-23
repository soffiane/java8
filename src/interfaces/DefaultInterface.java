package interfaces;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//les problemes liés au interfaces :
//peu declarer plusieurs méthodes et une classe qui implemente une interface
//doit reecrire les methodes, meme si ca ne vous interesse pas --> contrainte standard
//Exemple de l'interface WindowListener de l'API Swing --> ClassWindowListener
public interface DefaultInterface {
    //on peut définir une implementation par défaut avec le mot cle "default"
    //que la classe fille peut toujours réecrire
    default String getNom(){ return "nom par défaut";}

}
