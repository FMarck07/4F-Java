import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        int tempo;
        Scanner sc = new Scanner(System.in);
        try {
            Cronometro cr = new Cronometro();
            tempo = rn.nextInt(1000, 10000) + 1;
            cr.setStartTime();
            Wait(tempo);
            cr.setEndTime();
            cr.calcolaIntTimer();
            Cronometro cr2 = new Cronometro();
            tempo = rn.nextInt(1000, 10000) + 1;
            cr2.setStartTime();
            Wait(tempo);
            cr2.setEndTime();
            cr2.calcolaIntTimer();
            Cronometro cr3 = new Cronometro();
            tempo = rn.nextInt(1000, 10000) + 1;
            cr3.setStartTime();
            Wait(tempo);
            cr3.setEndTime();
            cr3.calcolaIntTimer();
            Pilota p1 = new Pilota("Marchettus", "Andretti", "America");
            Pilota p2 = new Pilota("Mohamed", "Andretti", "America");
            Pilota p3 = new Pilota("Vusentini", "Andretti", "America");
            Pilota nazioneGara = new Pilota("null", "null", "America");
            Scuderia sc1 = new Scuderia("Scuderia 1", p1, 150, cr);
            Scuderia sc2 = new Scuderia("Scuderia 2", p2, 120, cr2);
            Scuderia sc3 = new Scuderia("Scuderia 3", p3, 110, cr3);
            Gara gara = new Gara("Cicciogamer", nazioneGara);
            gara.aggiungiElemento(sc1);
            gara.aggiungiElemento(sc2);
            gara.aggiungiElemento(sc3);
            gara.ordinaGara();
            String[] opzioni = {"Opzion1"};
            switch (Menu(opzioni, sc)){
                case 1->{

                }
                default -> System.out.println("Errore");
            }
            gara.getGriglia().forEach(System.out::println);
            System.out.println("Il vincitore è: " + gara.getVincitore() + " Scuderia: "+gara.getGriglia().getFirst().getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}