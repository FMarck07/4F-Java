public class Studente extends Persona {

    private String matricola;
    private double mediaVoti;

    // Costruttore che aggiunge i nuovi parametri
    public Studente(String nome, String cognome, int eta, String luogoDiNascita, String colorePreferito, String squadraDelCuore, String matricola, double mediaVoti) {
        super(nome, cognome, eta, luogoDiNascita, colorePreferito, squadraDelCuore);
        this.matricola = matricola;
        this.mediaVoti = mediaVoti;
    }

    // Costruttore che copia un oggetto Persona e aggiunge i nuovi parametri
    public Studente(Persona persona, String matricola, double mediaVoti) {
        super(persona.getNome(), persona.getCognome(), persona.getEta(), persona.getLuogoDiNascita(), persona.getColorePreferito(), persona.getSquadraDelCuore());
        this.matricola = matricola;
        this.mediaVoti = mediaVoti;
    }

    // Getter e Setter per i nuovi attributi
    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(double mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    @Override
    public String toString() {
        // Aggiungi i nuovi attributi alla presentazione
        return String.format("%s, Matricola: %s, Media Voti: %.2f", presentazione(), matricola, mediaVoti);
    }

    @Override
    public String presentazione() {
        return String.format("Ciao, mi chiamo %s %s, ho %d anni, sono di %s, il mio colore preferito è %s e la mia squadra del cuore è %s", nome, cognome, eta, luogoDiNascita, colorePreferito, squadraDelCuore);
    }
}
