import java.util.ArrayList;
import java.util.Random;

public class Gara {
    private String nomeGara;
    private ArrayList<Auto> partecipanti;

    public Gara(String nomeGara) {
        this.nomeGara = nomeGara;
        this.partecipanti = new ArrayList<>();
    }

    public void aggiungiAuto(Auto auto) {
        for (Auto a : partecipanti) {
            if (a.getPilota().equals(auto.getPilota())) {
                throw new IllegalArgumentException("Il pilota " + auto.getPilota().getNome() + " " + auto.getPilota().getCognome() + " è già iscritto alla gara!");
            }
        }
        partecipanti.add(auto);
    }

    public Pilota corriGara() {
        if (partecipanti.isEmpty()) {
            throw new IllegalStateException("Nessuna auto è iscritta alla gara!");
        }

        // Determina casualmente il vincitore
        Random random = new Random();
        Auto vincitore = partecipanti.get(random.nextInt(partecipanti.size()));

        return vincitore.getPilota();
    }

    @Override
    public String toString() {
        String result = "Gara: " + nomeGara + "\n";
        if (partecipanti.isEmpty()) {
            result += "Nessun partecipante iscritto.\n";
        } else {
            result += "Partecipanti:\n";
            for (int i = 0; i < partecipanti.size(); i++) {
                result += (i + 1) + ". " + partecipanti.get(i) + "\n";
            }
        }
        return result;
    }
}
