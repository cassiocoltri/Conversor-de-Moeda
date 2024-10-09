package models;


public class Cotacao extends  Moeda{

    private Moeda moeda;

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
}
