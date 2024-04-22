package com.example.lastproj.dto.request;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String productName;
    private String description;
    private Double price;
}
