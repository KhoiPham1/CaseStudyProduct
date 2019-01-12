package com.codegym.Product2.repository;

import com.codegym.Product2.model.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Company,Long> {
}
