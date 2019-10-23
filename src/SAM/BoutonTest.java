package SAM;

import javax.swing.*;

public class BoutonTest extends JFrame {

    public BoutonTest(){
        JButton bouton = new JButton("clic");
        add(bouton);

        /*bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("bouton click");
            }
        });*/
        //on remplace classe interne anonyme par lambda
        bouton.addActionListener(e -> System.out.println("bouton click"));

        pack();
    }

    public static void appelInterfaceSAM(SingleAbstractMethodInterface sam){
        sam.execute();
    }

    //On appelle directement un lambda pour remplacer la methode
    //ca ne fonctionne evidemment pas si l'interface a plusieurs methode
    //car on ne sait pas quelle methode est appellée
    public static void main(String[] args){
        appelInterfaceSAM(() -> System.out.println("Hello"));
    }
}
