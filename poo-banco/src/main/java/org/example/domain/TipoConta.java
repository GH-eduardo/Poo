package org.example.domain;

public abstract class TipoConta {

    private Double saldo = 0.0;
    private Boolean podeTerCartaoDeCredito;
    private Boolean podeTerCartaoDeDebito;
    private Boolean podeFazerFinanciamento;
    private Pessoa proprietarioDaConta;
    private Pessoa proprietarioDaConta2;
    private Empresa donaDaConta;
    private String[] dias = new String[30]; // Array que representa um mes, será usado para fazer um log para obter extratos

    public Empresa getDonaDaConta() {
        return donaDaConta;
    }

    public void setDonaDaConta(Empresa donaDaConta) {
        this.donaDaConta = donaDaConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void saldoInicial() {
        setSaldo(0.00);
    }

    public String getDias(int a) {
        return dias[a];
    }

    public void setDias(int a, String dias) {
        this.dias[a] += dias;
    }

    public Boolean getPodeTerCartaoDeCredito() {
        return podeTerCartaoDeCredito;
    }

    public Boolean getPodeTerCartaoDeDebito() {
        return podeTerCartaoDeDebito;
    }

    public Boolean getPodeFazerFinanciamento() {
        return podeFazerFinanciamento;
    }

    public Pessoa getProprietarioDaConta() {
        return proprietarioDaConta;
    }

    public Pessoa getProprietarioDaConta2() {
        return this.proprietarioDaConta2;
    }

    public void setProprietarioDaConta(Pessoa proprietarioDaConta) {
        this.proprietarioDaConta = proprietarioDaConta;
    }

    public void setProprietarioDaConta2(Pessoa proprietarioDaConta2) {
        this.proprietarioDaConta2 = proprietarioDaConta2;
    }

    public TipoConta(Boolean credito, Boolean debito, Boolean financiamento) {
        this.podeTerCartaoDeCredito = credito;
        this.podeTerCartaoDeDebito = debito;
        this.podeFazerFinanciamento = financiamento;
        saldoInicial();
    }

    public Boolean sacar(Double quantia, int dia) {

        if (this.saldo < quantia) {
            System.out.println("Falha ao efetuar saque!\nSaldo insuficiente!");
            return false;
        }

        if (quantia <= 0) {
            System.out.println("Falha ao efetuar saque!\nA quantia deve ser maior que 0!");
            return false;
        }

        this.saldo -= quantia;
        setDias(dia, "\n- R$" + quantia);
        return true;
    }
    public Boolean depositar (Double quantia, int dia) {

        if(quantia <= 0){
            System.out.println("Falha ao efetuar depósito!\nÉ necessário que a quantia seja maior que 0!");
            return false;
        }

        this.saldo += quantia;
        setDias(dia, "\n+ R$" + quantia);
        return true;
    }
}