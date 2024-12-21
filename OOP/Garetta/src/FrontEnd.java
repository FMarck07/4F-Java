import java.util.Random;
import java.util.Scanner;

public class FrontEnd {
    public static Pilota leggiPilota(Scanner sc) throws Exception {
        System.out.println("Inserisci il nome del pilota:");
        String nome = sc.nextLine();
        System.out.println("Inserisci il cognome del pilota:");
        String cognome = sc.nextLine();
        System.out.println("Inserisci la nazionalità del pilota:");
        String nazionalità = sc.nextLine();

        return new Pilota(nome, cognome, nazionalità);
    }

    public static Cronometro inserisciCronometro() throws Exception {
        Random rn = new Random();
        int tempo = rn.nextInt(5000) + 1000;
        Cronometro cr = new Cronometro();
        cr.setStartTime();
        Thread.sleep(tempo); 
        cr.setEndTime();
        cr.calcolaIntTimer();
        return cr;
    }
}
