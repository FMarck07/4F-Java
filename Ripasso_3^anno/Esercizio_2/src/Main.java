import Aereoporto.Aereo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        boolean uscita = true;
        Scanner sc = new Scanner(System.in);
        String[] opzioni = {"Aereoporto","1. Inserisci","2. Visualizza", "3. Cerca ","4. Rimuovi"};
        final int MAX = 3;
        int aerei = 0;
        ArrayList<Aereo> aereoporto = new ArrayList<>();

        do{
            switch (Menu(opzioni, sc)){
                case 1-> {
                    try {
                        if (aerei < MAX) {
                            Aereo a1 = new Aereo();
                            a1 = InserisciAereo(sc, true);
                            int trova = Cerca(aereoporto, a1);
                            if (trova == -1) {
                                aereoporto.add(a1);
                                aerei++;
                            }
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 2-> {
                    if(!aereoporto.isEmpty()) {
                        aereoporto.forEach(l-> System.out.println(l.toString()));
                    }else{
                        System.out.println("Nessun aereo da visualizzare");
                    }

                }
                case 3 -> {
                    if(!aereoporto.isEmpty()) {
                        Aereo a1 = InserisciAereo(sc, false);
                        /*boolean rimosso = aereoporto.removeIf(l -> l.modello.equals(a1.modello) && l.lunghezza == a1.lunghezza);
                        if(rimosso){
                            aerei--;
                        }*/

                        if (aereoporto.removeIf(l -> l.modello.equals(a1.modello) && l.lunghezza == a1.lunghezza)) {
                            aerei--;
                            System.out.println("Aereo rimosso con successo.");
                        } else {
                            System.out.println("Aereo non trovato.");
                        }

                    }else{
                        System.out.println("Nessun aereo da visualizzare");
                    }
                }
                case 4->{
                    uscita = false;
                }

            }
        }while(uscita);


    }
    public static Aereo InserisciAereo(Scanner sc, boolean si){
        Aereo aereo = new Aereo();
        System.out.println("Inserisci il modello dell'aereo");
        aereo.modello = sc.nextLine();
        System.out.println("Inserisci il lunghezza");
        aereo.lunghezza = Integer.parseInt(sc.nextLine());
        if(si){
            System.out.println("Inserisci la data");
            aereo.date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        return aereo;
    }

    public static int Cerca(ArrayList<Aereo> aereo, Aereo a){
        for(int i = 0; i < aereo.size(); i++){
            if(aereo.get(i).equals(a)){
                return i;
            }
        }
        return -1;
    }
}