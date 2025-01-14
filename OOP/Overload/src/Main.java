import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner tastiera = new Scanner(System.in);
        try {
            Studente st = new Studente("Lionelo", "Pepsi", 8, 19);
            Studente st1 = new Studente("Lionelo", "Pepsi", 6, 19);
            st.setEta(89); //prende l'eccezione del metodo setEta
            System.out.println(st);
            System.out.println(st1);
            if(st.isEquals(st1)){
                System.out.println("Sono uguali");
            } else
                System.out.println("Non sono uguali");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Il programs continua...");

        int numeroMagico = tastiera.nextInt();
        try {
            if (numeroMagico < 100) {
                throw new Exception("Numero minore di 100");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(53);
        lista.add(153);
        lista.add(120);
        lista.add(353);
        lista.add(53);
        lista.add(150);
        lista.add(533);
        lista.add(5365);
        lista.add(10565);
        Collections.sort(lista);
        System.out.println(lista);
        Collections.reverse(lista);
        System.out.println(lista);
        ArrayList<Studente> scolaresca = new ArrayList<>();
        Studente st = new Studente("Pippo","Cicciogamer",89, 98);
        scolaresca.add(st);
        Studente st1 = new Studente("Poli","Maci",89, 98);
        scolaresca.add(st1);
        Studente st2 = new Studente("Vusentini","Gasparini",89, 98);
        scolaresca.add(st2);
        Collections.reverse(scolaresca);
        System.out.println(scolaresca);
        System.out.println("--------------------------------");
        Collections.sort(scolaresca);
        System.out.println(scolaresca);
    }
}
// st = st1 ==> confronta i due indirizzi di memoria