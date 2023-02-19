package com.ispan.pcbuy.controller;

import com.ispan.pcbuy.dto.UserRegisterRequest;
import com.ispan.pcbuy.dto.UserUpdateRequest;
import com.ispan.pcbuy.model.User;
import com.ispan.pcbuy.service.UserDetailsService;
import com.ispan.pcbuy.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @PutMapping("/{userId}")
    public ResponseEntity<User> register(@PathVariable Integer userId,
                                         @RequestBody @Valid UserUpdateRequest userUpdateRequest){
//        System.out.println("呼叫註冊功能");
        User user = userService.userUpdate(userId, userUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentUser(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(name);
//        System.out.println("目前的使用者" + name);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
}
