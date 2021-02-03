package com.omega.config.securiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Bean(name = "authenticationManagerBean")
  @Override
  public AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Autowired
//  public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder() )
//                .withUser("john").password(passwordEncoder().encode("123")).roles("USER").and()
//                .withUser("tom").password(passwordEncoder().encode("111")).roles("ADMIN").and()
//                .withUser("user1").password(passwordEncoder().encode("pass")).roles("USER").and()
//                .withUser("admin").password(passwordEncoder().encode("nimda")).roles("ADMIN");
//    auth.userDetailsService(userDetailsService);
//  }
}
