package com.example.lastproj.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staff")
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staf_id;
    @Column(name = "first_name")
    @NotEmpty(message = "Enter")
    private String firstname;
    @Column(name = "last_name")
    @NotEmpty(message = "Enter")
    private String lastname;
    @NotEmpty(message = "Enter")
    @Column(name = "phone")
    private String phone;
    @NotEmpty(message = "Enter")
    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    public Staff(String firstname, String lastname, String phone, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + staf_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", address=" + address +
                '}';
    }
}
