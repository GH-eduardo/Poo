package org.example.domain;

public enum Acoes {

    BBAS3(46.64), //BANCO DO BRASIL
    CPLE3(8.06),  //COPEL
    PETR4(33.40), //PETROBRAS
    VALE3(66.71); //VALE

    private Double preco;

    Acoes(Double preco) { this.preco = preco; }

    public Double getPreco() { return preco; }
}
