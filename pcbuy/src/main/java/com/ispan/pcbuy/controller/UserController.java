package com.ispan.pcbuy.controller;

import com.ispan.pcbuy.dto.UserRegisterRequest;
import com.ispan.pcbuy.model.User;
import com.ispan.pcbuy.service.UserDetailsService;
import com.ispan.pcbuy.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRegisterRequest userRegisterRequest){
        System.out.println("呼叫註冊功能");
        Integer userId = userService.register(userRegisterRequest);
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/userinfo")
    public ResponseEntity<User> userinfo(){
        System.out.println("userinfo被呼叫了");
        String nowUsername = userDetailsService.getUsername();
        User user = userService.getUserByUsername(nowUsername);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/logoutUser")
    public void logout(){
        System.out.println("清除使用者資料");
        userDetailsService.setUsername(null);
    }

}
