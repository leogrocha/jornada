package com.challenge.jornada.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Usando allowedOriginPatterns em vez de allowedOrigins
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adicione os métodos HTTP permitidos
                .allowedHeaders("*") // Adicione os cabeçalhos permitidos
                .allowCredentials(true) // Permitir envio de cookies
                .maxAge(3600); // Define o tempo máximo de cache para a resposta do CORS
    }
}
