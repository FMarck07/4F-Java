import java.util.Objects;

public class Automobile extends Veicolo{
    private int numeroPorte;

    public Automobile(String marca, String modello, int prezzo, int numeroPorte) {
        super(marca, modello, prezzo);
        this.numeroPorte = numeroPorte;
    }


    public int getNumeroPorte() {
        return numeroPorte;
    }

    @Override
    public String toString() {
        return  super.toString() + String.format("Numero di Porte: %d", numeroPorte);
    }
}
