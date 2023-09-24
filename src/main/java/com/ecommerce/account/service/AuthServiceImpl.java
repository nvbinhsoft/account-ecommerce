package com.ecommerce.account.service;

import com.ecommerce.account.common.constant.Regex;
import com.ecommerce.account.common.exception.InvalidUserException;
import com.ecommerce.account.configuration.config.UserErrorConfig;
import com.ecommerce.account.configuration.security.PasswordHasher;
import com.ecommerce.account.dto.request.LoginRequest;
import com.ecommerce.account.dto.request.SignUpRequest;
import com.ecommerce.account.dto.response.BaseResponse;
import com.ecommerce.account.dto.response.TokenResponse;
import com.ecommerce.account.entity.User;
import com.ecommerce.account.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserErrorConfig userErrorConfig;
    @Override
    public void signup(SignUpRequest signUpRequest) {
        this.validateUser(signUpRequest);
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setMobile(signUpRequest.getMobile());
        String newPassword = PasswordHasher.hashPassword(signUpRequest.getPassword());
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public BaseResponse<TokenResponse> login(LoginRequest loginRequest) {
        //TODO: use mechanism token-based authentication, return access token and refresh token.
        return null;
    }

    @Override
    public BaseResponse<TokenResponse> generateToken(String token) {
        //TODO: use when access token expires.
        return null;
    }

    private void validateUser(SignUpRequest signUpRequest) {
        // TODO: validate user
        String mobile = signUpRequest.getMobile();
        if(!mobile.matches(Regex.MOBILE)) {
            throw new InvalidUserException(userErrorConfig.getInvalidPhoneNumber().getCode(),
                    userErrorConfig.getInvalidPhoneNumber().getMessage());
        }
    }

}
