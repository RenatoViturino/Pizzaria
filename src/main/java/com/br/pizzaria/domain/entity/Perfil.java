package com.br.pizzaria.domain.entity;

public class Perfil {

    private String tipoPerfil;
    private String regras;
    private Integer desconto;

    public Perfil() {}

    public Perfil(String tipoPerfil, String regras, Integer desconto) {
        this.tipoPerfil = tipoPerfil;
        this.regras = regras;
        this.desconto = desconto;
    }

    public String getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(String tipoPerfil) { this.tipoPerfil = tipoPerfil; }
    public String getRegras() { return regras; }
    public void setRegras(String regras) { this.regras = regras; }
    public Integer getDesconto() { return desconto; }
    public void setDesconto(Integer desconto) { this.desconto = desconto; }
}
