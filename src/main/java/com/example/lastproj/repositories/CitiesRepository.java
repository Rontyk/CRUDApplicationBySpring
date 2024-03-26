package com.example.lastproj.repositories;

import com.example.lastproj.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    List<City> findByCityName(String name);
}
