package com.br.pizzaria;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = PizzariaApplication.class)
@ActiveProfiles("test")
class PizzariaApplicationTests {

    @Test
    void contextLoads() {
        // verifica que o contexto Spring sobe sem erros
    }
}
