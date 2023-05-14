package com.example.LabWorkMay1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class ProductDto {
    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
}
