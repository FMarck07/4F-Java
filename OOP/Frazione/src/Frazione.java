public class Frazione {
    private int numeratore;
    private int denominatore;


    public Frazione(int numeratore, int denominatore) throws Exception {
        setDenominatore(denominatore);
        setNumeratore(numeratore);
    }

    public Frazione(int numeratore) throws Exception {
        this(numeratore, 5);
    }

    public int getNumeratore() {
        return numeratore;
    }


    public void setNumeratore(int numeratore) {
        this.numeratore = numeratore;
    }


    public int getDenominatore() {
        return denominatore;
    }


    public void setDenominatore(int denominatore) throws Exception {
        if (denominatore == 0) {
            throw new Exception("Hai inserito lo zero come denominatore");
        }
        this.denominatore = denominatore;
    }

    public Frazione sommaFrazione(Frazione fr) throws Exception {
        Frazione nuova = new Frazione(this.numeratore * fr.denominatore + fr.numeratore * denominatore, fr.denominatore * this.denominatore);
        return nuova;
    }

    public double somma(Frazione fr1) throws Exception {

        return ((double) this.numeratore / this.denominatore) + ((double) fr1.numeratore / fr1.denominatore);
    }


    @Override
    public String toString() {
        return String.format(" %d/%d", numeratore, denominatore);
    }
}