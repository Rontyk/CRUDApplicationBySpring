package com.example.lastproj.services;

import com.example.lastproj.models.Address;
import com.example.lastproj.models.Sale;
import com.example.lastproj.models.Staff;
import com.example.lastproj.repositories.StaffsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StaffsService {
    private final StaffsRepository staffsRepository;

    public StaffsService(StaffsRepository staffsRepository) {
        this.staffsRepository = staffsRepository;
    }

    public List<Staff> findByStaffName(String staffName){
        return staffsRepository.findByFirstname(staffName);
    }

    public List<Staff> findAll(){
        return staffsRepository.findAll();
    }

    public Staff findOne(int id){
        Optional<Staff> foundStaff =  staffsRepository.findById(id);

        return foundStaff.orElse(null);
    }

    @Transactional
    public void save(Staff staff){
        staffsRepository.save(staff);
    }

    @Transactional
    public void update(int id, Staff updatedStaff){
        updatedStaff.setStaf_id(id);
        staffsRepository.save(updatedStaff);
    }

    @Transactional
    public void delete(int id){
        staffsRepository.deleteById(id);
    }
}
