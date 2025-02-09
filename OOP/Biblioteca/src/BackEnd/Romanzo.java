package BackEnd;

public class Romanzo extends Libro {
    private String genereLetterario;

    public Romanzo(String autore, String titolo, int nPagine, String genereLetterario) {
        super(autore, titolo, nPagine);
        this.genereLetterario = genereLetterario;
    }

    public String getGenereLetterario() {
        return genereLetterario;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Genere Letterario: %s", genereLetterario);
    }
}