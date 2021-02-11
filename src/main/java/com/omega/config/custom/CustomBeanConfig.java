package com.omega.config.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@SuppressWarnings("deprecation")
public class CustomBeanConfig {

    @Value("${custom.auth-service}")
    private String checkTokenEndpoint;

    @Value("${custom.client-id}")
    private String clientId;

    @Value("${custom.client-secret}")
    private String clientSecret;

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Hibernate5Module());
        return objectMapper;
    }

    @Bean
    @Primary
    public ResourceServerTokenServices tokenService() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setClientId(clientId);
        remoteTokenServices.setClientSecret(clientSecret);
        remoteTokenServices.setCheckTokenEndpointUrl(checkTokenEndpoint);
        return remoteTokenServices;
    }
}
