package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade JPA: Funcionario
 * PK: cpfFuncionario (String) — conforme diagrama de classes
 */
@Entity
@Table(name = "funcionarios")
public class FuncionarioJpaEntity {

    @Id
    @Column(name = "cpf_funcionario", length = 11, nullable = false)
    private String cpfFuncionario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 30)
    private String cargo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(name = "data_contratacao", nullable = false)
    private LocalDate dataContratacao;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<PagamentoFuncionarioJpaEntity> pagamentos = new ArrayList<>();

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

    public List<PagamentoFuncionarioJpaEntity> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<PagamentoFuncionarioJpaEntity> pagamentos) { this.pagamentos = pagamentos; }
}
