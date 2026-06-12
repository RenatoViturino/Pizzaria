package com.br.pizzaria.infrastructure.messaging.consumer;

import com.br.pizzaria.domain.event.PedidoStatusAlteradoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumidor Kafka: processa eventos de atualização de status do pedido.
 */
@Component
public class PedidoStatusConsumer {

    private static final String TOPIC = "pizzaria.pedido.status";
    private static final String GROUP_ID = "pizzaria-group";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID)
    public void consumir(PedidoStatusAlteradoEvent evento) {
        // TODO: acionar use case de atualização de status
    }
}
