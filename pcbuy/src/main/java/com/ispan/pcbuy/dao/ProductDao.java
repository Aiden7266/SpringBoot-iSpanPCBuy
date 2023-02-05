package com.ispan.pcbuy.dao;

import com.ispan.pcbuy.dto.ProductQueryParams;
import com.ispan.pcbuy.dto.ProductRequest;
import com.ispan.pcbuy.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void  deleteProductById(Integer productId);
}
