import java.util.ArrayList;

public class Teatro {
    ArrayList<Persona> persone;
    final int MAXPERSONE = 10;

    public Teatro() {
        persone = new ArrayList<>();
    }

    public void entrataTeatro(Persona p) throws Exception {
        if (!(persone.contains(p)) && persone.size() < MAXPERSONE) {
            try {
                persone.add(p.clone());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new Exception("Questa persona è già presente all'interno del teatro o il teatro è pieno");
        }
    }
    
    public void set(Persona p, String col) throws Exception {
        if (persone.contains(p)) {
            int index = persone.indexOf(p);
            persone.get(index).setColorePreferito(col);
        } else {
            throw new Exception("Persona non trovata nel teatro");
        }
    }

    public void stampaAVideo() {
        for (Persona persona : persone) {
            System.out.println(persona.presentazione());
        }
    }
}