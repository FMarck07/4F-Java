package BackEnd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Mensola {
    private int nLibri;
    private final int MAXLIBRI = 3;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int nLibri) {
        this.nLibri = nLibri;
    }

    public void addLibro(Libro l) throws Exception {
        if (l != null && !mensola.contains(l) && nLibri < MAXLIBRI) {
            mensola.add(l);
            nLibri++;
        } else
            throw new Exception("Il libro è già presente nella mensola o la mensola è piena");
    }

    public boolean checkSpace() throws Exception {
        if (nLibri == MAXLIBRI)
            throw new Exception("La mensola è piena");
        else
            return false;
    }

    public ArrayList<Libro> getVolumi() {
        return new ArrayList<>(mensola);
    }

    public Libro cercaLibro(String autore, String titolo) {
        for (Libro libro : mensola) {
            if (libro.getAutore().equals(autore) && libro.getTitolo().equals(titolo)) {
                return libro;
            }
        }
        return null;
    }

    public boolean rimuoviLibro(Libro libro) {
        if (mensola.contains(libro)) {
            mensola.remove(libro);
            nLibri--;
            return true;
        }
        return false;
    }

    // Metodo per salvare i libri in un file JSON
    public void salvaSuFile(String filePath) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonContent = gson.toJson(mensola);  // Converto oggetto mensola in una stringa
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonContent);
        }
    }

    // Metodo per caricare i libri da un file JSON
    public void caricaDaFile(String filePath) throws Exception {
        Path path = Path.of(filePath);
        if (Files.exists(path)) {
            String jsonContent = Files.readString(path);
            Gson gson = new Gson();
            Libro[] libri = gson.fromJson(jsonContent, Libro[].class);
            mensola = new ArrayList<>();
            for (Libro libro : libri) {
                mensola.add(libro);
            }
            nLibri = mensola.size();
        } else {
            throw new Exception("File non trovato: " + filePath);
        }
    }
}
