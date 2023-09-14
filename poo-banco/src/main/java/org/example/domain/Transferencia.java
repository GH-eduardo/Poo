package org.example.domain;

public interface Transferencia {

    default boolean transferir (Double quantia, TipoConta origem, TipoConta destino, int dia) {

        boolean sucesso = origem.sacar(quantia,dia);

        if( !sucesso ){
            System.out.println("Falha ao efetuar tranferência!");
            return false;
        }
        else {
            origem.setDias(dia, " Transferiu R$" + quantia + " para: " + destino.getProprietarioDaConta());
            destino.depositar(quantia, dia);
            destino.setDias(dia, " Recebeu tranferência de R$" + quantia + " de: " + origem.getProprietarioDaConta());
            System.out.println("Transferência efetuada com sucesso!");
        }
        return true;
    }
}