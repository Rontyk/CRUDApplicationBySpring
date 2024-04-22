package com.example.lastproj.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressCreateRequest {
    @NotNull(message = "Enter a street!!")
    private String street;
    private String zip_code;
    private int city_id;
}
