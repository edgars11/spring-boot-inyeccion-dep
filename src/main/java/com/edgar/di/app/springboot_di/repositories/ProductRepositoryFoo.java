package com.edgar.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edgar.di.app.springboot_di.models.Product;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(11, "Mouse Gamer AKT", 125L));
    }

    @Override
    public Product findById(int id) {
        return new Product(id, "Mouse Gamer AKT", 125L);
    }

}
