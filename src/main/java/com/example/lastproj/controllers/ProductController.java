package com.example.lastproj.controllers;

import com.example.lastproj.dto.request.ProductCreateRequest;
import com.example.lastproj.models.Product;
import com.example.lastproj.services.ProductsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {
    private final ProductsService productsService;


    @GetMapping
    public String product(Model model){
        model.addAttribute("products", productsService.findAll());
        return "products/index";
    }
    @GetMapping("/{id}")
    public String productShow(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productsService.findOne(id));
        return "products/show";
    }
    @GetMapping("/new")
    public ModelAndView newProduct(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping
    public String create(@ModelAttribute @Valid ProductCreateRequest product) {
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());

        productsService.save(newProduct);
        return "redirect:/products";
    }
}
