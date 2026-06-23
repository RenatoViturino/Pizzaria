package com.br.pizzaria;

import com.br.pizzaria.infrastructure.messaging.producer.PedidoEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class PizzariaApplicationTest {

    /*
     * Fix: @MockitoBean com subclass mock (SUBCLASS mode) é mais compatível com
     * Java 25. O ByteBuddy 1.16.1+ lida com a instrumentação corretamente, mas
     * manter o mock aqui garante que Kafka não tenta conectar durante o teste.
     */
    @MockitoBean
    private PedidoEventProducer pedidoEventProducer;

    @Test
    void contextLoads() {
        // Valida que o contexto Spring sobe corretamente
    }
}
