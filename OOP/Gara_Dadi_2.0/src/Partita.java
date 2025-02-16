import java.util.Scanner;

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
            System.out.println("La gara è già terminata.");
            return;
        }

        int n1 = g1.lanciaDado();
        int n2 = g2.lanciaDado();
        roundGiocati++;

        System.out.println("\n--- Round " + roundGiocati + " ---");
        System.out.println(g1.getNome() + " ha lanciato: " + n1);
        System.out.println(g2.getNome() + " ha lanciato: " + n2);

        if (n1 > n2) {
            g1.incrementaVittorie();
            System.out.println(g1.getNome() + " vince il round!");
        } else if (n2 > n1) {
            g2.incrementaVittorie();
            System.out.println(g2.getNome() + " vince il round!");
        } else {
            g1.incrementaVittorie();
            g2.incrementaVittorie();
            System.out.println("Il round è un pareggio!");
        }

        System.out.println("Vittorie totali:");
        System.out.println(g1);
        System.out.println(g2);
    }

    public boolean fineGara() {
        return roundGiocati >= nRound;
    }

    public void resetGame() {
        roundGiocati = 0;
        g1 = new Giocatore(g1.getNome());
        g2 = new Giocatore(g2.getNome());
        System.out.println("\nLa partita è stata resettata. Tutti i punteggi sono stati azzerati.");
    }

    public void giocaPartita() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il numero di round:");
        setRound(sc.nextInt());

        for (int i = 0; i < nRound; i++) {
            System.out.println("\nPremi Invio per iniziare il round...");
            sc.nextLine();
            round();
        }

        System.out.println(winner());

        System.out.println("\nVuoi resettare la partita e ricominciare? (s/n)");
        String risposta = sc.nextLine();
        if (risposta.equalsIgnoreCase("s")) {
            resetGame();
            giocaPartita();
        }
    }

    public String winner() {
        if (roundGiocati == 0) {
            return "Non è stato ancora eseguito un round.";
        }

        System.out.println("\n--- Risultato Finale ---");
        System.out.println("Round giocati: " + roundGiocati);
        System.out.println(g1);
        System.out.println(g2);

        if (g1.getnVittorie() > g2.getnVittorie()) {
            return "Ha vinto il giocatore " + g1.getNome() + "!";
        } else if (g2.getnVittorie() > g1.getnVittorie()) {
            return "Ha vinto il giocatore " + g2.getNome() + "!";
        } else {
            return "La partita è finita in parità!";
        }
    }
}