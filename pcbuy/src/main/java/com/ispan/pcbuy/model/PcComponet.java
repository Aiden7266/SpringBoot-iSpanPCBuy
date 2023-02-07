package com.ispan.pcbuy.model;

import com.ispan.pcbuy.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PcComponet {

    private Integer productId;
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
    private Date createdDate;
    private Date lastModifiedDate;

}
