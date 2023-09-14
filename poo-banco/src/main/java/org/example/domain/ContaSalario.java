package org.example.domain;

public class ContaSalario extends TipoConta implements Transferencia {

    public ContaSalario(Pessoa proprietario) {
        super(false,true,false);
        setProprietarioDaConta(proprietario);
    }

    @Override
    public Boolean depositar(Double quantia, int dia) {
        return false;
    }

    // Somente o empregador pode depositar em uma conta salário, por isso o novo método abaixo

    public Boolean verificaRelacaoEmpregaticia(TipoConta origem, ContaSalario destino) {
        if(origem.getProprietarioDaConta().getCpf().equals(destino.getProprietarioDaConta().getTrabalhaPara().getCpf())
                || origem.getProprietarioDaConta2().getCpf().equals(destino.getProprietarioDaConta().getTrabalhaPara().getCpf())
                || origem.getProprietarioDaConta().getCpf().equals(destino.getProprietarioDaConta2().getTrabalhaPara().getCpf())
                || origem.getProprietarioDaConta2().getCpf().equals(destino.getProprietarioDaConta2().getTrabalhaPara().getCpf())
                || origem.getDonaDaConta().getDono().getCpf().equals(destino.getProprietarioDaConta().getEmpregadoDaEmpresa().getDono().getCpf())
                || origem.getDonaDaConta().getDono().getCpf().equals(destino.getProprietarioDaConta2().getEmpregadoDaEmpresa().getDono().getCpf())
        ) { return true; }

        return false;
    }

    public Boolean depositarParaContaSalario(Double quantia, TipoConta origem, ContaSalario destino, int dia) {
        if(verificaRelacaoEmpregaticia(origem, destino)) {
            origem.sacar(quantia, dia);
            destino.setSaldo(destino.getSaldo() + quantia);
            setDias(dia, "\n+ R$" + quantia);
            //destino.transferir(quantia, origem, destino, dia); NÃO SEI PQ ASSIM NÃO FUNCIONA
            return true;
        }
        System.out.println("Somente o empregador da pessoa dona da conta pode efetuar depósitos nela!");
        return false;
    }
}