package com.example.lastproj.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    @Column(name = "product_name")
    @NotEmpty(message = "Enter")
    private String productName;
    @Column(name = "description")
    @NotEmpty(message = "Enter")
    private String description;
    @Column(name = "price")
    @NotEmpty(message = "Enter")
    private Double price;
    @Column(name = "category_id")
    @NotEmpty(message = "Enter")
    private int categoryId;
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    public Product(String productName, String description, Double price, int categoryId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", sales=" + sales +
                '}';
    }
}
