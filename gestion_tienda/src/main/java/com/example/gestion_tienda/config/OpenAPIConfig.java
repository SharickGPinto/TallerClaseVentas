package com.example.gestion_tienda.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
@Bean
public OpenAPI cusOpenAPI(){
    return new OpenAPI()
            .info(new Info()
                    .title("GESTION TIENDA")
                    .version("1.0")
                    .description("Tablas de los atributos de VENTA, PRODUCTO Y DETALLE VENTA")
            );
}
}
