package veicolo;
public class Moto extends Veicolo{

    // Attributi
    private int cilindrata;

    // Costruttore
    public Moto(String marca, String modello, Integer prezzo, Integer cilindrata) {
        super(marca, modello, prezzo);
        this.cilindrata = cilindrata;
    }

    // Getter e Setter
    public Integer getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Integer cilindrata) {
        this.cilindrata = cilindrata;
    }

    // toString
    @Override
    public String toString() {
        return  super.toString() + String.format(", Cilindrata: %d", cilindrata);
    }
}