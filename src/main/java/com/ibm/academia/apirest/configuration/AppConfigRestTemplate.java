package com.ibm.academia.apirest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigRestTemplate {

    @Bean("banamexClient")
    public RestTemplate obtenerDatos(){ return new RestTemplate();}

}
