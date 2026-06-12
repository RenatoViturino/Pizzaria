package com.br.pizzaria.domain.entity;

public class FilaMensageria {

    private String nomeFila;
    private String tipo;

    public FilaMensageria() {}

    public FilaMensageria(String nomeFila, String tipo) {
        this.nomeFila = nomeFila;
        this.tipo = tipo;
    }

    public void publicarEvento() {}
    public void consumirEvento() {}

    public String getNomeFila() { return nomeFila; }
    public void setNomeFila(String nomeFila) { this.nomeFila = nomeFila; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
