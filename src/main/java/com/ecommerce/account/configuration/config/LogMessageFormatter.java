package com.ecommerce.account.configuration.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * A custom log message formatter that masks sensitive data in log messages before they are written to the log.
 * This formatter is designed to mask email addresses, passwords, mobile numbers or more fields in the future.
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
public class LogMessageFormatter extends ClassicConverter {

    /**
     * Converts the log message by masking sensitive data.
     *
     * @param event The log event.
     * @return The formatted log message with sensitive data masked.
     */
    @Override
    public String convert(ILoggingEvent event) {
        String logMessage = event.getFormattedMessage();

        // Mask email addresses (e.g: example@gmail.com becomes ****@gmail.com)
        logMessage = logMessage.replaceAll("email: \"(.*?)@(.*?)\"", "email: \"****@$2\"");

        // Mask passwords (e.g: password: "secret" becomes password: "****")
        logMessage = logMessage.replaceAll("password: \"(.*?)\"", "password: \"****\"");

        // Mask mobile numbers (e.g: mobile: "0987654321" becomes mobile: "********21")
        logMessage = logMessage.replaceAll("mobile: \"(.*?)(\\d{2})\"", "mobile: \"********$2\"");

        return logMessage;
    }
}