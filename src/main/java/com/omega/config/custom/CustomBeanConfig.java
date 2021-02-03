package com.omega.config.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@SuppressWarnings("deprecation")
public class CustomBeanConfig {

    @Bean
    @Primary
    public ResourceServerTokenServices tokenService() {
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setClientId("fooClientIdPassword");
        remoteTokenServices.setClientSecret("secret");
        remoteTokenServices.setCheckTokenEndpointUrl("");
        return remoteTokenServices;
    }
}
