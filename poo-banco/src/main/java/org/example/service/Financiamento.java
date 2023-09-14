package org.example.service;

import org.example.domain.Juros;

public class Financiamento implements Juros {

    public String simularFinanciamentoDeAutomovel(Double preco, Double taxa, int tempo) {
        if (tempo <= 0){ return "Impossível calcular financiamento com período <= 0!"; }
        double valorParcelas = ( (preco + this.jurosSimples(preco, taxa, tempo) ) / tempo);
        return "Você deverá pagar parcelas iguais de R$"+ valorParcelas +" por "+ tempo +" meses";
    }
}
