import Utility.Tools;
import veicolo.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria("VeicoloFast");
        boolean uscita = false;

        String[] opzioni = {"MENU", "INSERISCI VEICOLO", "VISUALIZZA VEICOLI", "RIMUOVI VEICOLO", "AGGIORNA VEICOLO",
                "MODIFICA PREZZO VEICOLO", "CERCA VEICOLI PER MARCA", "CERCA VEICOLI PER PREZZO", "ESCI"};

        while (!uscita) {
            try {
                Tools.clrScr();
                int scelta = Tools.Menu(opzioni, sc);

                switch (scelta) {
                    case 1 -> inserisciVeicolo(concessionaria, sc);
                    case 2 -> concessionaria.stampaConcessionaria();
                    case 3 -> rimuoviVeicolo(concessionaria, sc);
                    case 4 -> aggiornaVeicolo(concessionaria, sc);
                    case 5 -> modificaPrezzoVeicolo(concessionaria, sc);
                    case 6 -> cercaVeicoliPerMarca(concessionaria, sc);
                    case 7 -> cercaVeicoliPerPrezzo(concessionaria, sc);
                    case 8 -> uscita = true;
                    default -> System.out.println("Opzione non valida.");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        System.out.println("Programma terminato.");
    }

    // Metodo per modificare il prezzo di un veicolo
    private static void modificaPrezzoVeicolo(Concessionaria concessionaria, Scanner sc) {
        if (concessionaria.isVuota()) {
            System.out.println("Nessun veicolo disponibile.");
            return;
        }

        Veicolo veicolo = concessionaria.leggiVeicolo(sc, false);
        if (veicolo != null) {
            System.out.println("Inserisci il nuovo prezzo:");
            int nuovoPrezzo = Integer.parseInt(sc.nextLine());

            try {
                concessionaria.modificaPrezzoVeicolo(veicolo, nuovoPrezzo);
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }

    // Metodo per cercare veicoli per marca
    private static void cercaVeicoliPerMarca(Concessionaria concessionaria, Scanner sc) {
        System.out.println("Inserisci la marca da cercare:");
        String marca = sc.nextLine();

        concessionaria.getVeicoliByMarca(marca);
    }

    // Metodo per cercare veicoli con prezzo minore di un valore
    private static void cercaVeicoliPerPrezzo(Concessionaria concessionaria, Scanner sc) {
        System.out.println("Inserisci il prezzo massimo:");
        int prezzoMax = Integer.parseInt(sc.nextLine());

        concessionaria.getVeicoliByPrezzoMinore(prezzoMax);
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
        if (concessionaria.isVuota()) {
            System.out.println("Nessun veicolo disponibile.");
            return;
        }

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
        if (concessionaria.isVuota()) {
            System.out.println("Nessun veicolo disponibile.");
            return;
        }

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