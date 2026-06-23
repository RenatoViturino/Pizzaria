package com.br.pizzaria.domain.entity;

/**
 * @deprecated Esta classe não pertence ao domínio.
 * O domínio não deve conhecer infraestrutura de mensageria.
 * Use a interface {@code domain.port.EventPublisher} para publicar eventos
 * e {@code infrastructure.messaging.KafkaEventPublisher} como implementação.
 * Esta classe será removida em breve.
 */
@Deprecated(since = "refactoring", forRemoval = true)
public class FilaMensageria {

    private FilaMensageria() {
        throw new UnsupportedOperationException(
            "FilaMensageria está depreciada. Use EventPublisher via injeção de dependência."
        );
    }
}
