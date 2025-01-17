import BackEnd.Libro;
import BackEnd.Mensola;
import utility.Tools;

import java.util.Scanner;

import static utility.Tools.leggiLibro;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Mensola libreria = new Mensola(0);
        String filePath = "libreria.json";
        String[] opzioni = {"BIBLIOTECA", "Inserimento", "Visualizzazione", "Ricerca", "Cancellazione", "Salva", "Carica", "Seleziona File", "Fine"};

        boolean esci = false;
        do {
            switch (Tools.Menu(opzioni, tastiera)) {
                case 1: // Inserimento
                    try {
                        if (!libreria.checkSpace()) {
                            Libro libro = leggiLibro(tastiera, false);
                            libreria.addLibro(libro);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2: // Visualizzazione
                    libreria.getVolumi().forEach(System.out::println);
                    break;
                case 3: // Ricerca
                    System.out.println("Inserisci l'autore del libro:");
                    String autore = tastiera.nextLine();
                    System.out.println("Inserisci il titolo del libro:");
                    String titolo = tastiera.nextLine();
                    Libro trovato = libreria.cercaLibro(autore, titolo);
                    if (trovato != null) {
                        System.out.println("Libro trovato: " + trovato);
                    } else {
                        System.out.println("Libro non trovato.");
                    }
                    break;
                case 4: // Cancellazione
                    System.out.println("Inserisci l'autore del libro:");
                    autore = tastiera.nextLine();
                    System.out.println("Inserisci il titolo del libro:");
                    titolo = tastiera.nextLine();
                    Libro daCancellare = libreria.cercaLibro(autore, titolo);
                    if (daCancellare != null && libreria.rimuoviLibro(daCancellare)) {
                        System.out.println("Libro rimosso con successo.");
                    } else {
                        System.out.println("Libro non trovato o errore nella rimozione.");
                    }
                    break;
                case 5: // Salva
                    try {
                        libreria.salvaSuFile(filePath);
                        System.out.println("Dati salvati su file.");
                    } catch (Exception e) {
                        System.out.println("Errore durante il salvataggio: " + e.getMessage());
                    }
                    break;
                case 6: // Carica
                    try {
                        libreria.caricaDaFile(filePath);
                        System.out.println("Dati caricati dal file.");
                    } catch (Exception e) {
                        System.out.println("Errore durante il caricamento: " + e.getMessage());
                    }
                    break;
                case 7: // Seleziona File
                    String selectedFile = Tools.selezionaFile(".");
                    if (selectedFile != null) {
                        System.out.println("Hai selezionato: " + selectedFile);
                        filePath = selectedFile;
                    }
                    break;
                case 8: // Fine
                    esci = true;
                    break;
            }
        } while (!esci);
    }
}
