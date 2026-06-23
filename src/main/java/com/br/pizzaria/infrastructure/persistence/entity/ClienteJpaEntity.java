package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.TipoPerfil;
import jakarta.persistence.*;

/**
 * Entidade JPA: Cliente
 * PK natural: cpf_cliente (String) — conforme diagrama de classes.
 * Endereço mapeado como @Embedded para alinhar com o value object Endereco do domínio.
 * tipoPerfil persistido como EnumType.STRING para legibilidade no banco.
 */
@Entity
@Table(name = "clientes")
public class ClienteJpaEntity {

    @Id
    @Column(name = "cpf_cliente", length = 11)
    private String cpfCliente;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Embedded
    private EnderecoJpaEmbeddable endereco;

    @Column(name = "pontuacao")
    private Integer pontuacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil", length = 10)
    private TipoPerfil tipoPerfil;

    public ClienteJpaEntity() {}

    public String getCpfCliente()  { return cpfCliente; }
    public void setCpfCliente(String cpfCliente)   { this.cpfCliente  = cpfCliente; }
    public String getNome()        { return nome; }
    public void setNome(String nome)               { this.nome        = nome; }
    public String getTelefone()    { return telefone; }
    public void setTelefone(String telefone)       { this.telefone    = telefone; }
    public String getEmail()       { return email; }
    public void setEmail(String email)             { this.email       = email; }
    public String getSenha()       { return senha; }
    public void setSenha(String senha)             { this.senha       = senha; }
    public EnderecoJpaEmbeddable getEndereco()     { return endereco; }
    public void setEndereco(EnderecoJpaEmbeddable endereco) { this.endereco = endereco; }
    public Integer getPontuacao()  { return pontuacao; }
    public void setPontuacao(Integer pontuacao)    { this.pontuacao   = pontuacao; }
    public TipoPerfil getTipoPerfil()              { return tipoPerfil; }
    public void setTipoPerfil(TipoPerfil tipoPerfil){ this.tipoPerfil = tipoPerfil; }
}
