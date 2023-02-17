package com.ispan.pcbuy.dao;

import com.ispan.pcbuy.dto.CreateOrderRequest;
import com.ispan.pcbuy.model.Order;
import com.ispan.pcbuy.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
}
