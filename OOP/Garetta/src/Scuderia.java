public class Scuderia implements Comparable<Scuderia> {
    private String nome;
    private Pilota nPilota;
    private int nAuto;
    private Cronometro tempoGiro;

    public Scuderia(String nome, Pilota nPilota, int nAuto) {
        this.nome = nome;
        this.nPilota = nPilota;
        this.nAuto = nAuto;
    }

    public String getNome() {
        return nome;
    }

    public Pilota getnPilota() {
        return nPilota;
    }

    public Cronometro getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(Cronometro tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    @Override
    public String toString() {
        return String.format("Nome scuderia: %s, Pilota: %s, Auto: %d", nome, nPilota, nAuto);
    }

    @Override
    public int compareTo(Scuderia o) {
        return tempoGiro.compareTo(o.getTempoGiro());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Scuderia scuderia = (Scuderia) obj;
        return nome.equalsIgnoreCase(scuderia.nome);
    }
}
