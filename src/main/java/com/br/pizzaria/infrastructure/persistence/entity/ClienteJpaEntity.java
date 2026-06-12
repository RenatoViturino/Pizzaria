package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

/**
 * Entidade JPA: Cliente
 * PK: cpfCliente (String) — conforme diagrama de classes
 */
@Entity
@Table(name = "clientes")
public class ClienteJpaEntity {

    @Id
    @Column(name = "cpf_cliente", length = 11, nullable = false)
    private String cpfCliente;

    @Column(nullable = false)
    private String nome;

    @Column
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String endereco;

    @Column(nullable = false)
    private Integer pontuacao = 0;

    @Column(nullable = false)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_perfil")
    private PerfilJpaEntity perfil;

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

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public PerfilJpaEntity getPerfil() { return perfil; }
    public void setPerfil(PerfilJpaEntity perfil) { this.perfil = perfil; }
}
