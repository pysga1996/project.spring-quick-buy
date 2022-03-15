package com.revice.mindorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.revice.mindorder", exclude = {
    OAuth2ResourceServerAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.revice.mindorder.repositories")
public class MindOrderServiceApplication {

    public static void main(String[] args) {
//    System.setProperty("server.servlet.context-path", "/mind-order");
//    System.setProperty("spring.jpa.open-in-view", "false");
        SpringApplication.run(MindOrderServiceApplication.class, args);
    }

}
