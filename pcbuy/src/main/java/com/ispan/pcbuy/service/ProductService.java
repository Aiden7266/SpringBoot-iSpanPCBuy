package com.ispan.pcbuy.service;

import com.ispan.pcbuy.dto.ProductRequest;
import com.ispan.pcbuy.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
