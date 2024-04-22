package com.example.lastproj.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    @Column(name = "first_name")
    @NotEmpty(message = "Enter first name")
    private String firstname;
    @Column(name = "last_name")
    @NotEmpty(message = "Enter last name")
    private String lastname;
    @NotEmpty(message = "Enter phone number")
    @Column(name = "phone")
    @Min(value = 0, message = "Age should be greater than 0")
    private String phoneNumber;
    @NotEmpty(message = "Enter email")
    @Column(name = "email")
    @Email
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    public Customer(String firstname, String lastname, String phoneNumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
