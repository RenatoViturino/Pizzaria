package com.br.pizzaria.application.dto.response;

import java.time.LocalDateTime;

/**
 * DTO de resposta: SMS
 * PK: idSms (Long) — conforme diagrama
 */
public record SmsResponse(
        Long idSms,
        String numero,
        String mensagem,
        LocalDateTime dataEnvio
) {}
