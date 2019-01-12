package com.codegym.Product2.service;

import com.codegym.Product2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);

    Product findById(Long id);

    void save (Product product);

    void delete(Long id);
}
