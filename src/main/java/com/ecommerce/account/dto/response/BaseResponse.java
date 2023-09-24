package com.ecommerce.account.dto.response;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * The BaseResponse class represents a standardized response structure for API endpoints.
 * <p>
 * This class encapsulates:
 * <ul>
 *     <li>A status code indicating the result of the API call (e.g., success, error).</li>
 *     <li>A message providing additional information or details about the result.</li>
 *     <li>An optional payload (items) of type {@code T}, which can be used to return data to the client.</li>
 * </ul>
 *
 * @param <T> the type of the items (payload) that might be included in the response.
 * @author [Binh Nguyen Van]
 */
@Getter
@Setter
public class BaseResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -2010077110826408295L;

    private Long code;

    private String message;

    private T items;

    public BaseResponse(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(Long code, String message, T items) {
        this.code = code;
        this.message = message;
        this.items = items;
    }
}
