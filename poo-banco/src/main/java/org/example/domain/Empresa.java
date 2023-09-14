package org.example.domain;

public class Empresa {

    private String nomeDaEmpresa;
    private String cnpj;
    private Pessoa dono;

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Pessoa getDono() {
        return dono;
    }

    public Empresa(String nomeDaEmpresa, String cnpj, Pessoa dono) {
        setNomeDaEmpresa(nomeDaEmpresa);
        setCnpj(cnpj);
        setDono(dono);
    }
}