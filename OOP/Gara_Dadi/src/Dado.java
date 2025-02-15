import java.util.Random;

public class Dado implements Comparable<Dado> {
    private final int nFacce = 6;
    private Integer valLancio;

    public Dado(Integer valLancio) {
        this.valLancio = valLancio;
    }

    public int getnFacce() {
        return nFacce;
    }

    public Integer getValLancio() {
        return valLancio;
    }

    public void setValLancio(int valLancio) {
        this.valLancio = valLancio;
    }

    public int Lancia() {
        Random rn = new Random();
        return valLancio = rn.nextInt(1,nFacce);
    }

    @Override
    public int compareTo(Dado o) {
        return o.valLancio.compareTo(valLancio);
    }
}
