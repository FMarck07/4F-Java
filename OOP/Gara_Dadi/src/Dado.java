import java.util.Random;

public class Dado {
    private final int nFacce = 6;
    private int valLancio;

    public Dado() {
        this.valLancio = 0;
    }

    public int getnFacce() {
        return nFacce;
    }

    public int getValLancio() {
        return valLancio;
    }

    public int lancia() {
        Random rn = new Random();
        valLancio = rn.nextInt(nFacce) + 1;
        return valLancio;
    }
}