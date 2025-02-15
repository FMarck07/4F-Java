import java.util.Comparator;
import java.util.Objects;

public class Giocatore implements Comparable<Giocatore> {
    private String nome;
    private Integer nVittorie;
    private Dado d;

    public Giocatore(String nome, Integer nVittorie, Dado d) {
        this.nome = nome;
        this.nVittorie = nVittorie;
        this.d = d;
    }

    public String getNome() {
        return nome;
    }

    public Dado getD() {
        return d;
    }

    public int getnVittorie() {
        return nVittorie;
    }

    public void setnVittorie(int nVittorie) {
        this.nVittorie = nVittorie;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Giocatore g)) return false;
        return g.nome.equals(nome);
    }

    @Override
    public int compareTo(Giocatore o) {
        return nVittorie.compareTo(o.nVittorie);
    }
    public int incrementaVittorie(){
        return nVittorie++;
    }
}
