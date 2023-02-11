package com.ispan.pcbuy.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/user/login")
    public String login(){
        return "Hello 這裡是登入跳轉頁面";
    }

    @GetMapping("/loginSuccess")
    public String hello(){
        return "登入成功";
    }

//    @GetMapping("/")
//    public String index(){
//        return "我是首頁";
//    }

    @GetMapping("/loginFail")
    public String fail(){
        return "登入失敗";
    }

    @GetMapping("/update")
//    @Secured({"ROLE_sale","ROLE_manager"})
//    @PreAuthorize("hasAnyAuthority('sale')")
//    @PostAuthorize("hasAnyAuthority('sale')") 會先執行方法後才驗證權限
    public String update(){
        System.out.println("我會先執行");
        return "哈囉 我是update";
    }


}
