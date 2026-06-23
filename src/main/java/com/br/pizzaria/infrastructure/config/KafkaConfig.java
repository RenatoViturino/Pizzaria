package com.br.pizzaria.infrastructure.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuração Kafka:
 * - Declara os tópicos do projeto.
 * - A configuração de ConsumerFactory e ListenerContainerFactory foi removida:
 *   o Spring Boot auto-configura ambos a partir do application.yml,
 *   eliminando o uso do JsonDeserializer deprecated e o WARN de compilação.
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
