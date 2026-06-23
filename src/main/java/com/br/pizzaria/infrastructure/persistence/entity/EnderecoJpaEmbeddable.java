package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * @Embeddable correspondente ao value object Endereco (record) do domínio.
 * Mapeado inline na tabela clientes — sem tabela separada.
 */
@Embeddable
public class EnderecoJpaEmbeddable {

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

    public EnderecoJpaEmbeddable() {}

    public EnderecoJpaEmbeddable(String logradouro, String numero, String complemento,
                                  String bairro, String cidade, String estado, String cep) {
        this.logradouro  = logradouro;
        this.numero      = numero;
        this.complemento = complemento;
        this.bairro      = bairro;
        this.cidade      = cidade;
        this.estado      = estado;
        this.cep         = cep;
    }

    public String getLogradouro()  { return logradouro; }
    public void setLogradouro(String logradouro)  { this.logradouro  = logradouro; }
    public String getNumero()      { return numero; }
    public void setNumero(String numero)          { this.numero      = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento){ this.complemento = complemento; }
    public String getBairro()      { return bairro; }
    public void setBairro(String bairro)          { this.bairro      = bairro; }
    public String getCidade()      { return cidade; }
    public void setCidade(String cidade)          { this.cidade      = cidade; }
    public String getEstado()      { return estado; }
    public void setEstado(String estado)          { this.estado      = estado; }
    public String getCep()         { return cep; }
    public void setCep(String cep)                { this.cep         = cep; }
}
