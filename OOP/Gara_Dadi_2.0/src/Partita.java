public class Partita {
    private Giocatore g1;
    private Giocatore g2;
    private int nRound;
    private int roundGiocati;

    public Partita(Giocatore g1, Giocatore g2) {
        this.g1 = g1;
        this.g2 = g2;
        this.roundGiocati = 0;
    }

    public void setRound(int nRound) {
        if (nRound <= 0) {
            throw new IllegalArgumentException("Il numero di round deve essere maggiore di 0.");
        }
        this.nRound = nRound;
    }

    public void round() {
        if (fineGara()) {
            return; // La gara è già terminata
        }

        int n1 = g1.lanciaDado();
        int n2 = g2.lanciaDado();
        roundGiocati++;

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
        return roundGiocati >= nRound;
    }

    public void resetGame() {
        roundGiocati = 0;
        g1 = new Giocatore(g1.getNome());
        g2 = new Giocatore(g2.getNome());
    }

    public Giocatore getGiocatore1() {
        return g1;
    }

    public Giocatore getGiocatore2() {
        return g2;
    }

    public int getRoundGiocati() {
        return roundGiocati;
    }

    public int getnRound() {
        return nRound;
    }

    public String winner() {
        if (roundGiocati == 0) {
            return "Non è stato ancora eseguito un round.";
        }

        if (g1.getnVittorie() > g2.getnVittorie()) {
            return "Ha vinto il giocatore " + g1.getNome() + "!";
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            return "Ha vinto il giocatore " + g2.getNome() + "!";
        } else {
            return "La partita è finita in parità!";
        }
    }
}
