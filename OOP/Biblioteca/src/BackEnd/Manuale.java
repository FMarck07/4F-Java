package BackEnd;

public class Manuale extends Libro {
    private String argomento;
    private Livello livello;

    public enum Livello {
        BASE, PRINCIPIANTE, ESPERTO
    }

    public Manuale(String autore, String titolo, int nPagine, String argomento, Livello livello) {
        super(autore, titolo, nPagine);
        this.argomento = argomento;
        this.livello = livello;
    }

    public String getArgomento() {
        return argomento;
    }

    public Livello getLivello() {
        return livello;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Argomento: %s Livello: %s", argomento, livello);
    }
}