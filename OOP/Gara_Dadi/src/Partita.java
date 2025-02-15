public class Partita {
    private Giocatore g1;
    private Giocatore g2;

    public Partita(Giocatore g1, Giocatore g2) {
        this.g1 = g1;
        this.g2 = g2;
    }

    public void iniziaPartita(){
        g1.getD().Lancia();
        g2.getD().Lancia();
        g1.getD().compareTo(g2.getD());
    }

    public boolean FineGara(){

    }
    public String Winner(){

    }

}
