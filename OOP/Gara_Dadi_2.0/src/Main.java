public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Cicciogaer89");
        Giocatore g2 = new Giocatore("nEGRO");
        Partita p = new Partita(g1, g2);

        p.giocaPartita();
    }
}