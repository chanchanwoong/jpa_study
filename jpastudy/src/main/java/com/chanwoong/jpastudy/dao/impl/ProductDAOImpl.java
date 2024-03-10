package com.chanwoong.jpastudy.dao.impl;

import com.chanwoong.jpastudy.dao.ProductDAO;
import com.chanwoong.jpastudy.entity.Product;
import com.chanwoong.jpastudy.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor        // ProductRepository 사용을 위해 생성자 만들어줌
@Component      // 스프링이 관리하는 빈 등록
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;      // 사용을 위해선 생성자가 필요하다. @RequiredArgsConstructor
    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectedProduct = productRepository.getById(number);
        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        // 메서드 반환 결과가 null인 경우, NullPointerException이 발생한다.
        // 이를 막기위해 Optional 클래스를 이용한다.
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        // number Pk값을 이용해 조회 결과가 있는 경우
        if (selectedProduct.isPresent()) {
            // get메서드를 이용해 Product 객체 반환
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        // 메서드 반환 결과가 null인 경우, NullPointerException이 발생한다.
        // 이를 막기위해 Optional 클래스를 이용한다.
        Optional<Product> selectedProduct = productRepository.findById(number);

        // number Pk값을 이용해 조회 결과가 있는 경우
        if (selectedProduct.isPresent()) {
            // get메서드를 이용해 Product 객체 반환
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
