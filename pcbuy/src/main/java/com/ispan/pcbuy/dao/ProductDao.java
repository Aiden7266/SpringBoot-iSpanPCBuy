package com.ispan.pcbuy.dao;

import com.ispan.pcbuy.dto.ProductRequest;
import com.ispan.pcbuy.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
