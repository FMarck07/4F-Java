import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Creazione della gara
            System.out.print("Inserisci il nome della gara: ");
            String nomeGara = sc.nextLine();
            Gara gara = new Gara(nomeGara);

            // Aggiungere partecipanti
            System.out.println("\nQuante auto vuoi iscrivere alla gara?");
            int numeroAuto = chiediNumero(sc);

            for (int i = 1; i <= numeroAuto; i++) {
                boolean aggiunto = false; // Flag per verificare se l'auto è stata aggiunta
                while (!aggiunto) {
                    try {
                        System.out.println("\nInserisci i dettagli per l'auto #" + i + ":");
                        System.out.print("Scuderia: ");
                        String scuderia = sc.nextLine();
                        System.out.print("Nome pilota: ");
                        String nome = sc.nextLine();
                        System.out.print("Cognome pilota: ");
                        String cognome = sc.nextLine();
                        System.out.print("Nazionalità pilota: ");
                        String nazionalita = sc.nextLine();
                        int eta = chiediEta(sc);
                        Pilota pilota = new Pilota(nome, cognome, nazionalita, eta);

                        System.out.print("Cilindrata dell'auto: ");
                        double cilindrata = chiediCilindrata(sc);

                        Auto auto = new Auto(scuderia, pilota, cilindrata);

                        // Prova ad aggiungere l'auto
                        gara.aggiungiAuto(auto);
                        aggiunto = true; // Se l'auto viene aggiunta correttamente, interrompi il ciclo
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                        System.out.println("Riprova con un pilota diverso.");
                    }
                }
            }

            // Stampare i dettagli della gara
            System.out.println("\n" + gara);

            // Correre la gara
            Pilota vincitore = gara.corriGara();
            System.out.println("\nIl vincitore della gara '" + nomeGara + "' è: " + vincitore.getNome() + " " + vincitore.getCognome());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static int chiediNumero(Scanner sc) {
        int numero = 0;
        while (numero <= 0) {
            try {
                System.out.print("Inserisci un numero positivo: ");
                numero = Integer.parseInt(sc.nextLine());
                if (numero <= 0) {
                    System.out.println("Errore: devi inserire un numero maggiore di 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero valido.");
            }
        }
        return numero;
    }

    private static int chiediEta(Scanner sc) {
        int eta = 0;
        while (eta <= 0) {
            try {
                System.out.print("Inserisci l'età del pilota: ");
                eta = Integer.parseInt(sc.nextLine());
                if (eta <= 0) {
                    System.out.println("Errore: l'età deve essere maggiore di 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero valido.");
            }
        }
        return eta;
    }

    private static double chiediCilindrata(Scanner sc) {
        double cilindrata = 0;
        while (cilindrata <= 0) {
            try {
                System.out.print("Inserisci la cilindrata dell'auto: ");
                cilindrata = Double.parseDouble(sc.nextLine());
                if (cilindrata <= 0) {
                    System.out.println("Errore: la cilindrata deve essere maggiore di 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero valido.");
            }
        }
        return cilindrata;
    }
}
