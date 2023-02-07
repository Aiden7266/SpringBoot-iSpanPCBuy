package com.ispan.pcbuy.dto;

import com.ispan.pcbuy.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    /*
    @NotNull
    private String productName;

    @NotNull
    private ProductCategory category;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer price;

    @NotNull
    private Integer stock;

    private String description;
    */
    private String productName;
    private ProductCategory category;
    private String brand;
    private String series;
    private Integer watt;
    private String  socket;
    private Integer score;
    private Integer size;
    private Integer length;
    private Integer height;
    private Integer capacity;
    private Boolean state;
    private String description;
    private String imageUrl;
    private Integer stock;
    private Integer price;
}
