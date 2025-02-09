package utility;
import BackEnd.*;

import java.util.ArrayList;
import java.util.Scanner;



import java.io.File;
import java.util.Scanner;

public class Tools {
    private Tools() {} // Impedisce di instanziare la classe

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int Menu(String[] opzioni, Scanner tastiera) {
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "] " + opzioni[i]);
            }
            scelta = Integer.parseInt(tastiera.nextLine());
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Opzione sbagliata");
                Wait(2000);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);
        return scelta;
    }

    // Metodo per selezionare un file
    public static String selezionaFile(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("La directory specificata non esiste o non è valida.");
            return null;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Non ci sono file nella directory.");
            return null;
        }

        System.out.println("Seleziona un file:");
        for (int i = 0; i < files.length; i++) {
            System.out.println("[" + (i + 1) + "] " + files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int scelta = -1;
        while (scelta < 1 || scelta > files.length) {
            try {
                System.out.print("Inserisci il numero del file: ");
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Riprova.");
            }
        }

        return files[scelta - 1].getAbsolutePath();
    }

    public static Libro leggiLibro(Scanner tastiera, boolean opzioni) {
        System.out.println("Seleziona il tipo di libro:");
        System.out.println("[1] Manuale");
        System.out.println("[2] Romanzo");
        System.out.println("[3] Thriller");
        int tipo = Integer.parseInt(tastiera.nextLine());

        System.out.println("Inserisci l'autore del libro");
        String autore = tastiera.nextLine();
        System.out.println("Inserisci il titolo del libro");
        String titolo = tastiera.nextLine();
        System.out.println("Inserisci il numero pagine del libro");

        int nPagine = -1;
        while (nPagine < 1) {
            try {
                String input = tastiera.nextLine();
                nPagine = Integer.parseInt(input);
                if (nPagine < 1) {
                    System.out.println("Il numero di pagine deve essere maggiore di 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero valido per le pagine.");
            }
        }

        switch (tipo) {
            case 1:
                System.out.println("Inserisci l'argomento del manuale:");
                String argomento = tastiera.nextLine();
                System.out.println("Seleziona il livello del manuale:");
                System.out.println("[1] Base");
                System.out.println("[2] Principiante");
                System.out.println("[3] Esperto");
                int livelloScelta = Integer.parseInt(tastiera.nextLine());
                Manuale.Livello livello = Manuale.Livello.values()[livelloScelta - 1];
                return new Manuale(autore, titolo, nPagine, argomento, livello);
            case 2:
                System.out.println("Inserisci il genere letterario del romanzo:");
                String genereLetterario = tastiera.nextLine();
                return new Romanzo(autore, titolo, nPagine, genereLetterario);
            case 3:
                System.out.println("Il thriller è derivato da una serie TV? (s/n)");
                boolean derivatoDaSerieTV = tastiera.nextLine().equalsIgnoreCase("s");
                return new Thriller(autore, titolo, nPagine, derivatoDaSerieTV);
            default:
                throw new IllegalArgumentException("Tipo di libro non valido.");
        }
    }
    public void visualizzaMensola(ArrayList<Libro> volumi){
        for(Libro l : volumi){
            clrScr();
            l.toString();
        }
    }
}
