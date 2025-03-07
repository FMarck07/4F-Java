import utility.Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci il nome del giocatore 1: ");
        Giocatore g1 = new Giocatore(sc.nextLine());

        System.out.print("Inserisci il nome del giocatore 2: ");
        Giocatore g2 = new Giocatore(sc.nextLine());

        System.out.print("Inserisci il numero di round da giocare: ");
        int roundTotali = sc.nextInt();

        System.out.print("Inserisci il numero di facce del dado: ");
        int nFacceDado = sc.nextInt();

        Dado d1 = new Dado(nFacceDado);
        Dado d2 = new Dado(nFacceDado);

        System.out.println("Inserisci il tipo di partita:");
        String[] opzioni = {"MENU", "NORMALE", "AVANZATA"};

        try {
            int scelta = Tools.Menu(opzioni, sc);
            if (scelta == 1 || scelta == 2) {
                Gara gara = new Gara();
                giocaPartita(gara, g1, g2, d1, d2, scelta, roundTotali);
            } else {
                System.out.println("Opzione non valida.");
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
    }

    private static void giocaPartita(Gara gara, Giocatore g1, Giocatore g2, Dado d1, Dado d2, int scelta, int roundTotali) {
        int roundCorrente = 0;
        while (!gara.fineGara(roundCorrente, roundTotali)) {
            System.out.println("Round " + (roundCorrente + 1));
            gara.round(g1, g2, d1, d2, scelta);
            roundCorrente++;
        }

        System.out.println(g1.getNome() + ": " + g1.getVittorie() + " vittorie");
        System.out.println(g2.getNome() + ": " + g2.getVittorie() + " vittorie");
        System.out.println(gara.winner(g1, g2));
    }
}