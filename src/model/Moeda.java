package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Moeda {

    private String nome;
    private BigDecimal valor;

    List<Cotacao> cotacao = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Cotacao> getCotacao() {
        return cotacao;
    }
}
