public class Cronometro {

    private Long tempoInizio; // Timestamp di inizio
    private Long tempoFine;   // Timestamp di fine
    private Long durata;      // Durata misurata in millisecondi

    /**
     * Costruttore: inizializza un cronometro.
     */
    public Cronometro() {
        reset();
    }

    /**
     * Avvia il cronometro. Se è già avviato, segnala lo stato.
     */
    public void avvia() {
        if (tempoInizio == null) {
            tempoInizio = System.nanoTime();
            System.out.println("Cronometro avviato.");
        } else {
            System.out.println("Il cronometro è già in esecuzione.");
        }
    }

    /**
     * Ferma il cronometro e calcola la durata. Segnala se non era avviato.
     */
    public void ferma() {
        if (tempoInizio != null && tempoFine == null) {
            tempoFine = System.nanoTime();
            durata = (tempoFine - tempoInizio) / 1_000_000; // Converti in millisecondi
            System.out.println("Cronometro fermato.");
        } else if (tempoFine != null) {
            System.out.println("Il cronometro è già stato fermato.");
        } else {
            System.out.println("Il cronometro non è stato avviato.");
        }
    }

    /**
     * Restituisce la durata corrente o quella registrata.
     *
     * @return la durata in millisecondi.
     */
    public long getDurata() {
        if (tempoInizio != null) {
            if (tempoFine == null) {
                return (System.nanoTime() - tempoInizio) / 1_000_000; // Misurazione corrente
            }
            return durata; // Ultima durata registrata
        }
        return 0; // Cronometro mai avviato
    }

    /**
     * Restituisce la durata in un formato leggibile (HH:mm:ss.SSS).
     *
     * @return stringa formattata della durata.
     */
    public String getDurataFormattata() {
        long milliseconds = getDurata();

        long ore = milliseconds / 3600000;
        long minuti = (milliseconds % 3600000) / 60000;
        long secondi = (milliseconds % 60000) / 1000;
        long ms = milliseconds % 1000;

        return String.format("%02d:%02d:%02d.%03d", ore, minuti, secondi, ms);
    }

    /**
     * Resetta il cronometro, azzerando tutti i valori.
     */
    public void reset() {
        tempoInizio = null;
        tempoFine = null;
        durata = null;
        System.out.println("Cronometro resettato.");
    }
}
