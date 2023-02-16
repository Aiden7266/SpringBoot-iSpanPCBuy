package com.ispan.pcbuy.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderItem {

    private Integer orderItemId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Integer amount;

}
