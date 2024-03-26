package com.example.lastproj.services;

import com.example.lastproj.models.City;
import com.example.lastproj.repositories.AddressesRepository;
import com.example.lastproj.repositories.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CitiesService {
    private final CitiesRepository citiesRepository;

    @Autowired
    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public List<City> findByCityName(String cityName){
        return citiesRepository.findByCityName(cityName);
    }

    public List<City> findAll(){
        return citiesRepository.findAll();
    }

    public City findOne(int id){
        Optional<City> foundCity =  citiesRepository.findById(id);

        return foundCity.orElse(null);
    }

    @Transactional
    public void save(City city){
        citiesRepository.save(city);
    }

    @Transactional
    public void update(int id, City updatedCity){
        updatedCity.setCity_id(id);
        citiesRepository.save(updatedCity);
    }

    @Transactional
    public void delete(int id){
        citiesRepository.deleteById(id);
    }
}
