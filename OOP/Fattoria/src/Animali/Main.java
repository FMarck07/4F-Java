package Animali;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import static utility.Tools.Menu;
import static utility.Tools.leggiAnimale;

public class Main {
    public static void main(String[] args)  {
        boolean fine = true;
        Scanner sc = new Scanner(System.in);
        Fattoria f = new Fattoria("Cicciogamer89");
        String[] opzioni = {"Fattoria","Inserisci","Visualizza","Rimuovi", "Visualizza per razza", "Cambia età"};


        try{
            do{
                switch (Menu(opzioni, sc)){
                    case 1->{
                        Animale a = leggiAnimale();
                        f.InserisciAnimale(a);
                    }
                    case 2->{
                        f.leggiLista();
                    }
                    case 3->{
                        f.rimuoviAnimale(leggiAnimale());
                    }
                    case 4->{
                        Animale a = leggiAnimale();
                        System.out.println("Inserisci età");
                        Integer eta = sc.nextInt();
                        f.CambiaEta(eta, a);
                    }
                }
            }while(fine);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            f.salvaAnimale("Ciccio");
            f.caricaAnimali("Ciccio");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void scriviAnimali(ArrayList<Animale> a, String nameFile){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter fd = new FileWriter(nameFile)){
            gson.toJson(a,fd);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Animale> leggiFile(String nameFile) {
        Gson gson = new Gson();
        ArrayList<Animale> animale = new ArrayList<>();
        try (FileReader reader = new FileReader(nameFile)) {
            Type tipo = new TypeToken<ArrayList<Animale>>() {}.getType();
            animale = gson.fromJson(reader, tipo);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
        return animale;
    }

}
