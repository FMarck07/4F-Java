public class Moto extends Veicolo{
    private Integer cilindrata;

    public Moto(String marca, String modello, int prezzo, Integer cilindrata) {
        super(marca, modello, prezzo);
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return  super.toString() + String.format("Cilindrata: %d", cilindrata);
    }
}
