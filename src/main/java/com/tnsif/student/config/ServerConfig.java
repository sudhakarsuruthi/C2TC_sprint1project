package com.tnsif.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.server.*;
import org.springframework.boot.web.servlet.server.*;

@Configuration
public class ServerConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> customPort() {
        return factory -> factory.setPort(3000);
    }
}

