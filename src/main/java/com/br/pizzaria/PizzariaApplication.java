package com.br.pizzaria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point da aplicação Pizzaria.
 *
 * Arquitetura em camadas:
 *   presentation  → controllers REST
 *   application   → use-cases / services
 *   domain        → entidades, value objects, eventos, portas (interfaces)
 *   infrastructure→ adapters JPA, Kafka producers/consumers, mail, SMS
 *
 * @SpringBootApplication habilita:
 *   - @Configuration
 *   - @EnableAutoConfiguration  (DataSource, JPA, Kafka, Mail via application.yml)
 *   - @ComponentScan em com.br.pizzaria e todos os sub-pacotes
 *
 * Obs: @EnableJpaRepositories, @EntityScan e @EnableKafka são
 * auto-configurados pelo Spring Boot quando as dependências estão
 * no classpath — anotacões explícitas são desnecessárias e causam
 * erros de compilacão no Spring Boot 4.x.
 */
@SpringBootApplication
public class PizzariaApplication {

    private static final Logger log = LoggerFactory.getLogger(PizzariaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PizzariaApplication.class, args);
        log.info("=======================================================");
        log.info("  Pizzaria API iniciada — http://localhost:8080");
        log.info("  Actuator  — http://localhost:8080/actuator/health");
        log.info("  Swagger   — http://localhost:8080/swagger-ui.html");
        log.info("=======================================================");
    }
}
