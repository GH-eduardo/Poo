package org.example.service;

import org.example.domain.Acoes;

public class Aplicacoes {

    public String aplicarEmBancoDoBrasil(int quantasAcoes) {
        double preco = quantasAcoes * Acoes.BBAS3.getPreco();
        return quantasAcoes + " ações do Banco do Brasil custarão R$ " + preco;
    }

    public String aplicarEmCopel(int quantasAcoes) {
        double preco = quantasAcoes * Acoes.CPLE3.getPreco();
        return quantasAcoes + " ações da Copel custarão R$ " + preco;
    }

    public String aplicarEmPetrobras(int quantasAcoes) {
        double preco = quantasAcoes * Acoes.PETR4.getPreco();
        return quantasAcoes + " ações da Petrobras custarão R$ " + preco;
    }

    public String aplicarEmVale(int quantasAcoes) {
        double preco = quantasAcoes * Acoes.VALE3.getPreco();
        return quantasAcoes + " ações da Vale custarão R$ " + preco;
    }
}
