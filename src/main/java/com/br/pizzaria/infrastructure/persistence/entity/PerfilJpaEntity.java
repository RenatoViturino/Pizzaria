package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil")
public class PerfilJpaEntity {

    @Id
    @Column(name = "tipo_perfil", length = 20)
    private String tipoPerfil;

    @Column(name = "regras", nullable = false, length = 500)
    private String regras;

    @Column(name = "desconto", nullable = false)
    private Integer desconto;

    public PerfilJpaEntity() {}

    public String getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(String tipoPerfil) { this.tipoPerfil = tipoPerfil; }
    public String getRegras() { return regras; }
    public void setRegras(String regras) { this.regras = regras; }
    public Integer getDesconto() { return desconto; }
    public void setDesconto(Integer desconto) { this.desconto = desconto; }
}
