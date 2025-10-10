package com.itb.inf2fm.innova.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;  
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class CorsConfiguration implements WebMvcConfigurer{
    //Configurações de CORS podem ser adicionadas aqui no futuro

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       
        registry.addMapping("/**")
                .allowedOrigins("*")// Permitir todas as origens (ajuste conforme necessário)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT", "PATCH");
                
              
    }

}
