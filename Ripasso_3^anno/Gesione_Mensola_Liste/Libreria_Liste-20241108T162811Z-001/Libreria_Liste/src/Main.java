import mensola.Libro;
import frontScreen.FrontEnd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utility.Tools.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        ArrayList<Libro> mensola = new ArrayList<>();

        boolean quit = false;
        int posizione;
        final int MAXNuMER = 3;

        String[] opzioni = {"Mensola", "1. Inserimento", "2. Leggi", "3. Cerca", "4. Rimuovi", "5. Cerca + Info", "6. Modifica Data Pubblicazione", "7. Find All", "8. Find All Autore", "9. Leggi data di pubblicazione", "10. Exit"};

        try {
            do {
                switch (Menu(opzioni, tastiera)) {
                    case 1:
                        try {
                            if(mensola.size() < MAXNuMER){
                                Libro nuovoLibro = FrontEnd.leggiLibro(tastiera, true, true);
                                /*posizione = FrontEnd.MetodoConEccezione(mensola, nuovoLibro);

                                if (posizione == -1) { // Aggiunta condizione
                                    mensola.add(nuovoLibro);
                                    System.out.println("Libro inserito con successo");
                                }*/
                                if (mensola.indexOf(nuovoLibro) == -1){
                                    mensola.add(nuovoLibro);
                                    System.out.println("Libro inserito con successo");
                                }
                                else{
                                    throw new Exception("Il libro è già presente");
                                }

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        if (!mensola.isEmpty()) {
                            mensola.forEach(l-> System.out.println(l.toString()));
                        } else {
                            System.out.println("Non ci sono libri da visualizzare nella mensola");
                        }
                        break;
                    case 3:
                        if (!mensola.isEmpty()) {

                            Libro cerca = FrontEnd.leggiLibro(tastiera, false, false);
                            posizione = mensola.indexOf(cerca);
                            if (posizione != -1) {
                                System.out.println("Il libro è presente alla posizione " + posizione);
                            } else {
                                System.out.println("Il libro non è presente");
                            }
                        } else {
                            System.out.println("Non ci sono libri nella mensola");
                        }
                        break;
                    case 4:
                        if (!mensola.isEmpty()) {
                            Libro rimuovi = FrontEnd.leggiLibro(tastiera, false, false);
                            if(FrontEnd.rimuovi(mensola,rimuovi)){
                                System.out.println("Libro rimosso con successo");
                            }
                            else{
                                System.out.println("Il libro non è presente");
                            }
                        } else {
                            System.out.println("Non ci sono libri da rimuovere");
                        }
                        break;
                    case 5:
                        if (!mensola.isEmpty()) {
                            Libro nuovo = new Libro();
                            System.out.println("Inserisci il titolo:");
                            nuovo.Titolo = tastiera.nextLine();
                            posizione = FrontEnd.findIndex(mensola, nuovo);
                            if (posizione != -1) {
                                System.out.println(mensola.get(posizione).toString());
                            } else {
                                System.out.println("Il libro non è presente");
                            }
                        }
                        break;
                    case 6:
                        if (!mensola.isEmpty()) {
                            Libro data = FrontEnd.leggiLibro(tastiera, false, false);
                            posizione = mensola.indexOf(data);
                            if (posizione != -1) {
                                FrontEnd.modificaDataPubblicazione(mensola, posizione, tastiera);
                                System.out.println("Data di pubblicazione modificata con successo.");
                            } else {
                                System.out.println("Libro non trovato");
                            }
                        } else {
                            System.out.println("Non ci sono libri nella mensola");
                        }
                        break;
                    case 7:
                        if (!mensola.isEmpty()) {
                            System.out.println("Inserisci il titolo:");
                            Libro nuovo = new Libro();
                            nuovo.Titolo = tastiera.nextLine();
                            List<Libro> trovati = FrontEnd.findAll(mensola, nuovo);
                            if (!trovati.isEmpty()) {
                                mensola.forEach(l-> System.out.println(l.toString()));
                            } else {
                                System.out.println("Il libro non è presente");
                            }
                        }
                        break;
                    case 8:
                        if (!mensola.isEmpty()) {
                            System.out.println("Inserisci l'autore:");
                            Libro autore = new Libro();
                            autore.Autore = tastiera.nextLine();
                            List<Libro> autori = FrontEnd.Autore(mensola, autore);
                            if (!autori.isEmpty()) {
                                mensola.forEach(l-> System.out.println(l.toString()));
                            } else {
                                System.out.println("Autore non trovato");
                            }
                        }
                        break;
                    case 9:
                        if(!mensola.isEmpty()){
                            System.out.println("Inserisci data di pubblicazione");
                            LocalDateTime data = LocalDateTime.parse(tastiera.nextLine());

                        }
                    case 10:
                        System.out.println("Exit");
                        quit = true;
                        break;
                    default:
                        System.out.println("Opzione non valida");
                }
            } while (!quit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Totale: " + mensola.size() + " libri");
    }
}