package com.br.pizzaria;

import com.br.pizzaria.infrastructure.messaging.producer.PedidoEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

/**
 * Teste de contexto Spring Boot.
 * MockitoBean necessário para:
 *  - PedidoEventProducer: evita conexão real com Kafka no teste.
 *  - UserDetailsService: satisfaz a dependência do JwtAuthFilter sem banco real.
 */
@SpringBootTest(classes = PizzariaApplication.class)
@ActiveProfiles("test")
class PizzariaApplicationTests {

    @MockitoBean
    private PedidoEventProducer pedidoEventProducer;

    @MockitoBean
    private UserDetailsService userDetailsService;

    @Test
    void contextLoads() {
        // Valida que o contexto Spring sobe sem erros
    }
}
