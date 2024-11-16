public class Auto {
    private String scuderia;
    private Pilota pilota;
    private double cilindrata;

    public Auto(String scuderia, Pilota pilota, double cilindrata) {
        if (cilindrata <= 0) {
            throw new IllegalArgumentException("La cilindrata deve essere maggiore di 0.");
        }
        this.scuderia = scuderia;
        this.pilota = pilota;
        this.cilindrata = cilindrata;
    }

    public Pilota getPilota() {
        return pilota;
    }

    public double getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
        return "Scuderia: " + scuderia + ", Pilota: [" + pilota + "], Cilindrata: " + cilindrata;
    }
}
