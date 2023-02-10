package com.ispan.pcbuy.dto;

import com.ispan.pcbuy.constant.ProductCategory;
import javax.validation.constraints.*;
import lombok.Data;

@Data
public class CaseRequest extends ProductRequest{

    @NotNull
    private String productName;

    @NotNull
    private ProductCategory category;

    @NotNull
    private String brand;

    @NotNull
    private Integer size;

    @NotNull
    private Double coolerLength;

    @NotNull
    private Double coolerHeight;

    @NotNull
    private Double gpuLength;

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
