package com.ecommerce.account.service;

import com.ecommerce.account.dto.request.UserQueryRequest;
import com.ecommerce.account.dto.response.UserResponse;
import java.util.List;

public interface UserService {

    List<UserResponse> getListUser(UserQueryRequest userQueryRequest);

}
