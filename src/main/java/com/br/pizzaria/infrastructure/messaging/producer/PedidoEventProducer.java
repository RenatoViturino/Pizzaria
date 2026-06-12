package com.br.pizzaria.infrastructure.messaging.producer;

import com.br.pizzaria.domain.event.PedidoCriadoEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Produtor Kafka: publica eventos de domínio no tópico de pedidos.
 */
@Component
public class PedidoEventProducer {

    private static final String TOPIC_PEDIDO_CRIADO = "pizzaria.pedido.criado";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publicarPedidoCriado(PedidoCriadoEvent evento) {
        kafkaTemplate.send(TOPIC_PEDIDO_CRIADO, evento.pedidoId().toString(), evento);
    }
}
