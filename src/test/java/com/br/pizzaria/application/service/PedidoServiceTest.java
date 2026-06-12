package com.br.pizzaria.application.service;

import com.br.pizzaria.domain.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testes unitários do PedidoService com Mockito.
 */
@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        pedidoService = new PedidoService(pedidoRepository);
    }

    @Test
    @DisplayName("Deve ser instanciado com sucesso")
    void deveInstanciarComSucesso() {
        assertThat(pedidoService).isNotNull();
    }
}
