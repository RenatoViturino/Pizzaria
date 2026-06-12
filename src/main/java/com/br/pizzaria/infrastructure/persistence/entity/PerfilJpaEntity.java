package com.br.pizzaria.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perfis")
public class PerfilJpaEntity {

    @Id
    @Column(name = "tipo_perfil", length = 30)
    private String tipoPerfil;

    @Column
    private String regras;

    @Column
    private Integer desconto;

    public String getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(String tipoPerfil) { this.tipoPerfil = tipoPerfil; }
    public String getRegras() { return regras; }
    public void setRegras(String regras) { this.regras = regras; }
    public Integer getDesconto() { return desconto; }
    public void setDesconto(Integer desconto) { this.desconto = desconto; }
}
