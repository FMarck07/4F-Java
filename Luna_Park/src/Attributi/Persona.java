package Attributi;

import Attributi.Giostre;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Attributi.Giostre.*;

public class Persona {
    public int biglietto;
    public LocalDateTime entrata = LocalDateTime.now();
    public Giostre giostreusate;
    public ArrayList<Giostre> giostreProvate = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

    @Override
    public String toString() {
        {return String.format("Biglietto " +biglietto+ "Orario di entrata " + entrata.format(formatter));}
    }
    public String giostre() {
        return String.format("Giostre provate " +giostreProvate+ "Numero di volte " + giostreProvate.size());
    }

}