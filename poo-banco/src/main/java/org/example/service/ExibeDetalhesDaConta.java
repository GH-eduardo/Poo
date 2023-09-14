package org.example.service;

import org.example.domain.TipoConta;

public class ExibeDetalhesDaConta {

    public void mostra(TipoConta conta) {
        if(conta.getProprietarioDaConta() != null) {
            System.out.println("Proprietário da conta: " + conta.getProprietarioDaConta().getNome());
            System.out.println("Cpf: " + conta.getProprietarioDaConta().getCpf());
            System.out.println("Data de nascimento: " + conta.getProprietarioDaConta().getDataNascimento());
        }
        if(conta.getProprietarioDaConta2() != null) {
            System.out.println("Segundo proprietário da conta: " + conta.getProprietarioDaConta2().getNome());
            System.out.println("Cpf: " + conta.getProprietarioDaConta2().getCpf());
            System.out.println("Data de nascimento: " + conta.getProprietarioDaConta2().getDataNascimento());
        }
        if(conta.getDonaDaConta() != null) {
            System.out.println("Empresa dona da conta: " + conta.getDonaDaConta().getNomeDaEmpresa());
            System.out.println("Cnpj da empresa: " + conta.getDonaDaConta().getCnpj());
            System.out.println("Dono da empresa: " + conta.getDonaDaConta().getDono().getNome());
            System.out.println("Cpf: " + conta.getDonaDaConta().getDono().getCpf());
            System.out.println("Data de nascimento: " + conta.getDonaDaConta().getDono().getDataNascimento());
        }
        if(conta.getPodeTerCartaoDeCredito()){
            System.out.println("Esse tipo de conta é elegivel a ter um cartão de crédito!");
        }
        else { System.out.println("Esse tipo de conta NÃO é elegivel a ter um cartão de crédito!"); }

        if(conta.getPodeTerCartaoDeDebito()){
            System.out.println("Esse tipo de conta é elegivel a ter um cartão de débito!");
        }
        else { System.out.println("Esse tipo de conta NÃO é elegivel a ter um cartão de débito!"); }

        if(conta.getPodeFazerFinanciamento()){
            System.out.println("Esse tipo de conta é elegivel a fazer um financiamento!");
        }
        else { System.out.println("Esse tipo de conta NÃO é elegivel a fazer um financiamento!"); }

        System.out.println("Saldo: R$" + conta.getSaldo());
    }

}
