package com.ecommerce.account.service;

import com.ecommerce.account.dto.request.UserQueryRequest;
import com.ecommerce.account.dto.response.UserResponse;
import com.ecommerce.account.entity.User;
import com.ecommerce.account.repository.UserRepository;
import com.ecommerce.account.util.ConverterUtil;
import java.util.List;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponse> getListUser(UserQueryRequest userQuery) {
        List<User> listUser = userRepository.getUserByConditions(userQuery);
        Function<User, UserResponse> userEntityToDto = this::toDto;
        List<UserResponse> userResponses = ConverterUtil.convertList(listUser, userEntityToDto);
        log.info("List user response : {}", userResponses);
        return userResponses;
    }

    private UserResponse toDto(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }
}
