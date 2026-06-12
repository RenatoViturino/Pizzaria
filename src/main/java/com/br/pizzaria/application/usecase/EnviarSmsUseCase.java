package com.br.pizzaria.application.usecase;

import com.br.pizzaria.application.dto.request.EnviarSmsRequest;
import com.br.pizzaria.application.dto.response.SmsResponse;

public interface EnviarSmsUseCase {
    SmsResponse executar(EnviarSmsRequest request);
}
