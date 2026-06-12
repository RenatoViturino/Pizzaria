package com.br.pizzaria.application.dto.request;

import jakarta.validation.constraints.*;
import java.util.List;

/**
 * DTO de entrada: criar Pedido
 * cpfCliente referencia a PK natural do cliente
 */
public record CriarPedidoRequest(
        @NotBlank @Size(min = 11, max = 11) String cpfCliente,
        @NotEmpty List<ItemPedidoRequest> itens
) {}
