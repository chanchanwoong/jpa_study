package com.chanwoong.jpastudy.repository;

import com.chanwoong.jpastudy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {       // JpaRepository<엔티티 클래스, Id 어노테이션 필드의 타입>

}
