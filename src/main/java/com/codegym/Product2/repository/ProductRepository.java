package com.codegym.Product2.repository;

import com.codegym.Product2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
