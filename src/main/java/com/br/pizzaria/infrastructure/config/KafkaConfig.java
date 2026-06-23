package com.br.pizzaria.infrastructure.config;

import com.br.pizzaria.domain.event.PedidoCriadoEvent;
import com.br.pizzaria.domain.event.PedidoStatusAlteradoEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuração Kafka:
 * - Declara os tópicos do projeto
 * - Registra o kafkaListenerContainerFactory referenciado em @KafkaListener
 *   (sem este bean o container falha no startup com NoSuchBeanDefinitionException)
 */
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers:localhost:9092}")
    private String bootstrapServers;

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

    /**
     * ConsumerFactory genérico para eventos de domínio do projeto.
     * trusted-packages configurado aqui também (além do application.yml)
     * para garantir que o factory não rejeite os tipos ao desserializar.
     */
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        JsonDeserializer<Object> deserializer = new JsonDeserializer<>(Object.class);
        deserializer.addTrustedPackages(
                "com.br.pizzaria.domain.event",
                "com.br.pizzaria.domain.valueobject"
        );
        deserializer.setUseTypeHeaders(false);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "pizzaria-group");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    /**
     * Bean explícito referenciado em:
     *   @KafkaListener(containerFactory = "kafkaListenerContainerFactory")
     * Sem este bean o Spring falha com NoSuchBeanDefinitionException no startup.
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
