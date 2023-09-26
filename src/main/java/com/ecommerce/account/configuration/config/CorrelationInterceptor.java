package com.ecommerce.account.configuration.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;
import org.springframework.web.servlet.ModelAndView;

/**
 * An interceptor for handling correlation identifiers in incoming HTTP requests.
 * This interceptor is responsible for extracting or generating a correlation ID from the HTTP request
 * and associating it with the logging context using the Mapped Diagnostic Context (MDC).
 *
 * @author [Binh Nguyen Van]
 * @since 2023-09-24
 */
@Component
public class CorrelationInterceptor implements HandlerInterceptor {
    private static final String CORRELATION_ID_HEADER = "X-Correlation-ID";
    private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";


    /**
     * Called before the execution of the handler method. Retrieves or generates a correlation ID
     * from the incoming HTTP request and associates it with the logging context using MDC.
     *
     * @param request  The incoming HTTP request.
     * @param response The HTTP response.
     * @param handler  The handler method.
     * @return True to proceed with the request, false to stop processing.
     */
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        final String correlationId = getOrGenerateCorrelationId(request, response);
        MDC.put(CORRELATION_ID_LOG_VAR_NAME, correlationId);
        return true;
    }

    /**
     * Called after the handler method has completed its execution. Removes the correlation ID
     * from the logging context.
     *
     * @param request  The incoming HTTP request.
     * @param response The HTTP response.
     * @param handler  The handler method.
     * @param ex       Any exception that may have occurred during execution.
     */
    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) {
        MDC.remove(CORRELATION_ID_LOG_VAR_NAME);
    }

    /**
     * Called after the handler method has successfully processed the request. Can be used for additional
     * post-processing if needed.
     *
     * @param request       The incoming HTTP request.
     * @param response      The HTTP response.
     * @param handler       The handler method.
     * @param modelAndView The model and view.
     */
    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler,
            ModelAndView modelAndView) {
        // You can leave this empty or log something if you wish.
    }


    /**
     * Retrieves or generates a correlation ID from the incoming HTTP request headers.
     * If the correlation ID is not present in the headers, a new one is generated and added to the response headers.
     *
     * @param request  The incoming HTTP request.
     * @param response The HTTP response.
     * @return The correlation ID.
     */
    private String getOrGenerateCorrelationId(HttpServletRequest request, HttpServletResponse response) {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
            response.addHeader(CORRELATION_ID_HEADER, correlationId);
        }
        return correlationId;
    }
}
