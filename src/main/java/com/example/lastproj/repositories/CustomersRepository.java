package com.example.lastproj.repositories;

import com.example.lastproj.models.City;
import com.example.lastproj.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstname(String name);

}
