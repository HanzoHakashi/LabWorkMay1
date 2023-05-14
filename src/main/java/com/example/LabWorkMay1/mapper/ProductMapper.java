package com.example.LabWorkMay1.mapper;

import com.example.LabWorkMay1.dto.ProductDto;
import com.example.LabWorkMay1.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
        public static ProductDto fromProduct(Product product){
            return ProductDto.builder()
                    .name(product.getName())
                    .image(product.getImage())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
        }

    }

