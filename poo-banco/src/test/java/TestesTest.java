import org.example.domain.*;
import org.example.service.Aplicacoes;
import org.example.service.ExibeDetalhesDaConta;
import org.example.service.ExtratoPorPeriodo;
import org.example.service.Financiamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestesTest {

    @Test
    public void conferirSeContaPoupancaComecaComCinquentaDeSaldo(){
        Pessoa pessoa = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        ContaPoupanca conta = new ContaPoupanca(pessoa);
        double cinquenta = conta.getSaldo();

        Assertions.assertEquals(50.00, cinquenta);
    }

    @Test
    public void exibirDetalhesDaConta(){
        Pessoa pessoa = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        Empresa empresa = new Empresa("Ricardo Eletro", "123.456.987-22", pessoa);
        ContaCorrente contaCorrente = new ContaCorrente(empresa);
        ExibeDetalhesDaConta mostra = new ExibeDetalhesDaConta();
        mostra.mostra(contaCorrente);
    }

    @Test
    public void depositosAndSaques(){
        Pessoa pessoa = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        ContaCorrente conta = new ContaCorrente(pessoa);
        conta.depositar(500.00, 15);
        System.out.println("Saldo na conta poupança: R$" + conta.getSaldo());
        conta.sacar(200.00, 16);
        double trezentos = conta.getSaldo();
        System.out.println("Saldo na conta poupança: R$" + conta.getSaldo());
        Assertions.assertEquals(300.00, trezentos);
    }

    @Test
    public void depositarEmUmaContaSalarioDeUmaContaComDoisProprietarios(){
        Pessoa empregador = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        Pessoa esposa = new Pessoa("Maria", "321.654.789-11","11/09/2001");
        ContaCorrente contaEmpregador = new ContaCorrente(esposa, empregador);
        contaEmpregador.depositar(5350.00, 4);
        Pessoa assalariado = new Pessoa("José", "823.446.789-61","11/09/2001", empregador);
        ContaSalario contaJose = new ContaSalario(assalariado);
        contaJose.depositarParaContaSalario(2350.00, contaEmpregador, contaJose, 22);

        Assertions.assertEquals(2350.00, contaJose.getSaldo());
    }

    @Test
    public void transferencias(){
        Pessoa empregador = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        Pessoa esposa = new Pessoa("Maria", "321.654.789-11","11/09/2001");
        ContaCorrente contaEmpregador = new ContaCorrente(esposa, empregador);
        contaEmpregador.depositar(5350.00, 1);
        Pessoa assalariado = new Pessoa("José", "823.446.789-61","11/09/2001", empregador);
        ContaSalario contaJose = new ContaSalario(assalariado);
        contaJose.depositarParaContaSalario(2350.00, contaEmpregador, contaJose, 3);

        contaJose.transferir(380.00, contaJose, contaEmpregador, 4);

        Assertions.assertEquals( 3380.00, contaEmpregador.getSaldo());
        Assertions.assertEquals(1970.00, contaJose.getSaldo());
    }

    @Test
    public void simularRendimentoPoupanca(){
        Pessoa empregador = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        ContaCorrente contaEmpregador = new ContaCorrente(empregador);

        Pessoa pedro = new Pessoa("Pedro", "123.456.789-11","11/09/2001", empregador);
        ContaSalario contaSalario = new ContaSalario(pedro);
        ContaPoupanca contaPoupanca = new ContaPoupanca(pedro);

        contaEmpregador.depositar(6000.00, 3);
        contaSalario.depositarParaContaSalario(3500.00, contaEmpregador, contaSalario, 4);
        contaSalario.transferir(1900.00, contaSalario, contaPoupanca, 4);
        double resultado = contaPoupanca.quantoSeraEm(12);

        Assertions.assertEquals( 2067.00, resultado);

    }

    @Test
    public void simularFinanciamento(){
        Financiamento financiamento = new Financiamento();
        System.out.println(financiamento.simularFinanciamentoDeAutomovel(90000.00, 0.02, 36));
    }

    @Test
    public void comprarAcoes(){
        Aplicacoes aplicacoes = new Aplicacoes();
        System.out.println( aplicacoes.aplicarEmBancoDoBrasil(200) );
        System.out.println( aplicacoes.aplicarEmCopel(300) );
        System.out.println( aplicacoes.aplicarEmPetrobras(150) );
        System.out.println( aplicacoes.aplicarEmVale(110) );
    }

    @Test
    public void pegarExtratos(){
        Pessoa empregador = new Pessoa("Ricardo", "123.456.789-11","11/09/2001");
        ContaCorrente contaEmpregador = new ContaCorrente(empregador);

        Pessoa pedro = new Pessoa("Pedro", "123.456.789-11","11/09/2001", empregador);
        ContaSalario contaSalario = new ContaSalario(pedro);
        ContaPoupanca contaPoupanca = new ContaPoupanca(pedro);

        contaEmpregador.depositar(6000.00, 3);
        contaSalario.depositarParaContaSalario(3500.00, contaEmpregador, contaSalario, 4);
        contaSalario.transferir(1900.00, contaSalario, contaPoupanca, 4);
        contaSalario.sacar(350.00, 5);

        ExtratoPorPeriodo extrato = new ExtratoPorPeriodo();
        extrato.extrato(contaSalario, 2, 6);
    }
}