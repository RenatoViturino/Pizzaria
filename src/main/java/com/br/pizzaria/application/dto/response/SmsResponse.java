package com.br.pizzaria.application.dto.response;

import java.time.LocalDateTime;

public record SmsResponse(
        Long idSms,
        String numero,
        String mensagem,
        LocalDateTime dataEnvio
) {}
