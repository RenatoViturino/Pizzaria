package com.br.pizzaria.application.service;

import com.br.pizzaria.application.dto.request.EnviarSmsRequest;
import com.br.pizzaria.application.dto.response.SmsResponse;
import com.br.pizzaria.application.usecase.EnviarSmsUseCase;
import com.br.pizzaria.domain.entity.Sms;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements EnviarSmsUseCase {

    // Stub: substituir por integração real (ex: Twilio, AWS SNS)
    @Override
    public SmsResponse executar(EnviarSmsRequest request) {
        Sms sms = new Sms(request.numero(), request.mensagem());
        // TODO: chamar gateway de SMS externo
        return new SmsResponse(null, sms.getNumero(), sms.getMensagem(), sms.getDataEnvio());
    }
}
