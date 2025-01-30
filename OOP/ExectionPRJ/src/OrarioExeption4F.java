public class OrarioExeption4F extends Exception{
    private String message = "Problema con l'orario";

    private int h;
    private int n;
    private int s;

    public String getMessage() {
        return message;
    }

    public OrarioExeption4F(int h, int n, int s) {
        this.h = h;
        this.n = n;
        this.s = s;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
}
