package com.ecommerce.account.service;

import com.ecommerce.account.dto.request.LoginRequest;
import com.ecommerce.account.dto.request.SignUpRequest;
import com.ecommerce.account.dto.response.BaseResponse;
import com.ecommerce.account.dto.response.TokenResponse;

public interface AuthService {

    void signup(SignUpRequest signUpRequest);

    BaseResponse<TokenResponse> login(LoginRequest loginRequest);

    BaseResponse<TokenResponse> generateToken(String token);

}
