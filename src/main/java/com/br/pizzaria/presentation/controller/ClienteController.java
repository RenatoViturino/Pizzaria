package com.br.pizzaria.presentation.controller;

import com.br.pizzaria.application.dto.request.CriarClienteRequest;
import com.br.pizzaria.application.dto.response.ClienteResponse;
import com.br.pizzaria.application.usecase.cliente.CriarClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST: endpoints de Cliente.
 * Camada de apresentação — sem lógica de negócio.
 */
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criar(@RequestBody CriarClienteRequest request) {
        ClienteResponse response = criarClienteUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
