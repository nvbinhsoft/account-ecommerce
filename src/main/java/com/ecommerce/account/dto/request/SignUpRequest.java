package com.ecommerce.account.dto.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 40)
    @ApiModelProperty(value = "User's username", required = true, example = "nvbinh")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "User's mobile", required = true, example = "0989876654")
    private String mobile;

    @NotBlank
    @Size(max = 40)
    @Email
    @ApiModelProperty(value = "User's email address", required = true, example = "example@gmail.com")
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @ApiModelProperty(value = "User's password", required = true, example = "password123")
    private String password;

    public SignUpRequest() {

    }
}
