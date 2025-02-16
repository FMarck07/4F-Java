import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Corridore c = new Corridore("c");
        Corridore f = new Corridore("f");
        System.out.println("Inserisci il numero di round");
        int n = sc.nextInt();
        Gara x = new Gara(n, c, f);
        for(int i = 0; i < n; i++) {
            x.round();
        }
        System.out.printf(x.vincitore());

    }
}