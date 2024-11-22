import java.util.ArrayList;

public class Rettangolo {
    private Punto angolo;
    private double base, altezza;
    private ArrayList<Segmento> segmenti;

    public Rettangolo(Punto angolo, double base, double altezza) {
        this.angolo = angolo;
        this.base = base;
        this.altezza = altezza;
        this.segmenti = new ArrayList<>();
        calcolaSegmenti();
    }

    private void calcolaSegmenti() {
        Punto punto2 = new Punto(angolo.getX() + base, angolo.getY()); // Alto destra
        Punto punto3 = new Punto(angolo.getX() + base, angolo.getY() - altezza); // Basso destra
        Punto punto4 = new Punto(angolo.getX(), angolo.getY() - altezza); // Basso sinistra

        // Calcola i segmenti
        segmenti.add(new Segmento(angolo, punto2)); // Base superiore
        segmenti.add(new Segmento(punto2, punto3)); // Lato destro
        segmenti.add(new Segmento(punto3, punto4)); // Base inferiore
        segmenti.add(new Segmento(punto4, angolo)); // Lato sinistro
    }

    public void disegnaRettangolo() {
        int altezzaInt = (int) altezza; // Approssimazione all'intero
        int baseInt = (int) base; // Approssimazione all'intero

        // Costruiamo una griglia
        for (int y = 0; y < altezzaInt; y++) {
            for (int x = 0; x < baseInt; x++) {
                // Disegniamo il perimetro: lati superiore, inferiore, sinistro e destro
                if (y == 0 || y == altezzaInt - 1 || x == 0 || x == baseInt - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Vai a capo per la riga successiva
        }
    }

    public Punto getAngolo() {
        return angolo;
    }

    public void setAngolo(Punto angolo) {
        this.angolo = angolo;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public ArrayList<Segmento> getSegmenti() {
        return segmenti;
    }

    @Override
    public String toString() {
        return String.format("Rettangolo con angolo in %s, base %.2f e altezza %.2f", angolo, base, altezza);
    }
}
