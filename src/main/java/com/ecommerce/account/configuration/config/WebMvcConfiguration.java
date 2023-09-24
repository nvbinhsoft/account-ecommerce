package com.ecommerce.account.configuration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC Configuration class.
 * This class provides additional configurations for the Spring Web MVC framework.
 * It is specifically used to register custom interceptors to the application context.
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private CorrelationInterceptor correlationInterceptor;

    /**
     * Registers custom interceptors to the InterceptorRegistry.
     * In this configuration, the CorrelationInterceptor is added to the registry,
     * ensuring it will be applied to incoming requests.
     *
     * @param registry the InterceptorRegistry to which interceptors are added.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(correlationInterceptor);
    }
}
