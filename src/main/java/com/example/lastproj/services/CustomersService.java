package com.example.lastproj.services;

import com.example.lastproj.models.Customer;
import com.example.lastproj.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService{
    private final CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customer> findByCustomerName(String customerName){
        return customersRepository.findByFirstname(customerName);
    }

    public List<Customer> findAll(){
        return customersRepository.findAll();
    }

    public Customer findOne(int id){
        Optional<Customer> foundCustomer =  customersRepository.findById(id);

        return foundCustomer.orElse(null);
    }

    @Transactional
    public void save(Customer customer){
        customersRepository.save(customer);
    }

    @Transactional
    public void update(int id, Customer updatedCustomer){
        updatedCustomer.setCustomer_id(id);
        customersRepository.save(updatedCustomer);
    }

    @Transactional
    public void delete(int id){
        customersRepository.deleteById(id);
    }
}
