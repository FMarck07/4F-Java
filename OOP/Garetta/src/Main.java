import java.util.ArrayList;
import java.util.Scanner;

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
                case 1:
                    try {
                        Pilota p = FrontEnd.leggiPilota(sc);
                        if (piloti.contains(p)) {
                            System.out.println("Pilota già esistente.");
                        } else {
                            piloti.add(p);
                            System.out.println("Pilota inserito: " + p);
                        }
                    } catch (Exception e) {
                        System.out.println("Errore durante l'inserimento del pilota: " + e.getMessage());
                    }
                    break;

                case 2:
                    boolean finito = false;
                    while (!finito) {
                        try {
                            if (piloti.size() > 0) {
                                System.out.println("Seleziona un pilota per la scuderia:");

                                for (Pilota p : piloti) {
                                    System.out.println("- " + p.getNome() + " " + p.getCognome());
                                }

                                System.out.println("Inserisci il nome del pilota:");
                                String nomePilota = sc.nextLine();

                                System.out.println("Inserisci il cognome del pilota:");
                                String cognomePilota = sc.nextLine();

                                Pilota pilotaSelezionato = null;
                                boolean pilotaTrovato = false;

                                for (Pilota p : piloti) {
                                    if (p.getNome().equalsIgnoreCase(nomePilota) && p.getCognome().equalsIgnoreCase(cognomePilota)) {
                                        pilotaSelezionato = p;
                                        pilotaTrovato = true;
                                    }
                                }

                                if (!pilotaTrovato) {
                                    System.out.println("Pilota non trovato. Reinserisci");
                                } else {
                                    boolean pilotaAssegnato = false;
                                    for (Scuderia s : scuderie) {
                                        if (s.getnPilota().equals(pilotaSelezionato)) {
                                            pilotaAssegnato = true;
                                        }
                                    }

                                    if (pilotaAssegnato) {
                                        System.out.println("Il pilota è già assegnato a una scuderia.");
                                    } else {
                                        System.out.println("Inserisci il nome della scuderia:");
                                        String nomeScuderia = sc.nextLine();

                                        boolean scuderiaEsistente = false;

                                        for (Scuderia s : scuderie) {
                                            if (s.getNome().equalsIgnoreCase(nomeScuderia)) {
                                                scuderiaEsistente = true;
                                            }
                                        }

                                        if (scuderiaEsistente) {
                                            System.out.println("Scuderia già esistente.");
                                        } else {
                                            System.out.println("Inserisci il numero dell'auto: ");
                                            int nAuto = Integer.parseInt(sc.nextLine());
                                            System.out.println("Comincia il Giro:");
                                            Cronometro cr = FrontEnd.inserisciCronometro();
                                            Scuderia scuderia = new Scuderia(nomeScuderia, pilotaSelezionato, nAuto);
                                            scuderia.setTempoGiro(cr);
                                            scuderie.add(scuderia);
                                            System.out.println("Scuderia aggiunta: " + scuderia);
                                            finito = true;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Devi prima aggiungere almeno un pilota.");
                                finito = true;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3:
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

                            System.out.println("Tempi di tutte le scuderie:");
                            for (Scuderia scuderia : gara.getGriglia()) {
                                System.out.println(scuderia.getNome() + "- " + scuderia.getnPilota().getNome() + " " + scuderia.getnPilota().getCognome() + ": " + scuderia.getTempoGiro().getTempoGiro() + " secondi");
                            }
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
