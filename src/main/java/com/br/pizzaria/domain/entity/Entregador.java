package com.br.pizzaria.domain.entity;

/**
 * Entidade de domínio: Entregador
 */
public class Entregador {

    private Long idEntregador;
    private String nome;
    private String cpf;
    private String telefone;
    private String placa;
    private String tipoVeiculo;
    private boolean ativo;

    public Entregador() {}

    public Entregador(String nome, String cpf, String telefone, String placa, String tipoVeiculo) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do entregador é obrigatório.");
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF do entregador é obrigatório.");
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.ativo = true;
    }

    public void desativar() { this.ativo = false; }
    public void ativar()    { this.ativo = true; }

    public Long getIdEntregador()           { return idEntregador; }
    public void setIdEntregador(Long id)    { this.idEntregador = id; }
    public String getNome()                 { return nome; }
    public void setNome(String nome)        { this.nome = nome; }
    public String getCpf()                  { return cpf; }
    public String getTelefone()             { return telefone; }
    public void setTelefone(String t)       { this.telefone = t; }
    public String getPlaca()                { return placa; }
    public void setPlaca(String placa)      { this.placa = placa; }
    public String getTipoVeiculo()          { return tipoVeiculo; }
    public void setTipoVeiculo(String tv)   { this.tipoVeiculo = tv; }
    public boolean isAtivo()                { return ativo; }
}
