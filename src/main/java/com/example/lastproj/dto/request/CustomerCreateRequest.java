package com.example.lastproj.dto.request;

import lombok.Data;

@Data
public class CustomerCreateRequest {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

}
