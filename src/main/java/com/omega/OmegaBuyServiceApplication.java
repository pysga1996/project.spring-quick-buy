package com.omega;

import com.omega.listener.DataSeedingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.omega")
@EnableJpaRepositories(basePackages = "com.omega.repositories")
public class OmegaBuyServiceApplication {

  private DataSeedingListener dataSeedingListener;

  @Autowired
  public void setDataSeedingListener(DataSeedingListener dataSeedingListener) {
    this.dataSeedingListener = dataSeedingListener;
  }

  public static void main(String[] args) {
//    System.setProperty("server.servlet.context-path", "/omega-buy");
//    System.setProperty("spring.jpa.open-in-view", "false");
    SpringApplication.run(OmegaBuyServiceApplication.class, args);
  }

//  @EventListener(ContextRefreshedEvent.class)
//  public void dataSeeding() {
//    dataSeedingListener.onApplicationEvent();
//  }

}
