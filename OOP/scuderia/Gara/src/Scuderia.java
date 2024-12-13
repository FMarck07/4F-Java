public class Scuderia implements Comparable<Scuderia> {
    private String nome;
    private Pilota nPilota;
    private int nAuto;
    private Cronometro tempoGiro;

    public Scuderia(String nome, Pilota nPilota, int nAuto, Cronometro tempoGiro) {
        this.nome = nome;
        this.nPilota = nPilota;
        this.nAuto = nAuto;
        this.tempoGiro = tempoGiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pilota getnPilota() {
        return nPilota;
    }

    public void setnPilota(Pilota nPilota) {
        this.nPilota = nPilota;
    }

    public int getnAuto() {
        return nAuto;
    }

    public void setnAuto(int nAuto) {
        this.nAuto = nAuto;
    }

    public Cronometro getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(Cronometro tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    @Override
    public String toString() {
        return String.format("Nome scuderia: %s, Nome Pilota: %s, nAuto: %d, %s", nome, nPilota.getNome(), nAuto, tempoGiro);
    }

    @Override
    public int compareTo(Scuderia o) {
        return tempoGiro.compareTo(o.getTempoGiro());
    }
}
