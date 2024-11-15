import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona {
    public String nome;
    public String cognome;
    public LocalDate data;
    public LocalDateTime entrata;


    @Override
    public String toString() {
        return String.format("Nome "+nome+" Cognome "+cognome+" Data "+data);
    }
}
