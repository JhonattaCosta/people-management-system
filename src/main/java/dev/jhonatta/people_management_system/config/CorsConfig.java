package dev.jhonatta.people_management_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CorsConfig {

    public  void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")//URL do React em desenvolvimento
                .allowedMethods("GET","POST","PUT","DELETE","PATCH");
    }
}
