package com.codegym.Product2.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }


    public Product() {
    }



    public Product(Company company, Long code, String name, Long price, Long quantity, String description, Long discount) {
        this.company = company;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.discount = discount;
    }
    @NotNull
    @Min(10)
    private Long code;

    @NotEmpty
    @Size(min = 2,max = 30)
    private String name;

    @NotNull
    @Min(17)
    private Long price;

//    @NotEmpty
    private Long quantity;

    @NotEmpty
    @Size (min = 10)
    private String description;


    private Long discount;


}
