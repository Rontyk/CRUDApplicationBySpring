package com.example.lastproj.services;

import com.example.lastproj.models.Sale;
import com.example.lastproj.repositories.SalesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {
    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sale> findAll(){
        return salesRepository.findAll();
    }

    public Sale findOne(int id){
        Optional<Sale> foundAddress =  salesRepository.findById(id);

        return foundAddress.orElse(null);
    }

    @Transactional
    public void save(Sale sale){
        salesRepository.save(sale);
    }

    @Transactional
    public void update(int id, Sale updatedSale){
        updatedSale.setSale_id(id);
        salesRepository.save(updatedSale);
    }

    @Transactional
    public void delete(int id){
        salesRepository.deleteById(id);
    }
}
