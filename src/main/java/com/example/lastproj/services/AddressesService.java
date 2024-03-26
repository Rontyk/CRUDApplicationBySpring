package com.example.lastproj.services;

import com.example.lastproj.models.Address;
import com.example.lastproj.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressesService {
    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressesService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public List<Address> findByStreetName(String streetName){
        return addressesRepository.findByStreet(streetName);
    }

    public List<Address> findAll(){
        return addressesRepository.findAll();
    }

    public Address findOne(int id){
        Optional<Address> foundAddress =  addressesRepository.findById(id);

        return foundAddress.orElse(null);
    }

    @Transactional
    public void save(Address address){
        addressesRepository.save(address);
    }

    @Transactional
    public void update(int id, Address updatedAddress){
        updatedAddress.setId(id);
        addressesRepository.save(updatedAddress);
    }

    @Transactional
    public void delete(int id){
        addressesRepository.deleteById(id);
    }
}
