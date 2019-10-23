package InterfacesFonctionnelles;

/**
 * Represente une fonction qui prend un argument et renvoie un resultat
 * et n'a qu'une seule méthode
 * On définit une signature avec types et nombres de parametres a respecter
 * On définit un type pour les passages de parametres
 * On définit un type pour les références de méthodes
 * Il existe des interfaces fonctionnelles toutes pretes dans l'API
 */
@FunctionalInterface
public interface InterfaceFonctionnelle {
    void execute();
}
