package com.edgar.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.edgar.di.app.springboot_di.models.Product;
import com.edgar.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices {

    // Obtener el valor del config mediante la anotación @Value
    @Value("${config.price.tax}")
    Double tax;

    // Se obtiene el valor de la propiedad por inyección de dependencia
    @Autowired
    private Environment environment;
    
    private ProductRepository repository;
    
    // Inyección por setter
    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }

    // Para la inyección por constructor no se requiere de la anotación @Autowired - @Qualifier("productList") -- productJson
    public ProductServicesImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            // Inmutabilidad
            Double precioIva = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            // Product newProduct = new Product(p.getId(), p.getName(), precioIva.longValue());

            // Inmutabilidad
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(precioIva.longValue());
            return newProduct;

            // mutabilidad
            // p.setPrice(precioIva.longValue());
            // return p;
        }).collect(Collectors.toList());
    }


    public Product findById(int id){
        return repository.findById(id);
    }

}
