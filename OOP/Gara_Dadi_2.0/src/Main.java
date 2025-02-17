import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Cicciogaer89");
        Giocatore g2 = new Giocatore("Poli");
        Partita p = new Partita(g1, g2);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il numero di round:");
        p.setRound(sc.nextInt());

        for (int i = 0; i < p.getnRound(); i++) {
            System.out.println("\nPremi Invio per iniziare il round...");
            sc.nextLine();

            p.round();

            System.out.println("\n--- Round " + (i + 1) + " ---");
            System.out.println(p.getGiocatore1().getNome() + " ha lanciato: " + p.getGiocatore1().lanciaDado());
            System.out.println(p.getGiocatore2().getNome() + " ha lanciato: " + p.getGiocatore2().lanciaDado());
            System.out.println("Vittorie totali:");
            System.out.println(p.getGiocatore1());
            System.out.println(p.getGiocatore2());
        }


        System.out.println(p.winner());

        System.out.println("\nVuoi resettare la partita e ricominciare? (s/n)");
        String risposta = sc.nextLine();
        if (risposta.equalsIgnoreCase("s")) {
            p.resetGame();
            main(args);
        }
    }
}