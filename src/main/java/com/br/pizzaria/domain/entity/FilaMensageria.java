package com.br.pizzaria.domain.entity;

/**
 * Entidade de domínio: FilaMensageria
 * Representa a fila Kafka/RabbitMQ — conforme diagrama de classes
 */
public class FilaMensageria {

    private String nomeFila;
    private String tipo; // Kafka ou RabbitMQ

    public FilaMensageria() {}

    public FilaMensageria(String nomeFila, String tipo) {
        this.nomeFila = nomeFila;
        this.tipo = tipo;
    }

    public void publicarEvento() {
        // delegado para infraestrutura (producer Kafka)
    }

    public void consumirEvento() {
        // delegado para infraestrutura (consumer Kafka)
    }

    public String getNomeFila() { return nomeFila; }
    public void setNomeFila(String nomeFila) { this.nomeFila = nomeFila; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
