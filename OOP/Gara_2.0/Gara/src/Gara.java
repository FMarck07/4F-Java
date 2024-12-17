import java.util.ArrayList;
import java.util.Collections;

public class Gara{
    private String nome;
    private Pilota nazione;
    private ArrayList<Scuderia> griglia = new ArrayList<>();
    private String vincitore;

    public Gara(String nome, Pilota nazione) {
        this.nome = nome;
        this.nazione = nazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pilota getNazione() {
        return nazione;
    }

    public void setNazione(Pilota nazione) {
        this.nazione = nazione;
    }

    public void setGriglia(ArrayList<Scuderia> griglia) {
        this.griglia = griglia;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public void aggiungiElemento(Scuderia s){
        griglia.add(s);
    }

    public void ordinaGara() throws Exception {
        if (griglia.isEmpty()) {
            throw new Exception("Griglia non trovata");
        }
        // Make sure every team's time is set before sorting.
        for (Scuderia scuderia : griglia) {
            if (scuderia.getTempoGiro() == null) {
                throw new Exception("Tempo di gara non calcolato per tutti i piloti.");
            }
        }
        Collections.sort(griglia);
        setVincitore(griglia.get(0).getnPilota().getNome() + " " + griglia.get(0).getnPilota().getCognome());
    }

    public ArrayList<Scuderia> getGriglia() throws Exception{
        if(griglia.isEmpty()){
            throw new Exception("Griglia non trovata");
        }
        return griglia;
    }

    @Override
    public String toString() {
        return String.format("Nome Gara: %s, Nazione: %s", nome, nazione.getNazionalità());
    }
}