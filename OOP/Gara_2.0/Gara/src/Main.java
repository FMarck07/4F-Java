import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] opzioni = {"Gara Clandestina", "Inserimento Pilota", "Inserimento Scuderia", "Comincia la Gara"};
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
                        piloti.add(p);
                        System.out.println("Pilota inserito: " + p);
                    } catch (Exception e) {
                        System.out.println("Errore durante l'inserimento del pilota: " + e.getMessage());
                    }
                    break;
                case 2: // Inserimento scuderia
                    try{
                        if (piloti.size() > 0) {
                            System.out.println("Seleziona un pilota per la scuderia:");
                            for (int i = 0; i < piloti.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + piloti.get(i));
                            }

                            // Input validation for pilot selection
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

                            System.out.println("Inserisci il nome della scuderia:");
                            String nomeScuderia = sc.nextLine();
                            System.out.println("Inserisci il numero dell'auto: ");
                            int nAuto = Integer.parseInt(sc.nextLine());
                            Cronometro cr = FrontEnd.InserisciCronometro();
                            Scuderia scuderia = new Scuderia(nomeScuderia, pilota, nAuto);
                            scuderie.add(scuderia);

                            System.out.println("Scuderia aggiunta: " + scuderia);
                        } else {
                            System.out.println("Devi prima aggiungere almeno un pilota.");
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // Comincia gara
                    if (scuderie.size() > 0) {
                        try {
                            gara = new Gara("Gara Principale", new Pilota("Nessuno", "Nessuno", "Nessuna"));
                            for (Scuderia scuderia : scuderie) {
                                gara.aggiungiElemento(scuderia);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            gara.ordinaGara();
                            System.out.println("Risultati della Gara:");
                            gara.getGriglia().forEach(System.out::println);
                            System.out.println("Il vincitore è: " + gara.getVincitore());
                        } catch (Exception e) {
                            System.out.println("Errore durante l'ordinamento della gara: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Devi aggiungere almeno una scuderia.");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
