package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cette classe ne sert qu'a implementer l'interface pour faire notre traitement bouton
 * @author soffiane
 *
 */
public class ClasseListener implements ActionListener {

    /**
     * Fonction de rappel : fonction en dehors d'une classe impossible donc
     * on cree une classe expres pour ce traitement
     * Mais parfois on a juste besoin d'un traitement
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ca marche");
    }
}
