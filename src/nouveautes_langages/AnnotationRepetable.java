package nouveautes_langages;

/**
 * annotation tres repandues : standard et framework
 * declarée par @interface, possede des proprietes avec des valeurs par defaut possibles
 * annotations sur champ, classes, méthode...
 * Lors de l'utilisation d'un type (creation d'un objet de ce type...)
 * on ne met qu'une seule fois @Deprecated pour une méthode depreciée par exemple (sauf si repetable du coup)
 * javadoc prend en compte les annotations
 * peut se voir restreint a certains usages, executable runtime ou a l'execution
 *
 * Pour pouvoir créer une annotation repetable, on utilise @Repeatable sur la declaration
 * de l'annotation
 */

public class AnnotationRepetable {

    @interface ClassPreambule {
        //les attributs sont des méthodes
        String author();
        String date();
        int currentRevision() default 1;
        String lastModified() default "N/A";
        String[] reviewers();
    }

    public static void main(String[] args){
        Voiture v = new Voiture();
        //renvoie la liste des annotations
        v.getClass().getAnnotations();
    }
}
