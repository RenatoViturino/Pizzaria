package com.br.pizzaria.domain.port;

/**
 * Porta de saída (Hexagonal Architecture): contrato para publicação de eventos de domínio.
 * O domínio depende apenas desta interface; a implementação concreta
 * ({@code KafkaEventPublisher}) fica na camada de infraestrutura.
 *
 * @param <T> tipo do evento de domínio
 */
public interface EventPublisher<T> {

    /**
     * Publica um evento de domínio no barramento de mensagens.
     *
     * @param topic  tópico de destino
     * @param event  objeto do evento
     */
    void publish(String topic, T event);
}
