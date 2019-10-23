package Function;

import java.util.function.UnaryOperator;

//exemple pour UnaryOperator
public class Facture {

    private String numero;

    public Facture(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    //comment incrementer un numero de facture de type String ?
    //avec UnaryOperator qui prend un parametre de type T et
    //renvoie un parametre de type T
    void increment(UnaryOperator<String> inc){
        numero = inc.apply(numero);
    }

}
