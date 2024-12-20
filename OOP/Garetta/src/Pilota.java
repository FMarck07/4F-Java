public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalità;

    public Pilota(String nome, String cognome, String nazionalità) throws Exception {
        if (isValue(nome) && isValue(cognome) && isValue(nazionalità)) {
            this.nome = nome;
            this.cognome = cognome;
            this.nazionalità = nazionalità;
        } else {
            throw new Exception("Dati non validi per il pilota.");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Cognome: %s, Nazionalità: %s", nome, cognome, nazionalità);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pilota pilota = (Pilota) obj;
        return nome.equals(pilota.nome) && cognome.equals(pilota.cognome) && nazionalità.equals(pilota.nazionalità);
    }

    private boolean isValue(String valore) {
        return valore != null && !valore.isEmpty();
    }
}
