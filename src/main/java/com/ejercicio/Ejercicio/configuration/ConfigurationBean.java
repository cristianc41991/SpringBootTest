package com.ejercicio.Ejercicio.configuration;


import com.ejercicio.Ejercicio.repository.PersonaRepository;
import com.ejercicio.Ejercicio.service.PersonaService;
import com.ejercicio.Ejercicio.service.PersonaServiceImplement;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigurationBean {



    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        dataSourceBuilder.url("jdbc:h2:mem:ejercicio");
        return dataSourceBuilder.build();

    }
}
