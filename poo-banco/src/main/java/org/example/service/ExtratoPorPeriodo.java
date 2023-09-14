package org.example.service;

import org.example.domain.TipoConta;

public class ExtratoPorPeriodo {

    public void extrato(TipoConta conta, int diaInicio, int diaFim) {

        for(int i = diaInicio; i <= diaFim; i++) {
            System.out.println("Dia " + i + ": ");
            if(conta.getDias(i) != null){
                System.out.println(conta.getDias(i));
            }
            else { System.out.println(" --"); }
        }
    }
}
