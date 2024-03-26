package com.example.lastproj.repositories;

import com.example.lastproj.models.City;
import com.example.lastproj.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String name);

}
