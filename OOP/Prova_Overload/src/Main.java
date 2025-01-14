public class Main {
    public static void main(String[] args) {
        /*Studente studente1 = new Studente("Alessio");
        // getNome() = interfaccia pubblica
        System.out.println(studente1.getNome());
        Studente studente2 = new Studente("Alessio","Poli");
        System.out.println(studente2.getNome() + " " +studente2.getCognome());*/

        int count= 0;
        int cf = 0;
        int [] array = new int[15];
        // Non cambia niente
        for(int i = 0; i<5; i++){
            ++count;
            cf++;
            System.out.println("count "+ count+ " cf "+cf);
        }

        System.out.println("----");
        System.out.println("count" + count);

        count = 0;

        for(int i = 0; i<5; i++){
            array[count++] = i;
            System.out.println("Array " + array[i] + " Posizione " +count);
        }
        System.out.println("----");
        count = 0;

        for(int i = 0; i<5; i++){
            array[++count] = i;
            System.out.println("Array " + array[i] + " Posizione " +count);
        }

        System.out.println("----");
        for (int i = 0; i < 5; ++i) {
            System.out.println(i);  // Usa il valore incrementato di i
        }

        System.out.println("----");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);  // Usa il valore incrementato di i
        }

        int x = 5;
        int y = x++;  // Usa x (5) per assegnare a y, poi incrementa x a 6
        System.out.println("x: " + x + ", y: " + y);  // x: 6, y: 5

        int x2 = 5;
        int y2 = ++x2;  // Incrementa x a 6, poi assegna il valore di x (6) a y
        System.out.println("x2: " + x2 + ", y2: " + y2);  // x: 6, y: 6



    }
}