package com.edgar.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.di.app.springboot_di.models.Product;
import com.edgar.di.app.springboot_di.services.ProductServices;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductServices services;

    @GetMapping
    public List<Product> list() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Product getByIProduct(@PathVariable int id) {
        return services.findById(id);
    }
    
}
