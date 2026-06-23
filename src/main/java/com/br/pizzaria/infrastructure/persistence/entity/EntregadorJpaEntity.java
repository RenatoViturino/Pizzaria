package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

/**
 * Entidade JPA: Entregador
 * Tabela separada de funcionarios — especialização conforme diagrama de classes.
 */
@Entity
@Table(name = "entregadores")
public class EntregadorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entregador")
    private Long idEntregador;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(name = "tipo_veiculo", nullable = false, length = 20)
    private String tipoVeiculo;  // MOTO, CARRO, BICICLETA

    @Column(nullable = false)
    private Boolean ativo = true;

    public Long getIdEntregador() { return idEntregador; }
    public void setIdEntregador(Long idEntregador) { this.idEntregador = idEntregador; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipoVeiculo() { return tipoVeiculo; }
    public void setTipoVeiculo(String tipoVeiculo) { this.tipoVeiculo = tipoVeiculo; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
