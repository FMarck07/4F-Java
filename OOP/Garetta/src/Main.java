import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] opzioni = {"Gara", "Inserimento Pilota", "Inserimento Scuderia", "Comincia la Gara"};
        boolean esci = false;
        ArrayList<Pilota> piloti = new ArrayList<>();
        ArrayList<Scuderia> scuderie = new ArrayList<>();
        Gara gara = null;

        while (!esci) {
            int scelta = Menu(opzioni, sc);
            switch (scelta) {
                case 1: // Inserimento Pilota
                    try {
                        Pilota p = FrontEnd.leggiPilota(sc);
                        if (piloti.contains(p)) {
                            System.out.println("Errore: Pilota già esistente.");
                        } else {
                            piloti.add(p);
                            System.out.println("Pilota inserito: " + p);
                        }
                    } catch (Exception e) {
                        System.out.println("Errore durante l'inserimento del pilota: " + e.getMessage());
                    }
                    break;

                case 2: // Inserimento Scuderia
                    boolean inserimentoCompletato = false;
                    while (!inserimentoCompletato) {
                        try {
                            if (piloti.size() > 0) {
                                System.out.println("Seleziona un pilota per la scuderia:");
                                for (int i = 0; i < piloti.size(); i++) {
                                    System.out.println("[" + (i + 1) + "] " + piloti.get(i));
                                }

                                int pilotaIndex = -1;
                                while (pilotaIndex < 0 || pilotaIndex >= piloti.size()) {
                                    try {
                                        System.out.print("Inserisci il numero del pilota: ");
                                        pilotaIndex = Integer.parseInt(sc.nextLine()) - 1;
                                        if (pilotaIndex < 0 || pilotaIndex >= piloti.size()) {
                                            System.out.println("Numero pilota non valido. Riprova.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Input non valido. Inserisci un numero valido.");
                                    }
                                }

                                Pilota pilota = piloti.get(pilotaIndex);
                                boolean pilotaAssegnato = false;
                                for (Scuderia s : scuderie) {
                                    if (s.getnPilota().equals(pilota)) {
                                        pilotaAssegnato = true;
                                        break;
                                    }
                                }

                                if (pilotaAssegnato) {
                                    System.out.println("Errore: Il pilota è già assegnato a una scuderia.");
                                } else {
                                    System.out.println("Inserisci il nome della scuderia:");
                                    String nomeScuderia = sc.nextLine();

                                    boolean scuderiaEsistente = false;
                                    for (Scuderia s : scuderie) {
                                        if (s.getNome().equalsIgnoreCase(nomeScuderia)) {
                                            scuderiaEsistente = true;
                                            break;
                                        }
                                    }

                                    if (scuderiaEsistente) {
                                        System.out.println("Errore: Scuderia già esistente.");
                                    } else {
                                        System.out.println("Inserisci il numero dell'auto: ");
                                        int nAuto = Integer.parseInt(sc.nextLine());
                                        Cronometro cr = FrontEnd.InserisciCronometro();
                                        Scuderia scuderia = new Scuderia(nomeScuderia, pilota, nAuto);
                                        scuderia.setTempoGiro(cr);
                                        scuderie.add(scuderia);
                                        System.out.println("Scuderia aggiunta: " + scuderia);
                                        inserimentoCompletato = true;
                                    }
                                }
                            } else {
                                System.out.println("Devi prima aggiungere almeno un pilota.");
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3: // Comincia Gara
                    if (scuderie.size() > 0) {
                        try {
                            gara = new Gara("Gara Principale");
                            for (Scuderia scuderia : scuderie) {
                                gara.aggiungiElemento(scuderia);
                            }

                            gara.ordinaGara();
                            System.out.println("Risultati della Gara:");
                            gara.getGriglia().forEach(System.out::println);
                            System.out.println("Il vincitore è: " + gara.getVincitore());
                            System.out.println("Tempo totale impiegato dal vincitore: " + gara.getGriglia().get(0).getTempoGiro().getTempoGiro() + " secondi");
                            gara.getGriglia().forEach(System.out::println);
                        } catch (Exception e) {
                            System.out.println("Errore durante l'ordinamento della gara: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Devi aggiungere almeno una scuderia.");
                    }
                    break;

                default:
                    esci = true;
                    break;
            }
        }
    }
}