package Animali;

public class Uccello extends Animale {
    private String tipoBecco;

    public Uccello(String nome, String razza, Integer eta, String tipoBecco) {
        super(nome, razza, eta);
        this.tipoBecco = tipoBecco;
    }

    public String getTipoBecco() {
        return tipoBecco;
    }

    public void setTipoBecco(String tipoBecco) {
        this.tipoBecco = tipoBecco;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Uccello uccello))return false;
        return tipoBecco.equals(uccello.tipoBecco) && super.equals(uccello);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" tipoBecco=%s", tipoBecco);
    }
}
