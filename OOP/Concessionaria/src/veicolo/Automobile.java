package veicolo;
public class Automobile extends Veicolo{

    // Attributi
    private int numeroPorte;

    // Costruttore
    public Automobile(String marca, String modello, Integer prezzo, Integer numeroPorte) {
        super(marca, modello, prezzo);
        this.numeroPorte = numeroPorte;
    }

    // Getter e Setter
    public Integer getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(Integer numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    // toString
    @Override
    public String toString() {
        return  super.toString() + String.format(", Numero di Porte: %d", numeroPorte);
    }
}