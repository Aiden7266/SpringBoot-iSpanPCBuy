package com.ispan.pcbuy.service;

import com.ispan.pcbuy.dto.UserLoginRequest;
import com.ispan.pcbuy.dto.UserRegisterRequest;
import com.ispan.pcbuy.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByUsername(String username);

    User login(UserLoginRequest UserLoginRequest);
}
