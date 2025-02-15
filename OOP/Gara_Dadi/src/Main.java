public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Giocatore1");
        Giocatore g2 = new Giocatore("Giocatore2");
        Partita p = new Partita(g1, g2, 3);

        try {
            p.round();
            p.round();
            System.out.println(p.winner());
            p.round();
            System.out.println(p.winner());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}