import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Creazione del primo pilota:");
            Pilota pilota1 = creaPilota(sc);

            System.out.println("Creazione del secondo pilota:");
            Pilota pilota2 = creaPilota(sc);

            if (pilota1.equals(pilota2)) {
                System.out.println("I due piloti sono uguali.");
            } else {
                System.out.println("I due piloti sono diversi.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static Pilota creaPilota(Scanner sc) {
        System.out.print("Inserisci il nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Inserisci il cognome: ");
        String cognome = sc.nextLine().trim();
        System.out.print("Inserisci la nazionalità: ");
        String nazionalita = sc.nextLine().trim();
        int eta = 0;

        while (eta <= 0) {
            try {
                System.out.print("Inserisci l'età: ");
                eta = Integer.parseInt(sc.nextLine().trim());
                if (eta <= 0) {
                    System.out.println("L'età deve essere maggiore di 0. Riprova.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido per l'età.");
            }
        }

        return new Pilota(nome, cognome, nazionalita, eta);
    }
}
