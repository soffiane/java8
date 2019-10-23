package interfaces;

public interface IPersonne {
    String getNom();

    default String getSiret() {
        return "pas de siret";
    }
}
