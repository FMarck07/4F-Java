import java.util.ArrayList;
import java.util.Collections;

public class Gara {
    private String nome;
    private ArrayList<Scuderia> griglia = new ArrayList<>();
    private String vincitore;

    public Gara(String nome) {
        this.nome = nome;
    }

    public void aggiungiElemento(Scuderia s) {
        griglia.add(s);
    }


    public void ordinaGara() throws Exception {
        if (griglia.isEmpty()) {
            throw new Exception("Griglia non trovata");
        }
        Collections.sort(griglia);
        vincitore = griglia.get(0).getnPilota().getNome() + " " + griglia.get(0).getnPilota().getCognome();
    }

    public ArrayList<Scuderia> getGriglia() {
        return griglia;
    }

    public String getVincitore() {
        return vincitore;
    }

    @Override
    public String toString() {
        return "Gara: " + nome;
    }
}
