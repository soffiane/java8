package nouveautes_langages;

import java.lang.annotation.*;

//On dit que l'annotation ne peut se placer que sur des classe pour TYPE, des methodes pour METHOD...
//@Target(ElementType.TYPE)
//Savoir si on charge au compile time ou au runtime
@Retention(value = RetentionPolicy.CLASS)
//rendre l'annotation repetable : attention au Target et à la Retention
@Repeatable(value = Documentations.class)
public @interface Documentation {

    String auteur();
    String date();
    double version() default 1.0;
    String[] responsables();

}
