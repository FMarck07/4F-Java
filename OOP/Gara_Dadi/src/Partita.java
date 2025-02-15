public class Partita {
    private Giocatore g1;
    private Giocatore g2;
    private int nPartite;
    private final int fine;

    public Partita(Giocatore g1, Giocatore g2, int fine) {
        this.g1 = g1;
        this.g2 = g2;
        this.fine = fine;
        this.nPartite = 0;
    }

    public void round() throws Exception {
        if (fineGara()) {
            throw new Exception("La gara è già terminata.");
        }

        int n1 = g1.lanciaDado();
        int n2 = g2.lanciaDado();
        nPartite++;

        if (n1 > n2) {
            g1.incrementaVittorie();
        } else if (n2 > n1) {
            g2.incrementaVittorie();
        } else {
            g1.incrementaVittorie();
            g2.incrementaVittorie();
        }
    }

    public boolean fineGara() {
        return nPartite >= fine;
    }

    public void resetGame() {
        nPartite = 0;
        g1 = new Giocatore(g1.getNome());
        g2 = new Giocatore(g2.getNome());
    }

    public String winner() {
        if (nPartite == 0) {
            return "Non è stato ancora eseguito un round.";
        }

        if (g1.getnVittorie() > g2.getnVittorie()) {
            return "Ha vinto il giocatore " + g1.toString();
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            return "Ha vinto il giocatore " + g2.toString();
        } else {
            return "Parità: " + g1.getnVittorie() + " a " + g2.getnVittorie();
        }
    }
}