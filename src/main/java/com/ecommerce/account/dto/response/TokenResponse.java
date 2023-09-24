package com.ecommerce.account.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -6497697603656232884L;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("access_expires")
    private long accessExpires;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("refresh_expires")
    private long refreshExpires;
    @JsonProperty("timestamp")
    private Long timestamp;

    public TokenResponse() {
    }

    public TokenResponse(String accessToken, long accessExpires, String refreshToken, long refreshExpires, Long timestamp) {
        this.accessToken = accessToken;
        this.accessExpires = accessExpires;
        this.refreshToken = refreshToken;
        this.refreshExpires = refreshExpires;
        this.timestamp = timestamp;
    }
}
