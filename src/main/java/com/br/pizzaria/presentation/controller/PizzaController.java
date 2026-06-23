package com.br.pizzaria.presentation.controller;

import com.br.pizzaria.application.dto.response.ProdutoResponse;
import com.br.pizzaria.application.usecase.pizza.CriarPizzaUseCase;
import com.br.pizzaria.domain.entity.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST: endpoints de Pizza (cardápio).
 */
@RestController
@RequestMapping("/api/v1/pizzas")
public class PizzaController {

    private final CriarPizzaUseCase criarPizzaUseCase;

    public PizzaController(CriarPizzaUseCase criarPizzaUseCase) {
        this.criarPizzaUseCase = criarPizzaUseCase;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody Produto request) {
        ProdutoResponse response = criarPizzaUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
