package com.ecommerce.account.configuration.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for user-related error messages and codes.
 * <p>
 * This class maps error configurations from the application properties. Each nested {@code ErrorDetail} object
 * represents a specific error type with its associated code and message.
 * </p>
 * <p>
 * For example, the {@code invalidPhoneNumber} property corresponds to the error configuration for
 * invalid phone numbers, and its values can be accessed using {@code getInvalidPhoneNumber()}.
 * </p>
 * <p>
 * To add more error configurations, simply define additional {@code ErrorDetail} properties and
 * map them to the corresponding keys in the application properties.
 * </p>
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Configuration
@ConfigurationProperties(prefix = "user.error")
@Getter
@Setter
public class UserErrorConfig {

    private ErrorDetail invalidPhoneNumber;
    @Getter
    @Setter
    public static class ErrorDetail {
        private Long code;
        private String message;

    }
}
