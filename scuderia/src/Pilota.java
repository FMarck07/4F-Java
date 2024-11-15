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

    public String getNazionalita() {
        return nazionalita;
    }

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public void setEta(int eta) {
        if (eta <= 0) {
            throw new IllegalArgumentException("L'età deve essere maggiore di 0.");
        }
        this.eta = eta;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Cognome: %s Nazionalità: %s Età: %d", nome, cognome, nazionalita, eta);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false; // Verifica che l'oggetto non sia nullo e appartenga alla stessa classe
        }
        Pilota p = (Pilota) o; // Cast sicuro dopo il controllo della classe
        return nome.equals(p.nome) && cognome.equals(p.cognome) && eta == p.eta; // Confronto dei campi
    }
}
