package Animali;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

import static Animali.Main.leggiFile;
import static Animali.Main.scriviAnimali;
import static utility.Tools.Menu;

public class Fattoria {
    private String nome;
    private ArrayList<Animale> lista;

    public Fattoria(String nome) {
        this.nome = nome;
        lista = new ArrayList<>();
    }
    public void InserisciAnimale(Animale animale) throws Exception{
        if(animale != null) {
            if (!lista.contains(animale)) {
                lista.add(animale.clone());
            }else{
                throw new Exception("Animale già presente");
            }
        }
    }
    public void rimuoviAnimale(Animale animale) throws Exception{
        if(animale != null) {
            if(lista.contains(animale)) {
                lista.removeIf(s -> s.equals(animale));
            }
        }
    }

    public void leggiLista() throws Exception{
        if(!lista.isEmpty()) {
            lista.forEach(System.out::println);
        }
    }

    public void VisualizzaPerRazza(String razza) throws Exception{
        for(Animale a : lista) {
            if(a.getRazza().equals(razza)) {
                lista.forEach(System.out::println);
            }
        }
    }
    public void CambiaEta(Integer eta, Animale a) throws Exception{
        for(Animale b : lista) {
            if(b.equals(a)) {
                a.setEta(eta);
            }
        }
    }
    public void salvaAnimale(String nameFile) throws Exception{
        scriviAnimali(this.lista, nameFile);
    }
    public void caricaAnimali(String nameFile) throws Exception{
        ArrayList<Animale> carica = leggiFile(nameFile);
        this.lista.clear();
        this.lista.addAll(carica);
    }
}
