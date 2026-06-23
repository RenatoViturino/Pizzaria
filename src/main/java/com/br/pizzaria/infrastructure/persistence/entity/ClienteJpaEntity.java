package com.br.pizzaria.infrastructure.persistence.entity;

import com.br.pizzaria.domain.valueobject.TipoPerfil;
import jakarta.persistence.*;

/**
 * Entidade JPA: Cliente
 * PK natural: cpf_cliente (String) — conforme diagrama de classes.
 * tipoPerfil persistido como String (EnumType.STRING) para legibilidade no banco.
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

    // Endereço desnormalizado (value object Endereco mapeado inline)
    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cep", length = 8)
    private String cep;

    @Column(name = "pontuacao")
    private Integer pontuacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil", length = 10)
    private TipoPerfil tipoPerfil;

    public ClienteJpaEntity() {}

    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public Integer getPontuacao() { return pontuacao; }
    public void setPontuacao(Integer pontuacao) { this.pontuacao = pontuacao; }
    public TipoPerfil getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(TipoPerfil tipoPerfil) { this.tipoPerfil = tipoPerfil; }
}
