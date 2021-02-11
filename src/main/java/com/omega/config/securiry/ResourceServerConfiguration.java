package com.omega.config.securiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@SuppressWarnings("deprecation")
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  private final ResourceServerTokenServices resourceServerTokenServices;

  @Autowired
  public ResourceServerConfiguration(ResourceServerTokenServices resourceServerTokenServices) {
    this.resourceServerTokenServices = resourceServerTokenServices;
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.tokenServices(resourceServerTokenServices);
  }

  @Override
  public void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest().permitAll()
        .and().cors()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

}
