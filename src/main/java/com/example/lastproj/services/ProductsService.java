package com.example.lastproj.services;

import com.example.lastproj.models.Product;
import com.example.lastproj.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public List<Product> findByProductName(String productName){
        return productsRepository.findByProductName(productName);
    }

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public Product findOne(int id){
        Optional<Product> foundProduct =  productsRepository.findById(id);

        return foundProduct.orElse(null);
    }

    @Transactional
    public void save(Product product){
        productsRepository.save(product);
    }

    @Transactional
    public void update(int id, Product updatedProduct){
        updatedProduct.setProduct_id(id);
        productsRepository.save(updatedProduct);
    }

    @Transactional
    public void delete(int id){
        productsRepository.deleteById(id);
    }
}
