import java.util.Random;

public class Dado implements Comparable<Dado> {
    private final int nFacce;
    private int valFaccia;
    private final Random random;

    public Dado(int nFacce) {
        if (nFacce <= 0) {
            throw new IllegalArgumentException("Il numero di facce deve essere maggiore di 0.");
        }
        this.nFacce = nFacce;
        this.random = new Random();
    }

    public int getValFaccia() {
        return valFaccia;
    }

    public void lancia() {
        valFaccia = random.nextInt(nFacce) + 1;
    }

    public void reset() {
        valFaccia = 0;
    }

    @Override
    public int compareTo(Dado d) {
        return Integer.compare(this.valFaccia, d.valFaccia);
    }
}