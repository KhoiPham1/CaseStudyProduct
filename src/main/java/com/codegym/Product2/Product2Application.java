package com.codegym.Product2;

import com.codegym.Product2.service.CompanyService;
import com.codegym.Product2.service.ProductService;
import com.codegym.Product2.service.impl.CompanyServiceImpl;
import com.codegym.Product2.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Product2Application {

	public static void main(String[] args) {
		SpringApplication.run(Product2Application.class, args);
	}
	@Bean
	public ProductService productService(){return new ProductServiceImpl();
	}
	@Bean
	public CompanyService companyService(){return new CompanyServiceImpl();
	}
}

