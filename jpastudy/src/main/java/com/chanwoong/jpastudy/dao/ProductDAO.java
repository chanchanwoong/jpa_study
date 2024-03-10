package com.chanwoong.jpastudy.dao;

import com.chanwoong.jpastudy.entity.Product;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product selectProduct(Long number);
    Product updateProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
