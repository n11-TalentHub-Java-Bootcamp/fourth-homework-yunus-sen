package com.yunussen.debtpaymentws.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {ConfigurationContains.BASE_PASKAGE})
public class WebApplicationConfiguration {

    public WebApplicationConfiguration(){}

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
