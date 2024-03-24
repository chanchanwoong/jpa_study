package com.chanwoong.jpastudy.repository;

import com.chanwoong.jpastudy.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {       // JpaRepository<엔티티 클래스, Id 어노테이션 필드의 타입>
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    boolean existsByNumber(Long number);

    long countByName(String name);

    void deleteByNumber(Long number);
    long removeByName(String name);

    // limit과 같은 역할
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // Not 키워드
    Product findByNumberNot(Long number);

    // Null 키워드
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtNotNull();

    // And, Or
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    // 초과
    List<Product> findByPriceGreaterThan(Long price);

    // 이상
    List<Product> findByPriceGreaterThanEqual(Long price);

    // 미만
    List<Product> findByPriceLessThan(Long price);

    // 이하
    List<Product> findByPriceLessThanEqual(Long price);

    // 이하 ~ 이상
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    // 부분 일치
    List<Product> findByNameLike(String name);

    // 정렬
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    // 여러 정렬 기준_쿼리메서드명에 다 적기
    // Price 정렬 후 재고 정렬
    List<Product> findByNameOrderByPriceAscStockDesc(String name);


    // 여러 정렬 기준_Sort 클래스 사용
    // productRepository.findByName("펜", Sort.by(Order.asc("price"), Order.desc("stock"))) 코드로 사용
    List<Product> findByName(String name, Sort sort);


    // 페이징 처리
    Page<Product> findByName(String name, Pageable pageable);
}
