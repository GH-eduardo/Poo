package org.example.domain;

public class Pessoa {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private Pessoa trabalhaPara;
    private Empresa empregadoDaEmpresa;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTrabalhaPara(Pessoa trabalhaPara) { this.trabalhaPara = trabalhaPara; }

    public void setEmpregadoDaEmpresa(Empresa empregadoDaEmpresa) { this.empregadoDaEmpresa = empregadoDaEmpresa; }

    public String getNome() { return this.nome; }

    public String getCpf() { return this.cpf; }

    public String getDataNascimento() { return this.dataNascimento; }

    public Pessoa getTrabalhaPara() { return this.trabalhaPara; }

    public Empresa getEmpregadoDaEmpresa() { return empregadoDaEmpresa; }

    public Pessoa (String nome, String cpf, String dataNascimento) {
        setNome(nome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
    }

    public Pessoa (String nome, String cpf, String dataNascimento, Pessoa trabalhaPara) {
        setNome(nome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        setTrabalhaPara(trabalhaPara);
    }

    public Pessoa (String nome, String cpf, String dataNascimento, Empresa empregadoDaEmpresa) {
        setNome(nome);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        setEmpregadoDaEmpresa(empregadoDaEmpresa);
    }
}