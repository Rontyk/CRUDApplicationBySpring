package com.example.lastproj.dto.request;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class SaleCreateRequest {
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    private int totalAmount;
    private int customer_id;
    private int product_id;
}
