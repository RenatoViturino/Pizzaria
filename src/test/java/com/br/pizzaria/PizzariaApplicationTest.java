package com.br.pizzaria;

import com.br.pizzaria.infrastructure.messaging.producer.PedidoEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class PizzariaApplicationTest {

    // Evita conexão real com Kafka durante o teste de contexto
    @MockitoBean
    private PedidoEventProducer pedidoEventProducer;

    @Test
    void contextLoads() {
        // Valida que o contexto Spring sobe corretamente
    }
}
