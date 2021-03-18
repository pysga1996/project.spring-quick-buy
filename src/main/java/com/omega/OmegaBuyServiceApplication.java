package com.omega;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Log4j2
@SpringBootApplication(scanBasePackages = "com.omega")
@EnableJpaRepositories(basePackages = "com.omega.repositories")
public class OmegaBuyServiceApplication {

    public static void main(String[] args) {
//    System.setProperty("server.servlet.context-path", "/omega-buy");
//    System.setProperty("spring.jpa.open-in-view", "false");
        SpringApplication.run(OmegaBuyServiceApplication.class, args);
    }

}
