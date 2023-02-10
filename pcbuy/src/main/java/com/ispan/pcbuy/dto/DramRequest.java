package com.ispan.pcbuy.dto;

import com.ispan.pcbuy.constant.ProductCategory;
import javax.validation.constraints.*;
import lombok.Data;

@Data
public class DramRequest extends ProductRequest{

    @NotNull
    private String productName;

    @NotNull
    private ProductCategory category;

    @NotNull
    private String brand;

    @NotNull
    private Integer watt;

    @NotNull
    private String  socket;

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
