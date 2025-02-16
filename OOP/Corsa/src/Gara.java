public class Gara {
    private int nRound;
    private Corridore c1;
    private Corridore c2;
    private int rGiocati;

    public Gara(int nRound, Corridore c1, Corridore c2) {
        this.nRound = nRound;
        this.c1 = c1;
        this.c2 = c2;
        this.rGiocati = 0;
    }

    public void round() {
        if (fineGara()) {
            System.out.println("La gara è già terminata!");
            return;
        }

        int n1 = c1.generaVelocita();
        int n2 = c2.generaVelocita();
        rGiocati++;

        System.out.println("\n--- Round " + rGiocati + " ---");
        System.out.println(c1.getNome() + " ha una velocità di " + n1 + " km/h");
        System.out.println(c2.getNome() + " ha una velocità di " + n2 + " km/h");

        if (n1 > n2) {
            c1.incrementaVittorie();
            System.out.println(c1.getNome() + " vince il round!");
        } else if (n2 > n1) {
            c2.incrementaVittorie();
            System.out.println(c2.getNome() + " vince il round!");
        } else {
            c1.incrementaVittorie();
            c2.incrementaVittorie();
            System.out.println("Il round è un pareggio!");
        }

        System.out.println("Vittorie totali:");
        System.out.println(c1);
        System.out.println(c2);
    }

    public boolean fineGara() {
        return rGiocati >= nRound;
    }

    public String vincitore() {
        if (rGiocati == 0) {
            return "Non è stato ancora giocato un round.";
        }

        System.out.println("\n--- Risultato Finale ---");
        System.out.println("Round giocati: " + rGiocati);
        System.out.println(c1);
        System.out.println(c2);

        if (c1.getnVittorie() > c2.getnVittorie()) {
            return "Ha vinto il giocatore: " + c1.getNome() + "!";
        } else if (c2.getnVittorie() > c1.getnVittorie()) {
            return "Ha vinto il giocatore: " + c2.getNome() + "!";
        } else {
            return "I due giocatori sono in parità!";
        }
    }
}