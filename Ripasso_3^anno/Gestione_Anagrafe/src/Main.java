import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        int persone = 0;
        final int MAX = 3;
        ArrayList<Persona> lista = new ArrayList<>(MAX);
        boolean esci = true;
        Scanner sc = new Scanner(System.in);
        String[] opzioni = {"Anagrafe", "1. Inserisci dati anagrafici", "2. Visualizza", "3. Modifica data di nascita", "4. Rimuovi", "5. Visualizza tutte le persone con nome uguale", "6. Duration", "7. Exit"};

        do {
            try {
                switch (Menu(opzioni, sc)) {
                    case 1 -> {
                        try {
                            if (MAX > persone) {
                                Persona p = InserisciPersona(sc, true);
                                if (ricerca(lista, p) == -1) {
                                    lista.add(p);
                                    persone++;
                                } else {
                                    System.out.println("Persona già esistente.");
                                }
                            } else {
                                System.out.println("Limite massimo di persone raggiunto.");
                            }
                        } catch (Exception e) {
                            System.out.println("Errore nell'inserimento della persona: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            if (!lista.isEmpty()) {
                                lista.forEach(p -> System.out.println(p.toString()));
                            } else {
                                throw new Exception("Lista vuota.");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("Inserisci nome e cognome della persona di cui vuoi cambiare la data di nascita:");
                            Persona p = InserisciPersona(sc, false);
                            int index = ricerca(lista, p);
                            if (index != -1) {
                                lista.get(index).data = ModificaDataNascita(sc);
                            } else {
                                System.out.println("Persona non trovata");
                            }
                        } catch (Exception e) {
                            System.out.println("Errore durante la modifica della data di nascita: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            System.out.println("Inserisci nome e cognome della persona da rimuovere:");
                            Persona p = InserisciPersona(sc, false);
                            if (lista.removeIf(l -> l.nome.equals(p.nome) && l.cognome.equals(p.cognome))) {
                                persone--;
                                System.out.println("Persona rimossa con successo");
                            } else {
                                System.out.println("Persona non trovata");
                            }
                        } catch (Exception e) {
                            System.out.println("Errore durante la rimozione della persona: " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        try {
                            if (!lista.isEmpty()) {
                                System.out.println("Inserisci nome:");
                                Persona p = new Persona();
                                p.nome = sc.nextLine();
                                ArrayList<Persona> trovati = FindName(lista, p);
                                if (trovati.isEmpty()) {
                                    System.out.println("Nessuna persona trovata con il nome specificato.");
                                } else {
                                    trovati.forEach(l->System.out.println(l.toString()));
                                }
                            } else {
                                throw new Exception("Lista vuota.");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 6->{
                        Persona p = new Persona();
                        System.out.println("Inserisci nome");
                        p.nome = sc.nextLine();
                        System.out.println("Inserisci cognome");
                        p.cognome = sc.nextLine();
                        int index = ricerca(lista, p);
                        if(index != -1) {
                            durata(lista, p);
                        }
                    }
                    case 7 -> esci = false;

                    default -> System.out.println("Opzione non valida, riprova.");
                }
            } catch (Exception e) {
                System.out.println("Errore generale: " + e.getMessage());
            }
        } while (esci);
    }

    public static Persona InserisciPersona(Scanner sc, boolean chiediData) {
        Persona p = new Persona();
        p.entrata = LocalDateTime.now();
        System.out.println("Inserisci nome: ");
        p.nome = sc.nextLine();
        System.out.println("Inserisci cognome: ");
        p.cognome = sc.nextLine();

        if (chiediData) {
            boolean dataValida = false;
            do {
                try {
                    System.out.println("Inserisci data di nascita (formato: dd-MM-yyyy): ");
                    p.data = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    dataValida = true;
                } catch (Exception e) {
                    System.out.println("Formato data non valido. Riprova.");
                }
            } while (!dataValida);
        }

        return p;
    }

    public static int ricerca(ArrayList<Persona> lista, Persona p) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).nome.equals(p.nome) && lista.get(i).cognome.equals(p.cognome)) {
                return i;
            }
        }
        return -1;
    }

    public static LocalDate ModificaDataNascita(Scanner sc) {
        LocalDate data = null;
        boolean dataValida = false;

        do {
            try {
                System.out.println("Inserisci la nuova data di nascita (formato: dd-MM-yyyy): ");
                data = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                dataValida = true;
            } catch (Exception e) {
                System.out.println("Formato data non valido. Riprova.");
            }
        } while (!dataValida);

        return data;
    }

    public static ArrayList<Persona> FindName(ArrayList<Persona> lista, Persona p) {
        ArrayList<Persona> trovati = new ArrayList<>();
        for (Persona p1 : lista) {
            if (p1.nome.equalsIgnoreCase(p.nome)) {
                trovati.add(p1);
            }
        }
        return trovati;
    }
    public static Duration durata(ArrayList<Persona> lista, Persona p) {
        LocalDateTime entrataDataTime  = p.entrata;
        Duration durata = Duration.between(entrataDataTime , LocalDateTime.now());

        System.out.println("Permanenza: giorni"+ durata.toDays() +" ore:  "+durata.toHoursPart()+ " minuti: "+ durata.toMinutesPart()+ " secondi: "+durata.toSecondsPart());
        return durata;
    }

}
