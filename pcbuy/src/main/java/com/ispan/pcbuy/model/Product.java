package com.ispan.pcbuy.model;

import com.ispan.pcbuy.constant.ProductCategory;
import lombok.Data;
import java.util.Date;

@Data
public class Product {

/*
   private Integer productId;
   private String productName;
   private ProductCategory category;
   private String imageUrl;
   private Integer price;
   private Integer stock;
   private String description;
   private Date createdDate;
   private Date lastModifiedDate;
*/

   private Integer productId;
   private String productName;
   private ProductCategory category;
   private String brand;
   private String series;
   private Integer watt;
   private String  socket;
   private Integer score;
   private Integer size;
   private Double length;
   private Double height;
   private Integer capacity;
   private Boolean state;
   private String description;
   private String imageUrl;
   private Integer stock;
   private Integer price;
   private Date createdDate;
   private Date lastModifiedDate;
}
