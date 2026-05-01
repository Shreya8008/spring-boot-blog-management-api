package com.blogapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI blogApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blog Management REST API")
                        .description("A comprehensive RESTful API for blog management built with Spring Boot 3.x. " +
                                "Provides CRUD operations for blog posts, categories, and comments.")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Blog API Support")
                                .email("support@blogapi.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
