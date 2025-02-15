public class Giocatore {
    private String nome;
    private int nVittorie;
    private Dado d;

    public Giocatore(String nome) {
        this.nome = nome;
        this.nVittorie = 0;
        this.d = new Dado();
    }

    public String getNome() {
        return nome;
    }

    public int getnVittorie() {
        return nVittorie;
    }

    public void incrementaVittorie() {
        nVittorie++;
    }

    public int lanciaDado() {
        return d.lancia();
    }

    @Override
    public String toString() {
        return String.format("Giocatore nome: %s, nVittorie: %d", nome, nVittorie);
    }
}