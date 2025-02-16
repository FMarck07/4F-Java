import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Corridore c = new Corridore("c");
        Corridore f = new Corridore("f");
        Gara x = new Gara(c, f);
        x.partita();
    }
}