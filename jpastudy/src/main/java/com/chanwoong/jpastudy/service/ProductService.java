package com.chanwoong.jpastudy.service;

import com.chanwoong.jpastudy.dto.ProductDto;
import com.chanwoong.jpastudy.dto.ProductResponseDto;

// DAO에서 구현한 기능들을 호출해서 결괏값을 가져오도록 설계
public interface ProductService {
    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);
    ProductResponseDto changeProductName(Long number, String name) throws Exception;
    void deleteProduct(Long number) throws Exception;
}
