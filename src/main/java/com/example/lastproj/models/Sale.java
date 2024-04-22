package com.example.lastproj.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Sales")
@Getter
@Setter
@NoArgsConstructor
public class Sale {
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sale_id;
    @Temporal(TemporalType.DATE)
    @Column(name = "sales_date")
    private Date saleDate;
    @Column(name = "total_amount")
    private int totalAmount;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public Sale(Date saleDate, int totalAmount) {
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + sale_id +
                ", saleDate=" + saleDate +
                ", totalAmount=" + totalAmount +
                ", product=" + product +
                ", customer=" + customer +
                '}';
    }
}
