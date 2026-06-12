package com.br.pizzaria.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String cpfCliente;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Integer pontuacao;
    private Perfil perfil;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String cpfCliente, String nome, String telefone,
                   String email, String endereco) {
        this.cpfCliente = cpfCliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.pontuacao = 0;
    }

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public Integer getPontuacao() { return pontuacao; }
    public void setPontuacao(Integer pontuacao) { this.pontuacao = pontuacao; }
    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
    public List<Pedido> getPedidos() { return pedidos; }
    public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
}
