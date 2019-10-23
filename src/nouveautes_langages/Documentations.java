package nouveautes_langages;


//pour utiliser Repeatable, nous avons besoin d'une interface qui implemente
//l'attribut value et qui correspond a une liste de ce qu'on veut rendre repetable
public @interface Documentations {
    Documentation[] value();
}
