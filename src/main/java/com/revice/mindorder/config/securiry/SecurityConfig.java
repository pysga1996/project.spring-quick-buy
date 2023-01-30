package com.revice.mindorder.config.securiry;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoderJwkSupport;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.Map;

@Log4j2
@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    private final AccessDeniedHandler accessDeniedHandler;

    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public SecurityConfig(
            Environment env,
            AccessDeniedHandler accessDeniedHandler,
            AuthenticationEntryPoint authenticationEntryPoint) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Bean
    @Primary
    public JwtDecoder customJwtDecoder() {
        NimbusJwtDecoderJwkSupport nimbusJwtDecoderJwkSupport = new NimbusJwtDecoderJwkSupport(this.jwkSetUri);
        nimbusJwtDecoderJwkSupport.setClaimSetConverter(new Converter<Map<String, Object>, Map<String, Object>>() {
            @Override
            public Map<String, Object> convert(Map<String, Object> stringObjectMap) {
                return null;
            }
        });
        return nimbusJwtDecoderJwkSupport;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest()
                .permitAll()
                .and()
                .csrf().disable()
                .cors()
                .and()
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> {
                    DefaultBearerTokenResolver bearerTokenResolver = new DefaultBearerTokenResolver();
                    bearerTokenResolver.setAllowUriQueryParameter(true);
                    httpSecurityOAuth2ResourceServerConfigurer
                            .jwt(jwtConfigurer -> {
                                jwtConfigurer.decoder(this.customJwtDecoder());
                            })
                            .bearerTokenResolver(bearerTokenResolver)
                            .accessDeniedHandler(this.accessDeniedHandler)
                            .authenticationEntryPoint(this.authenticationEntryPoint);
                });
    }
}
