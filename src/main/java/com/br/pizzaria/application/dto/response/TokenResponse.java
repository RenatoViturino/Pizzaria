package com.br.pizzaria.application.dto.response;

public record TokenResponse(
        String accessToken,
        String tokenType,
        Long expiresIn
) {
    public TokenResponse(String accessToken) {
        this(accessToken, "Bearer", 86400L);
    }
}
