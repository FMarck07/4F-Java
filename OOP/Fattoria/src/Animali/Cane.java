package Animali;

public class Cane extends Animale {
    private Integer peso;

    public Cane(String nome, String razza, Integer eta, Integer peso) {
        super(nome, razza, eta);
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" peso = %s", peso);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cane cane))return false;
        return peso.equals(cane.peso) && super.equals(cane);
    }
}
