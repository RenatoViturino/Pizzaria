package com.br.pizzaria.domain.entity;

import com.br.pizzaria.domain.valueobject.Endereco;
import com.br.pizzaria.domain.valueobject.TipoPerfil;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade de domínio: Cliente
 * PK natural: cpfCliente (String)
 */
public class Cliente {

    private String cpfCliente;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private Endereco endereco;
    private Integer pontuacao;
    private TipoPerfil tipoPerfil;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String cpfCliente, String nome, String telefone,
                   String email, String senha, Endereco endereco) {
        this.cpfCliente = cpfCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.pontuacao = 0;
        this.tipoPerfil = TipoPerfil.BRONZE;
    }

    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
        atualizarPerfil();
    }

    private void atualizarPerfil() {
        if (this.pontuacao >= 500) this.tipoPerfil = TipoPerfil.OURO;
        else if (this.pontuacao >= 200) this.tipoPerfil = TipoPerfil.PRATA;
        else this.tipoPerfil = TipoPerfil.BRONZE;
    }

    public String getCpfCliente() { return cpfCliente; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Integer getPontuacao() { return pontuacao; }
    public TipoPerfil getTipoPerfil() { return tipoPerfil; }
    public List<Pedido> getPedidos() { return pedidos; }
}
