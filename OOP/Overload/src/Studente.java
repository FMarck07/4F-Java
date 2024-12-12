import java.util.Collections;

public class Studente implements Comparable<Studente> {
    private String nome, cognome;
    private Integer media, eta;

    public Studente(String nome, String cognome, int media, int eta)  {
        this.nome = nome;
        this.cognome = cognome;
        this.media = media;
        this.eta = eta;
    }
    public Studente(String nome, String cognome, int eta) {
        this(nome, cognome, 0, eta);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
    public boolean isEquals(Studente s){
        return this.nome.equals(s.nome) && this.cognome.equals(s.cognome);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null || obj.getClass() != this.getClass()) {
            return false;
        }
        return this.nome.equals(((Studente) obj).nome) && this.cognome.equals(((Studente) obj).cognome); //operazione di casting
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", media=" + media +
                ", eta=" + eta +
                '}';
    }
    //Devo mettere implementa interfaccia Comparable<Studente>
    @Override
    public int compareTo(Studente s){
        return this.eta.compareTo(s.eta);
    }
}