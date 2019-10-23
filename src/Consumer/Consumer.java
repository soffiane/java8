package Consumer;

/**
 * Interface fonctionnelle qui consomme une donnée
 *
 * Consumer<T>
 * possede une methode accept(T t) qui consomme une donnée et ne retourne rien
 * effet de bord : modifier le contexte d'execution des variables/attributs de la donnée
 * andThen(Consumer) : consomme la production en chainant l'autre
 *
 * DoubleConsumer
 * pour les doubles : accept(double d)
 *
 * LongConsumer
 * pour les long : accept(long l)
 *
 * ObjDoubleConsumer<T>
 * accept(T t, double d)
 *
 * ObjIntConsumer<T>
 * accept(T t, int i)
 *
 * ObjLongConsumer<T>
 * accept(T t, long l)
 */

public class Consumer {
}
