package com.example.lastproj.repositories;


import com.example.lastproj.models.City;
import com.example.lastproj.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffsRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findByFirstname(String name);

}
