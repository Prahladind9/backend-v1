package edu.prao.workmotion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkMotionApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkMotionApplication.class, args);
    }

    @Bean
    public OpenAPI getOpenApiDocumentation(
            @Value("${api.common.title}") String apiTitle,
            @Value("${api.common.version}") String apiVersion) {
        return new OpenAPI().info(new Info().title(apiTitle).version(apiVersion));
    }
}
