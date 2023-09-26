package com.ecommerce.account.controller;

import com.ecommerce.account.dto.request.UserQueryRequest;
import com.ecommerce.account.dto.response.BaseResponse;
import com.ecommerce.account.dto.response.UserResponse;
import com.ecommerce.account.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/v1/list")
    public ResponseEntity<List<UserResponse>> getListUser(UserQueryRequest userQuery) {
        log.info("Get list user with conditions : {}", userQuery);
        List<UserResponse> listUser = userService.getListUser(userQuery);
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

}
