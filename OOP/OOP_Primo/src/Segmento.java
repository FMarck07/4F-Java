public class Segmento {
    private Punto puntoA;
    private Punto puntoB;

    public Segmento(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public double lunghezza() {
        double deltaX = puntoB.getX() - puntoA.getX();
        double deltaY = puntoB.getY() - puntoA.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return String.format("Segmento [%s -> %s], Lunghezza: %.2f", puntoA, puntoB, lunghezza());
    }
}
