package interfaces;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ClassWindowListener extends JFrame {

    public ClassWindowListener(){
        JLabel label = new JLabel("label");
        add(label);
        //classe anonyme interne avec toutes les méthodes
        //de l'interface WindowListener mais on en a pas besoin
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            //on a besoin que de la methode declenchée à la fermeture
            //pour tuer le process sinon il continue a tourner par defaut
            //meme quand on ferme la JFrame
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            //toutes les autres méthodes ne servent a rien
            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
    ClassWindowListener test = new ClassWindowListener();
    test.setVisible(true);
    }
}
