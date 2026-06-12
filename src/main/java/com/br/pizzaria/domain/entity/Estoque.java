package com.br.pizzaria.domain.entity;

import java.time.LocalDateTime;

public class Estoque {

    private Long idMovimento;
    private String tipoMovimento;
    private Integer quantidade;
    private LocalDateTime dataHora;
    private Long idProduto;

    public Estoque() {}

    public Estoque(String tipoMovimento, Integer quantidade, Long idProduto) {
        this.tipoMovimento = tipoMovimento;
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.dataHora = LocalDateTime.now();
    }

    public Long getIdMovimento() { return idMovimento; }
    public void setIdMovimento(Long idMovimento) { this.idMovimento = idMovimento; }
    public String getTipoMovimento() { return tipoMovimento; }
    public void setTipoMovimento(String tipoMovimento) { this.tipoMovimento = tipoMovimento; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public Long getIdProduto() { return idProduto; }
    public void setIdProduto(Long idProduto) { this.idProduto = idProduto; }
}
