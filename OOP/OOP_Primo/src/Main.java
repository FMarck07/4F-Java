import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Creazione del primo punto
            System.out.println("Inserisci le coordinate del punto (x, y):");
            double x1 = chiediValore("x", sc);
            double y1 = chiediValore("y", sc);
            Punto p1 = new Punto(x1, y1);
            System.out.println("Il punto si trova nel: " + p1.getQuadrante());

            // Creazione di due punti per il segmento
            System.out.println("\nOra inserisci due punti per calcolare la lunghezza del segmento.");
            System.out.println("Primo punto:");
            double x2 = chiediValore("x", sc);
            double y2 = chiediValore("y", sc);
            Punto puntoA = new Punto(x2, y2);

            System.out.println("Secondo punto:");
            double x3 = chiediValore("x", sc);
            double y3 = chiediValore("y", sc);
            Punto puntoB = new Punto(x3, y3);

            Segmento segmento = new Segmento(puntoA, puntoB);
            System.out.println(segmento);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore: " + e.getMessage());
        }
        sc.close();
    }

    private static double chiediValore(String nomeCoordinata, Scanner sc) {
        System.out.print("Inserisci " + nomeCoordinata + ": ");
        while (!sc.hasNextDouble()) {
            System.out.println("Errore: devi inserire un numero valido.");
            sc.next(); // Consuma input non valido
            System.out.print("Inserisci " + nomeCoordinata + ": ");
        }
        return sc.nextDouble();
    }
}
