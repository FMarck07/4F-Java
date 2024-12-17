import java.util.Scanner;
import static utility.Tools.*;
import java.util.Random;
public class FrontEnd {
    public static Pilota leggiPilota(Scanner sc) throws Exception {
        System.out.println("Inserisci il nome del pilota:");
        String nome = sc.nextLine();
        System.out.println("Inserisci il cognome del pilota:");
        String cognome = sc.nextLine();
        System.out.println("Inserisci la nazionalità del pilota:");
        String nazionalità = sc.nextLine();

        Pilota p = new Pilota(nome, cognome, nazionalità);
        return p;
    }

    public static Cronometro InserisciCronometro() throws Exception {
        Random rn = new Random();
        int tempo = rn.nextInt(5000) + 1000; // Simulates a time between 1 and 6 seconds
        Cronometro cr = new Cronometro();
        cr.setStartTime();
        Thread.sleep(tempo); // This simulates the delay in a race
        cr.setEndTime();
        cr.calcolaIntTimer();
        return cr;
    }
}
