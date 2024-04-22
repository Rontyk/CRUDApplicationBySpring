package com.example.lastproj.dto.request;

import lombok.Data;

@Data
public class StaffCreateRequest {
    private String first_name;
    private String last_name;
    private String phone;
    private String position;
    private int address_id;
}
