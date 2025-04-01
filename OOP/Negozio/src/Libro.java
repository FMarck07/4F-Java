public class Libro implements Prodotto, Cloneable {
    private String nome;
    private String descrizione;
    private String autore;
    private String codice;
    private double prezzo;
    private int quantita;

    public Libro(String nome, String descrizione, String autore, String codice, double prezzo, int quantita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.autore = autore;
        this.codice = codice;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    @Override
    public String getCodice() {
        return codice;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getAutore() {
        return autore;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Autore: %s, Codice: %s, Prezzo: %.2f, Quantità: %d",
                nome, autore, codice, prezzo, quantita);
    }

    @Override
    public Libro clone() {
        try {
            return (Libro) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}