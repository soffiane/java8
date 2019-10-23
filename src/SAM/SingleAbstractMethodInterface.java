package SAM;

/** Single Abstract Method est une interface avec une seule methode
 * l'interface n'existe QUE pour cette methode
 * exemple : IHM -> ActionListener, tri -> interface COmparable methode compareTo
 * le lambda se substitue à la methode unique
 * on les appelles plutot "interface fonctionnelles"
 */
public interface SingleAbstractMethodInterface {

    public void execute();
}
