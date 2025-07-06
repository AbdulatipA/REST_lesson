package org.example.rest_lesson.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST API для управления заказами")
                        .version("1.0")
                        .description("Пример документации REST API на SpringBoot с Open Api 3"));
    }
}
