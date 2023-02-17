package com.ispan.pcbuy.service;

import com.ispan.pcbuy.dto.CreateOrderRequest;
import com.ispan.pcbuy.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
