package com.coderhouse.finalEcommerce.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.webmvc.api.OpenApiResource;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce Carabajal - Coderhouse")
                        .version("1.0.0")
                        .description("API para el proyecto de e-commerce final")
                        .contact(new Contact()
                                .name("Marcelo Carabajal")
                                .email("marcelocarabajalok@gmail.com")
                                .url("https://coderhouse.com.ar"))
                        .license(new License()
                                .name("Licencia")
                                .url("https://github.com/MarceloCarabajal/java_62940/blob/main/LICENSE"))
                )
                .servers(List.of(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor Local")));

    }
}
