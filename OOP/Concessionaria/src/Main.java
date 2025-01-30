import Utility.Tools;
import veicolo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria("VeicoloFast");
        boolean uscita = false;

        String[] opzioni = {"MENU", "INSERISCI VEICOLO", "VISUALIZZA VEICOLI", "RIMUOVI VEICOLO", "AGGIORNA VEICOLO", "ESCI"};

        while (!uscita) {
            try {
                Tools.clrScr(); // Pulisce la console prima di mostrare il menu
                int scelta = Tools.Menu(opzioni, sc);

                switch (scelta) {
                    case 1 -> inserisciVeicolo(concessionaria, sc); // Inserisci veicolo
                    case 2 -> concessionaria.stampaConcessionaria(); // Visualizza veicoli
                    case 3 -> rimuoviVeicolo(concessionaria, sc); // Rimuovi veicolo
                    case 4 -> aggiornaVeicolo(concessionaria, sc); // Aggiorna veicolo
                    case 5 -> uscita = true; // Esci
                    default -> System.out.println("Opzione non valida.");
                }

                if (!uscita) {
                    System.out.println("\nPremi Invio per continuare...");
                    sc.nextLine(); // Attende l'input dell'utente prima di continuare
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        System.out.println("Programma terminato.");
    }

    // Metodo per inserire un veicolo
    private static void inserisciVeicolo(Concessionaria concessionaria, Scanner sc) {
        Veicolo veicolo = concessionaria.leggiVeicolo(sc, true);
        if (veicolo != null) {
            try {
                concessionaria.addVeicolo(veicolo);
                System.out.println("Veicolo inserito correttamente.");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }

    // Metodo per rimuovere un veicolo
    private static void rimuoviVeicolo(Concessionaria concessionaria, Scanner sc) {
        Veicolo veicolo = concessionaria.leggiVeicolo(sc, false);
        if (veicolo != null) {
            try {
                concessionaria.removeVeicolo(veicolo);
                System.out.println("Veicolo rimosso correttamente.");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }

    // Metodo per aggiornare un veicolo
    private static void aggiornaVeicolo(Concessionaria concessionaria, Scanner sc) {
        Veicolo veicolo = concessionaria.leggiVeicolo(sc, false);
        if (veicolo != null) {
            Veicolo veicoloAggiornato = concessionaria.updateVeicolo(veicolo, sc);
            if (veicoloAggiornato != null) {
                System.out.println("Veicolo aggiornato correttamente.");
            } else {
                System.out.println("Aggiornamento fallito.");
            }
        }
    }
}
