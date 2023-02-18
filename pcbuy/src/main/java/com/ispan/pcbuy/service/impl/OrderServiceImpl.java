package com.ispan.pcbuy.service.impl;

import com.ispan.pcbuy.dao.OrderDao;
import com.ispan.pcbuy.dao.ProductDao;
import com.ispan.pcbuy.dto.BuyItem;
import com.ispan.pcbuy.dto.CreateCartRequest;
import com.ispan.pcbuy.dto.CreateOrderRequest;
import com.ispan.pcbuy.model.Cart;
import com.ispan.pcbuy.model.Order;
import com.ispan.pcbuy.model.OrderItem;
import com.ispan.pcbuy.model.Product;
import com.ispan.pcbuy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Override
    public void createCart(Integer userId, CreateCartRequest createCartRequest) {

        List<Cart> cartList = new ArrayList<>();
        for(BuyItem buyItem : createCartRequest.getBuyItemList()) {

            //轉換BuyItem to Cart
            Cart cart = new Cart();
            cart.setProductId(buyItem.getProductId());
            cartList.add(cart);
        }
        orderDao.createCart(userId, cartList);
    }

    @Override
    public List<Cart> getCart(Integer userId) {
        return orderDao.getCart(userId);
    }

    @Override
    public void clearCart(Integer userId) {

    }
}
