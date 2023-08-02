package com.example.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaypalDto {
    private double price;
    private String currency; // tiền tệ
    private String method;
    private String intent; // ý định
    private String description;
}
