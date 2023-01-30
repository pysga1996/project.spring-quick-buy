package com.revice.mindorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.revice.mindorder", exclude = {
    OAuth2ResourceServerAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.revice.mindorder.repositories")
@EnableTransactionManagement
@EnableJpaAuditing
public class MindOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MindOrderServiceApplication.class, args);
    }

}
