package com.proyecto.spring.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
    @Bean
    public OpenAPI StudentOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Users API")
                .description("Documentación de la Users API")
                .version("v1.0")
                .contact(new Contact().name("Grupo 1").
                        url("https://antoniosantos.es").email("antonio@santos.es")) //*******
                .license(new License().name("LICENSE").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("Descripcion del proyecto")
                .url("https://miproyecto.es"));
    }
}
