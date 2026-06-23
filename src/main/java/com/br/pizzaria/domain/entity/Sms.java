package com.br.pizzaria.domain.entity;

import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entidade de domínio: Sms
 * PK gerada: idSms (Long)
 */
public class Sms {

    @Setter
    private Long idSms;
    private String numero;
    private String mensagem;
    private LocalDateTime dataEnvio;

    public Sms() {}

    public Sms(String numero, String mensagem) {
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
