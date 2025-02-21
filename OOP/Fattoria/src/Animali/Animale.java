package Animali;

import java.util.Objects;

public class Animale implements Cloneable {
    private String nome;
    private String razza;
    private Integer eta;

    public Animale(String nome, String razza, Integer eta) {
        this.nome = nome;
        this.razza = razza;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animale animale))return false;
        return nome.equals(animale.nome);
    }

    @Override
    public Animale clone() throws CloneNotSupportedException{
        return (Animale) super.clone();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Raza: %s, Eta: %s", nome, razza, eta);
    }
}
