package com.example.lastproj.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street", nullable = false)
    private String street;


    @Column(name = "zip_code", nullable = false)
    private String zip_code;

    @OneToMany(mappedBy = "address")
    private List<Staff> staffs;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", columnDefinition = "integer")
    private City city;

    public Address(String street, String zipCode) {
        this.street = street;
        this.zip_code = zipCode;
    }
}
