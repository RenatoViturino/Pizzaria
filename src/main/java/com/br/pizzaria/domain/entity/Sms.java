package com.br.pizzaria.domain.entity;

import java.time.LocalDateTime;

/**
 * Entidade de domínio: Sms
 * PK gerada: idSms (Long)
 * Representa o registro de um SMS enviado ao cliente (ex: confirmação de pedido).
 */
public class Sms {

    private Long idSms;
    private String numero;
    private String mensagem;
    private LocalDateTime dataEnvio;

    public Sms() {}

    public Sms(String numero, String mensagem) {
        if (numero == null || numero.isBlank()) throw new IllegalArgumentException("Número de telefone obrigatório.");
        if (mensagem == null || mensagem.isBlank()) throw new IllegalArgumentException("Mensagem SMS obrigatória.");
        this.numero = numero;
        this.mensagem = mensagem;
        this.dataEnvio = LocalDateTime.now();
    }

    public Long getIdSms() { return idSms; }
    public void setIdSms(Long idSms) { this.idSms = idSms; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public LocalDateTime getDataEnvio() { return dataEnvio; }
}
