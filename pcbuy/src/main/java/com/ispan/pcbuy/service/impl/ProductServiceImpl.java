package com.ispan.pcbuy.service.impl;

import com.ispan.pcbuy.dao.ProductDao;
import com.ispan.pcbuy.model.Product;
import com.ispan.pcbuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}