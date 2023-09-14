package org.example.domain;

public class ContaPoupanca extends TipoConta implements Juros{

    @Override
    public void saldoInicial(){
        setSaldo(50.00);
    }

    // para abrir uma conta poupança o saldo mínimo é de R$50,00
    public ContaPoupanca(Pessoa proprietario) {
        super(false,false,false);
        saldoInicial();
    }

    public Double quantoSeraEm(int x) { //qual o montante depois de deixar x tempo rendendo na poupança
        double montanteFinal = this.getSaldo() + jurosSimples(getSaldo(), 0.005, x);
        System.out.println("Após " + x + " meses, com um rendimento de 0,5% ao mês (se não forem feitos aportes nem saques) você terá: R$" + montanteFinal + "nesta conta poupança!");
        return (montanteFinal);
    }
}
