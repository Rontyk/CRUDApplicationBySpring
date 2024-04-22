package com.example.lastproj.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City {
    @Id
    @Column(name= "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(mappedBy = "city")
    private List<Address> addresses;


    @Override
    public String toString() {
        return "" + cityName;
    }
}
