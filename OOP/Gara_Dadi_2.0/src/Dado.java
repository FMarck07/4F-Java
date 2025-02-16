import java.util.Random;

public class Dado {
    private final int nFacce = 6;
    private int valLancio;

    public Dado() {
    }

    public int lancia() {
        Random rn = new Random();
        valLancio = rn.nextInt(nFacce) + 1;
        return valLancio;
    }
}