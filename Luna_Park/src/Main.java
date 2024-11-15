import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static utility.Tools.*;
import Attributi.*;

public class Main {
    public static void main(String[] args) {
        boolean esci = false;
        int nBiglietto = 0;
        Scanner sc = new Scanner(System.in);
        final int MAXPERSONE = 10;
        ArrayList<Persona> gestore = new ArrayList<>(MAXPERSONE);
        String[] opzioni = {"GESTORE LUNAPARK", "1. Registra entrata", "2. Nuova giosta","3. Registra uscita + Tempo", "4. Mostra persone registrate", "5. Giostre usate" ,"6. Tempo di permanenza", "7. Esci"};

        do {
            try {
                switch (Menu(opzioni, sc)) {
                    case 1 -> {
                        if (gestore.size() < MAXPERSONE) {
                            gestore.add(registraEntrata(nBiglietto, sc));
                            System.out.println("Entrata registrata per il biglietto n° " + nBiglietto);
                            nBiglietto++;
                        } else {
                            throw new Exception("Il luna park è pieno.");
                        }
                    }
                    case 2 -> {
                        System.out.print("Inserisci il numero del biglietto per entrare in giostra: ");
                        int ticket = sc.nextInt();
                        if (ricerca(gestore, ticket) > -1) {
                            Persona p = nuovaGiostra(gestore, ticket, sc);
                            gestore.add(p);
                        }
                    }
                    case 3 -> {
                        if (gestore.isEmpty()) {
                            System.out.println("Nessun biglietto presente.");
                        } else {
                            System.out.print("Inserisci il numero del biglietto per registrare l'uscita: ");
                            int ticket = sc.nextInt();
                            System.out.print("Tempo di permanenza: ");
                            mostraTempoPermanenza(gestore, ticket);
                            if (registraUscita(gestore, ticket)) {
                                System.out.println("Uscita registrata");
                            } else {
                                System.out.println("Biglietto non trovato.");
                            }
                        }
                    }
                    case 4 -> {
                        if (!gestore.isEmpty()) {
                            mostraPersone(gestore);
                        }
                    }
                    case 5 -> {
                        System.out.println("Inserisci il ticket");
                        int ticket = sc.nextInt();
                        if (ricerca(gestore, ticket) > -1) {
                            VisualizzaGiostreUsate(gestore, ticket);
                        }
                    }
                    case 6 -> {
                        System.out.print("Inserisci il numero del biglietto per visualizzare il tempo di permanenza: ");
                        int ticket = sc.nextInt();
                        mostraTempoPermanenza(gestore, ticket);
                    }
                    case 7 -> esci = true;
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        } while (!esci);
    }

    public static Persona nuovaGiostra(ArrayList<Persona> gestore, int ticket, Scanner sc) {
        Persona cliente = new Persona();
        boolean esci = true;
        do {
            try {
                System.out.println("Quali giostre vuoi provare");
                String[] opzioni = {"Giostre", "1. RUOTAPANORAMICA", "2. AUTOSCONTRO", "3. OTTOVOLANTE", "4. TAGADA"};
                switch (Menu(opzioni, sc)) {
                    case 1 -> cliente.giostreProvate.add(Giostre.RUOTAPANORAMICA);
                    case 2 -> cliente.giostreProvate.add(Giostre.AUTOSCONTRO);
                    case 3 -> cliente.giostreProvate.add(Giostre.OTTOVOLANTE);
                    case 4 -> cliente.giostreProvate.add(Giostre.TAGADA);
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
                esci = false;
            }
        } while (!esci);
        cliente.biglietto = ticket;
        return cliente;
    }

    public static Persona registraEntrata(int nBiglietto, Scanner sc) {
        Persona cliente = new Persona();
        cliente.biglietto = nBiglietto;
        cliente.entrata = LocalDateTime.now();
        return cliente;
    }

    public static void VisualizzaGiostreUsate(ArrayList<Persona> gestore, int ticket) {
        Persona p = getPersonaByTicket(gestore, ticket);
        if (p != null) {
            p.giostreProvate.forEach(giostra -> System.out.println(giostra));
        } else {
            System.out.println("Biglietto non trovato.");
        }
    }

    public static boolean registraUscita(ArrayList<Persona> gestore, int nBiglietto) {
        return gestore.removeIf(persona -> persona.biglietto == nBiglietto);
    }

    public static int ricerca(ArrayList<Persona> gestore, int biglietto) {
        for (int i = 0; i < gestore.size(); i++) {
            if (gestore.get(i).biglietto == biglietto) {
                return i;
            }
        }
        return -1; // restituisce -1 se il biglietto non è trovato
    }

    public static void mostraPersone(ArrayList<Persona> gestore) {
        if (gestore.isEmpty()) {
            System.out.println("Nessuna persona registrata nel luna park.");
        } else {
            System.out.println("Persone attualmente registrate:");
            gestore.forEach(m -> System.out.println(m.toString()));
        }
    }

    public static void mostraTempoPermanenza(ArrayList<Persona> gestore, int ticket) {
        Persona p = getPersonaByTicket(gestore, ticket);
        if (p != null) {
            Duration permanenza = Duration.between(p.entrata, LocalDateTime.now());
            System.out.printf("Tempo di permanenza per il biglietto n° %d: %d ore, %d minuti, %d secondi.%n",
                    ticket, permanenza.toHours(), permanenza.toMinutesPart(), permanenza.toSecondsPart());
        } else {
            System.out.println("Biglietto non trovato.");
        }
    }

    public static Persona getPersonaByTicket(ArrayList<Persona> gestore, int ticket) {
        return gestore.stream().filter(p -> p.biglietto == ticket).findFirst().orElse(null);
    }
}