package com.br.pizzaria.infrastructure.mail;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Serviço de envio de e-mail (confirmação de pedido, notificações).
 */
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarConfirmacaoPedido(String destinatario, String numeroPedido) {
        // TODO: implementar template de e-mail
    }
}
