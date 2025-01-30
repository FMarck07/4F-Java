import java.util.Objects;

public class Veicolo {
    private String marca;
    private String modello;
    private double prezzo;

    public Veicolo(String marca, String modello, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return String.format("Marca: %s, Modello: %s, Prezzo: %f", marca, modello, prezzo);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Veicolo)) {
            return false;
        }
        else{
            Veicolo a = (Veicolo) obj ;
            return marca.equals(a.getMarca()) && modello.equals(a.getModello());
        }
    }
}
