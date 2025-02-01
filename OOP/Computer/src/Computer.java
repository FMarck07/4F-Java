/*      il tipo di processore,
        la dimensione della memoria RAM, la dimensione
        della memoria di massa, la marca, il modello e
        il sistema operativo*/

import java.util.Objects;

public class Computer {
    private String processore;
    private int ram;
    private int memoriaMassa;
    private String marca;
    private String modello;
    private String SO;

    public Computer(String processore, int ram, int memoriaMassa, String marca, String modello, String SO) {
        this.processore = processore;
        this.ram = ram;
        this.memoriaMassa = memoriaMassa;
        this.marca = marca;
        this.modello = modello;
        this.SO = SO;
    }

    public String getProcessore() {
        return processore;
    }

    public int getRam() {
        return ram;
    }

    public int getMemoriaMassa() {
        return memoriaMassa;
    }

    public String getModello() {
        return modello;
    }

    public String getSO() {
        return SO;
    }

    public void setProcessore(String processore) {
        this.processore = processore;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setMemoriaMassa(int memoriaMassa) {
        this.memoriaMassa = memoriaMassa;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }


    /*il tipo di processore,
        la dimensione della memoria RAM, la dimensione
        della memoria di massa, la marca, il modello e
        il sistema operativo*/

    @Override
    public String toString() {
        return String.format("Processore %s, Memoria Ram: %d, Dimensione Memoria Massa: %s, Marca: %s, Modello %s, SO: %s", processore, ram, memoriaMassa, marca, modello, SO);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Computer computer)){
            return false;
        }else{
            return computer.modello.equals(modello) && computer.marca.equals(marca);
        }
    }

}
