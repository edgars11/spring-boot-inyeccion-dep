package com.edgar.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.edgar.di.app.springboot_di.models.Product;

// @RequestScope // se maneja por request 1 sola vez
// @SessionScope // se maneja por sesión del navegador
@Repository("productList")
@Primary
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1, "Memoria ram 32", 300L),
                new Product(2, "Cpu Intel Core I7", 1250L),
                new Product(3, "Monito LG 28P", 850L),
                new Product(4, "Teclado Gamer", 425L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(int id) {
        return data.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

}
