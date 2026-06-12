package com.br.pizzaria.presentation.controller;

import com.br.pizzaria.application.dto.request.CriarPedidoRequest;
import com.br.pizzaria.application.dto.response.PedidoResponse;
import com.br.pizzaria.application.usecase.pedido.CriarPedidoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST: endpoints de Pedido.
 */
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody CriarPedidoRequest request) {
        PedidoResponse response = criarPedidoUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
