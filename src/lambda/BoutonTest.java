package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoutonTest extends JFrame {

    public BoutonTest() {
        JButton bouton = new JButton("Cliquez ici");
        add(bouton);
        //cette classe correspond à mon Listener et represente la premier
        //option : instancier une classe qui implemente l'interface ActionListener
        ClasseListener monListener = new ClasseListener();
        bouton.addActionListener(monListener);
        //On passe de l'instanciation d'une classe qui implemente l'interface ActionListener
        //a l'utilisation d'une classe interne anonyme crée à la volée --> plus besoin de ClasseListener
        /*Sonar recommande de remplacer cette classe interne anonyme par un lambda
        //actionListener n'est pas une classe mais une interface
        //on cree une classe sans nom qui implemente la ActionListener
        //le compilateur genere un .class pour l'anonyme qui contient $1 en plus de la classe
        //classe anonymes = classe interne
        //avantage : pas besoin de creer une classe qui implemente l'interface ActionListener,
        //classe cree a la volee = economie de code
        //classe interne a acces privilegie a la classe englobante (meme privees) */
        bouton.addActionListener(new ActionListener() {
            //corps de la classe
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton clique");

            }
        });
        //si on declare une variable du meme nom que celle de l'expression lambda
        //il y a conflit car les variables des lambdas n'ont pas d'espace propre
        //String a = "";
        //on remplace la classe interne anonyme par un lambda
        //on ne declare ni instancie de classe
        //et ca marche car ActionListener est une interface qui ne contient qu'une methode
        int indiceLocal = 0;
        bouton.addActionListener(a ->
                System.out.println("test")
        );
        pack();
    }

    public static void main(String[] args) {
        BoutonTest test = new BoutonTest();
        test.setVisible(true);

    }


}
