import Utility.Tools;
import veicolo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    private ArrayList<Veicolo> veicoli = new ArrayList<>();
    private String nome;

    public Concessionaria(String nome) {
        this.nome = nome;
    }

    // Verifica se la lista dei veicoli è vuota
    public boolean isVuota() {
        return veicoli.isEmpty();
    }

    // Aggiunge un veicolo alla lista
    public void addVeicolo(Veicolo veicolo) throws Exception {
        if (veicoli.contains(veicolo)) {
            throw new Exception("Veicolo già presente.");
        }
        veicoli.add(veicolo);
    }

    // Rimuove un veicolo dalla lista
    public void removeVeicolo(Veicolo veicolo) throws Exception {
        if (isVuota()) {
            throw new Exception("Nessun veicolo disponibile.");
        }

        if (!veicoli.contains(veicolo)) {
            throw new Exception("Veicolo non trovato.");
        }
        veicoli.remove(veicolo);
    }

    // Stampa tutti i veicoli
    public void stampaConcessionaria() {
        if (veicoli.isEmpty()) {
            System.out.println("Nessun veicolo disponibile.");
        } else {
            for (Veicolo v : veicoli) {
                System.out.println(v);
            }
        }
    }

    // Legge i dati di un veicolo da input
    public Veicolo leggiVeicolo(Scanner sc, boolean nuovoVeicolo) {
        System.out.println("Inserisci la marca:");
        String marca = sc.nextLine();
        System.out.println("Inserisci il modello:");
        String modello = sc.nextLine();

        if (nuovoVeicolo) {
            int prezzo = leggiPrezzo(sc);

            String[] opzioni = {"OPZIONI", "AUTOMOBILE", "MOTO"};
            System.out.println("Scegli il tipo di veicolo:");
            int scelta = Tools.Menu(opzioni, sc);

            if (scelta == 1) {
                return creaAutomobile(sc, marca, modello, prezzo);
            } else if (scelta == 2) {
                return creaMoto(sc, marca, modello, prezzo);
            }
        } else {
            return getVeicoloByMarcaModello(marca, modello);
        }

        return null;
    }

    // Metodo per leggere il prezzo con validazione
    private int leggiPrezzo(Scanner sc) {
        int prezzo;
        while (true) {
            try {
                System.out.println("Inserisci il prezzo:");
                prezzo = Integer.parseInt(sc.nextLine());
                if (prezzo >= 0) break;
                System.out.println("Il prezzo deve essere un numero positivo.");
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero.");
            }
        }
        return prezzo;
    }

    // Crea un'automobile
    private Veicolo creaAutomobile(Scanner sc, String marca, String modello, int prezzo) {
        System.out.println("Inserisci il numero di porte:");
        int numeroPorte = Integer.parseInt(sc.nextLine());
        return new Automobile(marca, modello, prezzo, numeroPorte);
    }

    // Crea una moto
    private Veicolo creaMoto(Scanner sc, String marca, String modello, int prezzo) {
        System.out.println("Inserisci la cilindrata:");
        int cilindrata = Integer.parseInt(sc.nextLine());
        return new Moto(marca, modello, prezzo, cilindrata);
    }

    // Trova un veicolo per marca e modello
    public Veicolo getVeicoloByMarcaModello(String marca, String modello) {
        if (isVuota()) {
            System.out.println("Nessun veicolo disponibile.");
            return null;
        }

        for (Veicolo v : veicoli) {
            if (v.getMarca().equals(marca) && v.getModello().equals(modello)) {
                return v;
            }
        }
        System.out.println("Veicolo non trovato.");
        return null;
    }

    // Aggiorna un veicolo esistente
    public Veicolo updateVeicolo(Veicolo veicolo, Scanner sc) {
        if (isVuota()) {
            System.out.println("Nessun veicolo disponibile.");
            return null;
        }

        if (veicolo == null) {
            System.out.println("Veicolo non valido.");
            return null;
        }

        String terzaOpzione = (veicolo instanceof Automobile) ? "NUMERO DI PORTE" : "CILINDRATA";
        String[] opzioni = {"OPZIONI", "MODELLO", "PREZZO", terzaOpzione};
        System.out.println("Cosa vuoi aggiornare?");
        int scelta = Tools.Menu(opzioni, sc);

        switch (scelta) {
            case 1 -> {
                System.out.println("Inserisci il nuovo modello:");
                veicolo.setModello(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Inserisci il nuovo prezzo:");
                veicolo.setPrezzo(Integer.parseInt(sc.nextLine()));
            }
            case 3 -> {
                if (veicolo instanceof Automobile) {
                    System.out.println("Inserisci il nuovo numero di porte:");
                    ((Automobile) veicolo).setNumeroPorte(Integer.parseInt(sc.nextLine()));
                } else if (veicolo instanceof Moto) {
                    System.out.println("Inserisci la nuova cilindrata:");
                    ((Moto) veicolo).setCilindrata(Integer.parseInt(sc.nextLine()));
                }
            }
            default -> System.out.println("Opzione non valida.");
        }

        return veicolo;
    }
}