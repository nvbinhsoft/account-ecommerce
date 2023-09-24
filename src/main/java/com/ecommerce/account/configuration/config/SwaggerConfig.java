package com.ecommerce.account.configuration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for Swagger API documentation (Swagger 3).
 * This class configures the Swagger Docket bean and provides information about the API.
 *
 *@author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configures the Swagger Docket bean.
     * This bean determines which controllers and paths are included in the API documentation.
     * In this configuration, all paths within the "com.ecommerce.account.controller" package are included.
     *
     * @return a configured Docket instance.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ecommerce.account.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Provides general information about the API for Swagger's API documentation.
     * This includes the title, description, version, contact information, and license details.
     *
     * @return an ApiInfo instance containing details about the API.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("N/A")
                .description("N/A")
                .version("1.0.0")
                .contact(new Contact("N/A", "www.ecommerce.com.vn", "your@email.com"))
                .license("N/A")
                .licenseUrl("N/A")
                .build();
    }
}
