package com.example.lastproj.controllers;

import com.example.lastproj.models.Product;
import com.example.lastproj.services.ProductsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market/products")
@AllArgsConstructor
public class ProductController {
    private final ProductsService productsService;


    @GetMapping("")
    public String product(Model model){
        model.addAttribute("products", productsService.findAll());
        return "product/index";
    }
    @GetMapping("/product/{id}")
    public String productShow(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productsService.findOne(id));
        return "product/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("product") Product product){
        return "product/new";
    }
    @PostMapping
    public String create(@ModelAttribute("product") @Valid Product product,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "product/new";
        }

        productsService.save(product);
        return "redirect:/products";
    }
}
