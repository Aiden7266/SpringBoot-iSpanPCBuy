package com.ispan.pcbuy.service;

import com.ispan.pcbuy.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
