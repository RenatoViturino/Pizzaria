package com.br.pizzaria.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuração dos tópicos Kafka.
 */
@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topicPedidoCriado() {
        return TopicBuilder.name("pizzaria.pedido.criado")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicPedidoStatus() {
        return TopicBuilder.name("pizzaria.pedido.status")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
