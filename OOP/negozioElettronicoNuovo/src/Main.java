import java.util.ArrayList;
import java.util.Scanner;
import static utility.Tools.*;

/**
 * @author Francesco Marchetto
 * @version 1.0
 * @since 31/03/2025
 */


public class Main {
    /**
     * Metodo principale che avvia il programma.
     * Gestisce il menu di interazione e i vari comandi disponibili per l'utente.
     *
     * @param args Argomenti della linea di comando (non utilizzati).
     */
    public static void main(String[] args) {
        String[] opzioni = {
                "NEGOZIO ELETTRONICA",
                "Inserisci smartphone",
                "Inserisci manuale",
                "Cerca prodotto",
                "Modifica prezzo",
                "Modifica quantità",
                "Rimuovi prodotto",
                "Visualizza prodotti",
                "Esci"
        };

        Scanner sc = new Scanner(System.in);
        int scelta;

        do {
            scelta = Menu(opzioni, sc);
            try {
                switch (scelta) {
                    case 1:
                        Prodotto p = FrontEnd.inserimentoSmartphone(sc);
                        System.out.println("Inserito: " + p);
                        break;
                    case 2:
                        Prodotto m = FrontEnd.inserimentoManuale(sc);
                        System.out.println("Inserito: " + m);
                        break;
                    case 3:
                        System.out.print("Inserisci codice: ");
                        int codice = Integer.parseInt(sc.nextLine());
                        Prodotto trovato = FrontEnd.ricercaProdotto(codice);
                        if(trovato != null) {
                            System.out.println("Prodotto cercato: " + trovato);
                        }
                        break;
                    case 4:
                        System.out.print("Inserisci codice: ");
                        int codPrezzo = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuovo prezzo: ");
                        double nuovoPrezzo = Double.parseDouble(sc.nextLine());
                        FrontEnd.modificaPrezzo(codPrezzo, nuovoPrezzo);
                        System.out.println("Prezzo modificato");
                        break;
                    case 5:
                        System.out.print("Inserisci codice: ");
                        int codQuant = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuova quantità: ");
                        int nuovaQuant = Integer.parseInt(sc.nextLine());
                        FrontEnd.modificaQuantita(codQuant, nuovaQuant);
                        System.out.println("Quantità modificata");
                        break;
                    case 6:
                        System.out.print("Inserisci codice: ");
                        int codRimuovi = Integer.parseInt(sc.nextLine());
                        boolean rimosso = FrontEnd.rimuoviProdotto(codRimuovi);
                        if(rimosso){
                            System.out.println("Rimosso con successo");
                        }else{
                            System.out.println("Prodotto non trovato");
                        }
                        break;
                    case 7:
                        try {
                            ArrayList<Prodotto> prodotti = FrontEnd.visualizzaProdotti();
                            for (Prodotto p1 : prodotti) {
                                System.out.println(p1);
                            }
                        } catch (CloneNotSupportedException e) {
                            System.out.println("Errore durante la visualizzazione: " + e.getMessage());
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
            if (scelta != 8) {
                System.out.println("Premi invio per continuare...");
                sc.nextLine();
            }
        } while (scelta != 8);
        sc.close();
    }
}