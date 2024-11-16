public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    public Pilota(String nome, String cognome, String nazionalita, int eta) {
        if (eta <= 0) {
            throw new IllegalArgumentException("L'età deve essere maggiore di 0.");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public boolean equals(Pilota altroPilota) {
        if (altroPilota == null) return false;
        return this.nome.equalsIgnoreCase(altroPilota.nome) && this.cognome.equalsIgnoreCase(altroPilota.cognome);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Cognome: %s Nazionalità: %s Età: %d", nome, cognome, nazionalita, eta);
    }
}
