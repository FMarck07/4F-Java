public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getQuadrante() {
        if (x > 0 && y > 0) {
            return "I Quadrante";
        } else if (x < 0 && y > 0) {
            return "II Quadrante";
        } else if (x < 0 && y < 0) {
            return "III Quadrante";
        } else if (x > 0 && y < 0) {
            return "IV Quadrante";
        } else if (x == 0 && y == 0) {
            return "Origine";
        } else if (x == 0) {
            return "Asse Y";
        } else {
            return "Asse X";
        }
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}
