package com.br.pizzaria.domain.port;

/**
 * Porta de saída (Output Port) — princípio da Arquitetura Hexagonal.
 * O domínio depende desta interface, nunca da implementação Kafka.
 * A infraestrutura (KafkaEventPublisher) implementa este contrato.
 *
 * Substitui FilaMensageria.java que estava incorretamente no domínio.
 */
public interface EventPublisher {

    /**
     * Publica um evento de domínio.
     *
     * @param topico  nome do tópico/fila destino
     * @param chave   chave de particionamento (ex: pedidoId, cpfCliente)
     * @param evento  payload do evento (record ou DTO serializável)
     */
    void publicar(String topico, String chave, Object evento);
}
