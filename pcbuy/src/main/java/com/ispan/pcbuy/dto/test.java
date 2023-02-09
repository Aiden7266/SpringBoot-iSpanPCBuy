package com.ispan.pcbuy.dto;

import com.ispan.pcbuy.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;

public class test {

    @NotNull
    private String productName;

    @NotNull
    private ProductCategory category;

    @NotNull
    private String brand;

    @NotNull
    private String series;

    @NotNull
    private Integer watt;

    @NotNull
    private String  socket;

    @NotNull
    private Integer score;

    @NotNull
    private Integer size;

    @NotNull
    private Integer length;

    @NotNull
    private Integer height;

    @NotNull
    private Integer capacity;

    @NotNull
    private Boolean state;

    private String description;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer stock;

    @NotNull
    private Integer price;

}