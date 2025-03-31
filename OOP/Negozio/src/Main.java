import java.util.Scanner;
import static utility.Tools.Menu;

public class Main {
    public static void main(String[] args) {
        boolean esci = false;
        Scanner sc = new Scanner(System.in);
        NegozioElettronica negozio = new NegozioElettronica();
        String[] opzioni = {"MENU", "AGGIUNGI SMARTPHONE", "AGGIUNGI MANUALE", "VISUALIZZA PRODOTTI", "RIMUOVI PRODOTTO", "CERCA PRODOTTO", "ESCI"};

        do {
            switch (Menu(opzioni, sc)) {
                case 1 -> {
                    try{
                        inserisciSmartphone(negozio, sc);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try{
                        inserisciManuale(negozio, sc);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("PRODOTTI NEL NEGOZIO");
                    negozio.visualizzaProdotti();
                }
                case 4 -> {
                    System.out.println("Inserisci il codice prodotto da rimuovere:");
                    String codice = sc.nextLine();
                    if (negozio.rimuoviProdotto(codice)) {
                        System.out.println("Prodotto rimosso!");
                    } else {
                        System.out.println("Nessun prodotto trovato con codice: " + codice);
                    }
                }
                case 5 -> {
                    System.out.println("Inserisci il codice prodotto da cercare:");
                    String codice = sc.nextLine();
                    Prodotto prodotto = negozio.cercaProdotto(codice);
                    if (prodotto != null) {
                        System.out.println("Prodotto trovato: " + prodotto);
                    } else {
                        System.out.println("Prodotto non trovato.");
                    }
                }
                case 6 -> esci = true;
                default -> System.out.println("Opzione inserita non valida");
            }
        } while (!esci);
    }

    // Metodo per inserire uno Smartphone
    private static void inserisciSmartphone(NegozioElettronica negozio, Scanner sc) throws Exception {
        System.out.println("Inserisci il codice prodotto:");
        String codiceProdotto = sc.nextLine();
        System.out.println("Inserisci la marca:");
        String marca = sc.nextLine();
        System.out.println("Inserisci il prezzo:");
        double prezzo = Double.parseDouble(sc.nextLine());
        System.out.println("Inserisci il modello:");
        String modello = sc.nextLine();
        System.out.println("Inserisci la memoria (GB):");
        int memoria = Integer.parseInt(sc.nextLine());

        Smartphone smartphone = new Smartphone(codiceProdotto, marca, prezzo, modello, memoria);
        negozio.aggiungiProdotto(smartphone);
        System.out.println("Smartphone aggiunto!");
    }

    // Metodo per inserire un Manuale
    private static void inserisciManuale(NegozioElettronica negozio, Scanner sc) throws Exception {
        System.out.println("Inserisci il nome del manuale:");
        String nome = sc.nextLine();
        System.out.println("Inserisci la descrizione:");
        String descrizione = sc.nextLine();
        System.out.println("Inserisci l'autore:");
        String autore = sc.nextLine();
        System.out.println("Inserisci l'ISBN:");
        String isbn = sc.nextLine();
        System.out.println("Inserisci il prezzo:");
        double prezzo = Double.parseDouble(sc.nextLine());
        System.out.println("Inserisci la quantità:");
        int quantita = Integer.parseInt(sc.nextLine());
        System.out.println("Inserisci l'argomento:");
        String argomento = sc.nextLine();

        Manuale manuale = new Manuale(nome, descrizione, autore, isbn, prezzo, quantita, argomento);
        negozio.aggiungiProdotto(manuale);
        System.out.println("Manuale aggiunto!");
    }
}