package com.br.pizzaria.infrastructure.messaging.consumer;

import com.br.pizzaria.domain.event.PedidoStatusAlteradoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoStatusConsumer {

    private static final Logger log = LoggerFactory.getLogger(PedidoStatusConsumer.class);

    @KafkaListener(
            topics = "pizzaria.pedido.status",
            groupId = "pizzaria-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumir(PedidoStatusAlteradoEvent event) {
        log.info("[KAFKA] Status do pedido {} alterado: {} -> {}",
                event.idPedido(), event.statusAnterior(), event.novoStatus());
        // TODO: disparar SMS/email ao cliente conforme novoStatus
    }
}
