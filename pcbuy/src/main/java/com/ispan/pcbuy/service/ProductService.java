package com.ispan.pcbuy.service;

import com.ispan.pcbuy.constant.ProductCategory;
import com.ispan.pcbuy.dto.ProductRequest;
import com.ispan.pcbuy.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void  updateProduct(Integer productId, ProductRequest productRequest);

    void  deleteProductById(Integer productId);
}
