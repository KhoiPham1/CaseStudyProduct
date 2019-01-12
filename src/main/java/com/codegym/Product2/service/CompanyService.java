package com.codegym.Product2.service;

import com.codegym.Product2.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Iterable<Company> findAll ();

    Company findById(Long id);
}
