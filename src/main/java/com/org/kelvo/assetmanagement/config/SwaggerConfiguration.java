package com.org.kelvo.assetmanagement.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Asset Service")
                        .description("Asset management system service")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Kelvin")
                                .url("https://kelvinCode.com")
                                .email("munyuakevin@gmail.com"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("Open Source"))
                );
    }
}
