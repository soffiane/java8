package lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonTestBis extends JFrame{

    JTextField textFieldBis = new JTextField("Hello Java8");

    public BoutonTestBis() {
        setLayout(new FlowLayout());
        JTextField textField = new JTextField("Hello World");
        add(textField);
        JButton bouton = new JButton("clic");
        add(bouton);
        add(textFieldBis);
        JButton boutonBis = new JButton("push");
        add(boutonBis);

        //si on declare une variable du meme nom que celle de l'expression lambda dans la fonction
        //il y a conflit car les variables des lambdas n'ont pas d'espace propre
        //le lambda accède aux variables locales et aux variables de classes (attributs)
        bouton.addActionListener(actionEvent -> {
            textField.setText("bonjour");
            textFieldBis.setText("salut");
        });
        pack();
    }

    public static void main(String[] args) {
        BoutonTestBis test = new BoutonTestBis();
        test.setVisible(true);

    }
}
