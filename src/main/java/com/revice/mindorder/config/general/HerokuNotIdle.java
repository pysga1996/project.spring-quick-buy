package com.revice.mindorder.config.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class HerokuNotIdle {

  private static final Logger LOG = LoggerFactory.getLogger(HerokuNotIdle.class);

//  @Scheduled(fixedDelay = 120000)
//  public void herokuNotIdle() {
//    LOG.debug("Heroku not idle execution");
//    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.getForObject("https://spring-quick-buy.herokuapp.com", String.class);
//  }
}
