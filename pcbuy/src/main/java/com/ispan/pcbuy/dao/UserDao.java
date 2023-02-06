package com.ispan.pcbuy.dao;

import com.ispan.pcbuy.dto.UserRegisterRequest;
import com.ispan.pcbuy.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
