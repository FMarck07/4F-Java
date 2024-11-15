package Aereoporto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Aereo {
    public String modello;
    public int lunghezza;
    public LocalDate date;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //private DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public String toString() {
        return String.format("modello "+ modello+ " lunghezza "+lunghezza+" data "+formatter.format(date));
    }

    @Override
    public boolean equals(Object o) {
        Aereo a = (Aereo) o;
        return (modello.equals(a.modello) && lunghezza == a.lunghezza);
    }
}