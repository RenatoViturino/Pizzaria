package com.br.pizzaria.infrastructure.messaging;

import com.br.pizzaria.domain.port.EventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Implementação da porta EventPublisher usando Apache Kafka.
 * O domínio conhece apenas a interface — nunca esta classe.
 *
 * Registrada como @Component para injeção pelo Spring no lugar de FilaMensageria.
 */
@Component
public class KafkaEventPublisher implements EventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicar(String topico, String chave, Object evento) {
        kafkaTemplate.send(topico, chave, evento);
    }
}
