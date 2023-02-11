package com.ispan.pcbuy.service.impl;

import com.ispan.pcbuy.dao.UserDao;
import com.ispan.pcbuy.dto.UserLoginRequest;
import com.ispan.pcbuy.dto.UserRegisterRequest;
import com.ispan.pcbuy.model.User;
import com.ispan.pcbuy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //檢查註冊的username
        User user = userDao.getUserByUsername(userRegisterRequest.getUsername());
        if(user != null) {
            log.warn("該帳號：{}，已經被註冊！", userRegisterRequest.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //使用 BCP 生成密碼的雜湊值
        String BCryptPassword = passwordEncoder.encode(userRegisterRequest.getPassword());
        userRegisterRequest.setPassword(BCryptPassword);
        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override //暫時棄用
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getUsername());

        //檢查 user 是否存在
        if(user == null){
            log.warn("該 email {} 尚未被註冊！", userLoginRequest.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        //比較密碼
        if(user.getPassword().equals(hashedPassword)){
            return user;
        }else {
            log.warn("該 email {} 的密碼不正確！", userLoginRequest.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
