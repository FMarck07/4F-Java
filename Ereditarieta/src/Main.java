import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Persona p = new Persona("Alessio", "Poli", 17, "Rovigo", "Blu", "Nessuna");
        Studente s = new Studente("Nicolò", "Visentini", 17, "Rovigo", "Verde", "Nessuna", "12345", 8.5);
        Studente s2 = new Studente(p, "67890", 9.9); // Passa l'oggetto 'Persona' e i nuovi attributi

        ArrayList<Studente> studenti = new ArrayList<>();

        studenti.add(s);
        studenti.add(s2);

        studenti.forEach(System.out::println);
    }
}

