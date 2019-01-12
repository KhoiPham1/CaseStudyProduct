package com.codegym.Product2.controller;

import com.codegym.Product2.model.Company;
import com.codegym.Product2.model.Product;
import com.codegym.Product2.service.CompanyService;
import com.codegym.Product2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductService productService;
    @ModelAttribute("company")
    public Iterable<Company>companies(){return companyService.findAll();}

    @GetMapping("create-product")
    public ModelAndView showFormProduct(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("products",new Product());
        return modelAndView;
    }
    @PostMapping("create-product")
    public ModelAndView createProduct(@Validated @ModelAttribute("products") Product product, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("create","abc",product);
            return modelAndView;
        }else {
            productService.save(product);
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("products",new Product());
            modelAndView.addObject("message","Successfully");
            return modelAndView;
        }
    }

    @GetMapping("products")
    public ModelAndView listProduct(@PageableDefault(size = 5) Pageable pageable){
        Page<Product>listProduct = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("products",listProduct);
        return modelAndView;
    }
    @GetMapping("edit-product/{id}")
    public ModelAndView formUpdate(@PathVariable Long id){
        Product product = productService.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("products",product );
            return modelAndView;
    }
    @PostMapping("edit-product")
    public ModelAndView updateProduct(@Validated @ModelAttribute("products")Product product, BindingResult result){
        if (result.hasFieldErrors()){
            return new ModelAndView("edit");
        }
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("mess","edit success!");
        return modelAndView;
    }

    @GetMapping("delete-product/{id}")
    public ModelAndView formDelete(@PathVariable Long id){
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("products", product);
        return modelAndView;
    }
    @PostMapping("delete-product")
    public String deleteProduct(@ModelAttribute("products")Product product){
        productService.delete(product.getId());
        return "redirect:products";
    }
    @GetMapping("list-search")
    public ModelAndView listSearch(@RequestParam("search") String search,Pageable pageable){
        Page<Product>products = productService.findByName(search,pageable);
        ModelAndView modelAndView =  new ModelAndView("search");
        modelAndView.addObject("search",products);
        return modelAndView;

    }


//    @GetMapping()
}
