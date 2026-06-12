package com.br.pizzaria.application.dto.response;

public record PerfilResponse(
        String tipoPerfil,
        String regras,
        Integer desconto
) {}
