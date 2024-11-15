package frontScreen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;

import mensola.Libro;
import mensola.Genere;

import static utility.Tools.Menu;
import java.util.ArrayList;
import java.util.List;

public class FrontEnd {

    public static Libro leggiLibro(Scanner tastiera, boolean si, boolean data) {
        Libro l = new Libro();
        System.out.println("Inserisci autore:");
        l.Autore = tastiera.nextLine();
        System.out.println("Inserisci titolo:");
        l.Titolo = tastiera.nextLine();

        if (si) {
            System.out.println("Inserisci il tipo:");
            String[] opzioni = {"Tipo libro", "1 Romanzo", "2 Manuale", "3 Thriller"};
            switch (Menu(opzioni, tastiera)) {
                case 1 -> l.tipo = Genere.Romanzo;
                case 2 -> l.tipo = Genere.Manuale;
                case 3 -> l.tipo = Genere.Thriller;
            }
        }

        if (data) {
            System.out.println("Inserisci la data di pubblicazione in formato dd-MM-yyyy:");
            try {
                l.dataDiPubblicazione = LocalDate.parse(tastiera.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return l;
    }
    // Mandiamo eccezione nel metodo ma dacendo così poi non riesco a getisre anche l'indice
    /*
    public static int contieneLibro(ArrayList<Libro> mensola, Libro nuovoLibro){
        for (int i = 0; i < mensola.size(); i++) {
            if (mensola.get(i).Titolo.equals(nuovoLibro.Titolo) && mensola.get(i).Autore.equals(nuovoLibro.Autore)) {
                return i;
            }
        }
        return -1;
    }*/

    public static int MetodoConEccezione(ArrayList<Libro> mensola, Libro nuovoLibro) throws Exception{
        for (int i = 0; i < mensola.size(); i++) {
            if (mensola.get(i).Titolo.equals(nuovoLibro.Titolo) && mensola.get(i).Autore.equals(nuovoLibro.Autore)) {
                throw new Exception("Libro già presente");
            }
        }
        return -1;
    }

    public static int ricerca(ArrayList<Libro> mensola, Libro cerca) {
        return mensola.indexOf(cerca);
    }
    // Due metodi per rimuovere
    public static boolean rimuovi(ArrayList<Libro> mensola, Libro rimuovi){
        return mensola.removeIf(L -> mensola.contains(rimuovi));
    }

    public static int findIndex(ArrayList<Libro> mensola, Libro cerca) {
        for (int i = 0; i < mensola.size(); i++) {
            if (mensola.get(i).Titolo.equals(cerca.Titolo)) {
                return i;
            }
        }
        return -1;
    }

    public static void modificaDataPubblicazione(ArrayList<Libro> mensola, int index, Scanner tastiera) {
        System.out.println("Inserisci la nuova data di pubblicazione (dd-MM-yyyy):");
        try {
            mensola.get(index).dataDiPubblicazione = LocalDate.parse(tastiera.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            System.out.println("Errore nella modifica della data: " + e.getMessage());
        }
    }



    public static List<Libro> findAll(ArrayList<Libro> mensola, Libro cerca) {
        List<Libro> copia = new ArrayList<>();
        for (Libro libro : mensola) {
            if (libro.Titolo.equals(cerca.Titolo)) {
                copia.add(libro);
            }
        }
        return copia;
    }

    public static List<Libro> Autore(ArrayList<Libro> mensola, Libro cerca) {
        List<Libro> copia2 = new ArrayList<>();
        for (Libro libro : mensola) {
            if (libro.Autore.equals(cerca.Autore)) {
                copia2.add(libro);
            }
        }
        return copia2;
    }

    public static void Ordine(ArrayList<Libro> mensola) {
        mensola.sort((libro1, libro2) -> libro1.Titolo.compareTo(libro2.Titolo));
    }

    // Metodi aggiuntivi per richieste specifiche:
    public static int contaPerGenere(ArrayList<Libro> mensola, Genere genere) {
        int count = 0;
        for (Libro libro : mensola) {
            if (libro.tipo == genere) {
                count++;
            }
        }
        return count;
    }

    public static void ordinaPerDataPubblicazione(ArrayList<Libro> mensola) {
        mensola.sort((libro1, libro2) -> libro1.dataDiPubblicazione.compareTo(libro2.dataDiPubblicazione));
    }

    public static void modificaAutore(List<Libro> mensola, int index, String nuovoAutore) {
        mensola.get(index).Autore = nuovoAutore;
    }

    public static List<Libro> ricercaParzialeTitolo(ArrayList<Libro> mensola, String sequenza) {
        List<Libro> risultati = new ArrayList<>();
        for (Libro libro : mensola) {
            if (libro.Titolo.contains(sequenza)) {
                risultati.add(libro);
            }
        }
        return risultati;
    }
    public static ArrayList<Libro> data(ArrayList<Libro> mensola, LocalDate date) {
        ArrayList<Libro> data = new ArrayList<>();
        for(int i = 0; i<mensola.size(); i++) {
            if(mensola.get(i).dataDiPubblicazione.compareTo(date) > 0) {
                data.add(mensola.get(i));
            }
        }
        return data;
    }

}