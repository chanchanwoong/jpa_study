package com.chanwoong.jpastudy.repository;

import com.chanwoong.jpastudy.entity.Product;
import com.chanwoong.jpastudy.entity.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProductRepositoryTest {
    @PersistenceContext
    EntityManager entityManager;

    JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
    QProduct qProduct = QProduct.product;

    void queryDsl1() {
        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("---------------");
            System.out.println();
            System.out.println("Product Number > " + product.getNumber());
            System.out.println("Product Name > " + product.getName());
            System.out.println("Product Price > " + product.getPrice());
            System.out.println("Product Stock > " + product.getStock());
            System.out.println();
            System.out.println("---------------");
        }
    }

    void qeuryDsl2() {
        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("---------------");
            System.out.println();
            System.out.println("Product Name > " + product);
            System.out.println();
            System.out.println("---------------");
        }
    }

    void queryDsl3() {
        List<Tuple> tupleList = jpaQueryFactory
                .select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList){
            System.out.println("---------------");
            System.out.println();
            System.out.println("Product Name > " + product.get(qProduct.name));
            System.out.println("Product Price > " + product.get(qProduct.price));
            System.out.println();
            System.out.println("---------------");
        }
    }
}
