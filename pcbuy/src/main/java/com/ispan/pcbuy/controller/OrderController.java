package com.ispan.pcbuy.controller;

import com.ispan.pcbuy.dto.CreateCartRequest;
import com.ispan.pcbuy.dto.CreateOrderRequest;
import com.ispan.pcbuy.model.Cart;
import com.ispan.pcbuy.model.Order;
import com.ispan.pcbuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid  CreateOrderRequest createOrderRequest){

        Integer orderId  = orderService.createOrder(userId, createOrderRequest);

        Order order =orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/users/{userId}/cart")
    public ResponseEntity<?> createCart(@PathVariable Integer userId,
                                        @RequestBody @Valid CreateCartRequest createCartRequest){
        System.out.println();
        orderService.createCart(userId, createCartRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping("/users/{userId}/cart")
    public ResponseEntity<?> getCart(@PathVariable Integer userId){

        List<Cart> cartList = orderService.getCart(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartList);
    }
}
