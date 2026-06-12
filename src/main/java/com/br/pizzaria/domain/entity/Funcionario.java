package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade de domínio: Funcionario
 * PK natural: cpfFuncionario (String)
 */
public class Funcionario {

    private String cpfFuncionario;
    private String nome;
    private String cargo;
    private BigDecimal salario;
    private LocalDate dataContratacao;

    public Funcionario() {}

    public Funcionario(String cpfFuncionario, String nome, String cargo,
                       BigDecimal salario, LocalDate dataContratacao) {
        this.cpfFuncionario = cpfFuncionario;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public String getCpfFuncionario() { return cpfFuncionario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public LocalDate getDataContratacao() { return dataContratacao; }
}
