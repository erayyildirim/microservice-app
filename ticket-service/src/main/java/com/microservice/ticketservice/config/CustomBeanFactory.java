package com.microservice.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author erayy
 */
@EnableJpaRepositories(basePackages = {"com.microservice"})
@EnableElasticsearchRepositories(basePackages = {"com.microservice"})
@ComponentScan("com.microservice")
@Configuration
public class CustomBeanFactory {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
