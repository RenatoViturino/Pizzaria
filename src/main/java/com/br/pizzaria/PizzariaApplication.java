package com.br.pizzaria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Entry point da aplicação Pizzaria.
 *
 * Arquitetura em camadas:
 *   presentation  → controllers REST
 *   application   → use-cases / services
 *   domain        → entidades, value objects, eventos, portas (interfaces)
 *   infrastructure→ adapters JPA, Kafka producers/consumers, mail, SMS
 *
 * @SpringBootApplication já habilita:
 *   - @Configuration
 *   - @EnableAutoConfiguration (DataSource, JPA, Kafka, Mail via application.yml)
 *   - @ComponentScan em com.br.pizzaria e todos os sub-pacotes
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.br.pizzaria.infrastructure.persistence.repository")
@EntityScan(basePackages = "com.br.pizzaria.infrastructure.persistence.entity")
@EnableKafka
public class PizzariaApplication {

    private static final Logger log = LoggerFactory.getLogger(PizzariaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PizzariaApplication.class, args);
        log.info("=======================================================");
        log.info("  Pizzaria API iniciada — http://localhost:8080");
        log.info("  Actuator  — http://localhost:8080/actuator/health");
        log.info("=======================================================");
    }
}
