package org.example.domain;

public class ContaCorrente extends TipoConta implements Transferencia {


    public ContaCorrente(Pessoa proprietario) {
        super(true, true, true);
        setProprietarioDaConta(proprietario);
    }

    public ContaCorrente(Pessoa proprietario, Pessoa proprietario2) {
        super(true, true, true);
        setProprietarioDaConta(proprietario);
        setProprietarioDaConta2(proprietario2);
    }

    public ContaCorrente(Empresa dona) {
        super(true, true, true);
        setDonaDaConta(dona);
    }
}