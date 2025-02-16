import java.util.Random;

public class Corridore {
    private int velocita;
    private String nome;
    private int nVittorie;

    public Corridore(String nome) {
        this.nome = nome;
        this.nVittorie = 0;
    }

    public int getVelocita() {
        return velocita;
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

    public int generaVelocita() {
        Random r = new Random();
        return velocita = r.nextInt(10) + 1;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, nVittorie: %d", nome, nVittorie);
    }
}
