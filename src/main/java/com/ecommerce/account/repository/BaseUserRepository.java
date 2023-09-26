package com.ecommerce.account.repository;

import com.ecommerce.account.dto.request.UserQueryRequest;
import com.ecommerce.account.entity.User;
import java.util.List;

public interface BaseUserRepository {

    List<User> getUserByConditions(UserQueryRequest userQueryRequest);

}
