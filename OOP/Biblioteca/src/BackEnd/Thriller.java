package BackEnd;

public class Thriller extends Libro {
    private boolean derivatoDaSerieTV;

    public Thriller(String autore, String titolo, int nPagine, boolean derivatoDaSerieTV) {
        super(autore, titolo, nPagine);
        this.derivatoDaSerieTV = derivatoDaSerieTV;
    }

    public boolean isDerivatoDaSerieTV() {
        return derivatoDaSerieTV;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Derivato da serie TV: %s", derivatoDaSerieTV ? "Sì" : "No");
    }
}