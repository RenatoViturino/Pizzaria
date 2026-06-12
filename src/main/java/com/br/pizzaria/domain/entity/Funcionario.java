package com.br.pizzaria.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de domínio: Funcionario
 * PK: cpfFuncionario (String) — conforme diagrama de classes
 */
public class Funcionario {

    private String cpfFuncionario;
    private String nome;
    private String cargo;
    private BigDecimal salario;
    private LocalDate dataContratacao;
    private List<PagamentoFuncionario> pagamentos = new ArrayList<>();

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
    public void setCpfFuncionario(String cpfFuncionario) { this.cpfFuncionario = cpfFuncionario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }

    public LocalDate getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDate dataContratacao) { this.dataContratacao = dataContratacao; }

    public List<PagamentoFuncionario> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<PagamentoFuncionario> pagamentos) { this.pagamentos = pagamentos; }
}
