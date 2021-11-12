package com.edu.utadeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.edu.utadeo.modelEntity.*;

@SpringBootApplication
public class DororoApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DororoApplication.class, args);
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Demonio.class);
        config.exposeIdsFor(Parte.class);
        config.exposeIdsFor(Lugar.class);
        config.exposeIdsFor(Pelea.class);
    }

}
