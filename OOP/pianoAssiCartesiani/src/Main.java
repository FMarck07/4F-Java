import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lettura della base
        double base;
        do {
            System.out.println("Inserisci il valore della base (positivo):");
            base = scanner.nextDouble();
            if (base <= 0) {
                System.out.println("La base deve essere un valore positivo.");
            }
        } while (base <= 0);

        // Lettura dell'altezza
        double altezza;
        do {
            System.out.println("Inserisci il valore dell'altezza (positivo):");
            altezza = scanner.nextDouble();
            if (altezza <= 0) {
                System.out.println("L'altezza deve essere un valore positivo.");
            }
        } while (altezza <= 0);

        // Creazione del rettangolo
        Punto angolo = new Punto(0, 0); // Partiamo dall'origine
        Rettangolo rettangolo = new Rettangolo(angolo, base, altezza);

        // Disegna il rettangolo
        System.out.println("Disegno del rettangolo:");
        rettangolo.disegnaRettangolo();

        scanner.close();
    }
}
