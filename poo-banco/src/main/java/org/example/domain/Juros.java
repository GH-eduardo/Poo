package org.example.domain;

public interface Juros {

    default Double jurosSimples(Double capital, Double taxa, int tempo) { // a taxa e o tempo devem estar no mesmo padrão
        return (capital*taxa*tempo);
    }
}
