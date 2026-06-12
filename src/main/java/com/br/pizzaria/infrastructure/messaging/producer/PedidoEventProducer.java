package com.br.pizzaria.infrastructure.messaging.producer;

import com.br.pizzaria.domain.event.PedidoCriadoEvent;
import com.br.pizzaria.domain.event.PedidoStatusAlteradoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PedidoEventProducer {

    private static final Logger log = LoggerFactory.getLogger(PedidoEventProducer.class);
    private static final String TOPIC_CRIADO = "pizzaria.pedido.criado";
    private static final String TOPIC_STATUS = "pizzaria.pedido.status";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @EventListener
    public void onPedidoCriado(PedidoCriadoEvent event) {
        log.info("[KAFKA] Publicando PedidoCriadoEvent: pedido={}", event.idPedido());
        kafkaTemplate.send(TOPIC_CRIADO, event.idPedido().toString(), event);
    }

    @EventListener
    public void onPedidoStatusAlterado(PedidoStatusAlteradoEvent event) {
        log.info("[KAFKA] Publicando PedidoStatusAlteradoEvent: pedido={} status={}",
                event.idPedido(), event.novoStatus());
        kafkaTemplate.send(TOPIC_STATUS, event.idPedido().toString(), event);
    }
}
