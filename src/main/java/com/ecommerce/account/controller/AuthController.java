package com.ecommerce.account.controller;

import com.ecommerce.account.dto.request.LoginRequest;
import com.ecommerce.account.dto.request.SignUpRequest;
import com.ecommerce.account.dto.response.BaseResponse;
import com.ecommerce.account.dto.response.TokenResponse;
import com.ecommerce.account.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
@Api(tags = "Authentication")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registry")
    @ApiOperation(value = "Register a new user", notes = "This endpoint allows for the registration of a new user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User registered successfully"),
            @ApiResponse(code = 400, message = "Bad request, possibly due to validation issues"),
            @ApiResponse(code = 500, message = "Server error while registering the user")
    })
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        log.info("Registry a new user with info : {}", signUpRequest);
        authService.signup(signUpRequest);
        log.info("User registered successfully with username : {}", signUpRequest.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body("Sing up success");
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<TokenResponse>> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        BaseResponse<TokenResponse> response = authService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/get/refresh-token")
    public ResponseEntity<BaseResponse<TokenResponse>> refreshToken( String token) {
        BaseResponse<TokenResponse> response = authService.generateToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
