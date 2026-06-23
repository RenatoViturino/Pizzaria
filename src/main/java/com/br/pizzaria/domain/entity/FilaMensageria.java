package com.br.pizzaria.domain.entity;

/**
 * @deprecated Esta classe foi substituída pela interface EventPublisher em
 * com.br.pizzaria.domain.port.EventPublisher e pela implementação
 * com.br.pizzaria.infrastructure.messaging.KafkaEventPublisher.
 *
 * Mantida temporariamente para evitar quebra de compilação em código que
 * ainda a referencie. Remover após migração completa.
 *
 * @see com.br.pizzaria.domain.port.EventPublisher
 */
@Deprecated(since = "refactor/event-publisher", forRemoval = true)
public class FilaMensageria {

    private String nomeFila;
    private String tipo;

    public FilaMensageria() {}

    public FilaMensageria(String nomeFila, String tipo) {
        this.nomeFila = nomeFila;
        this.tipo = tipo;
    }

    /** @deprecated use {@link com.br.pizzaria.domain.port.EventPublisher#publicar} */
    @Deprecated(forRemoval = true)
    public void publicarEvento() {
        throw new UnsupportedOperationException(
            "Use EventPublisher.publicar() via injeção de dependência."
        );
    }

    /** @deprecated use {@link com.br.pizzaria.domain.port.EventPublisher#publicar} */
    @Deprecated(forRemoval = true)
    public void consumirEvento() {
        throw new UnsupportedOperationException(
            "Use @KafkaListener na camada de infraestrutura."
        );
    }

    public String getNomeFila() { return nomeFila; }
    public void setNomeFila(String nomeFila) { this.nomeFila = nomeFila; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
