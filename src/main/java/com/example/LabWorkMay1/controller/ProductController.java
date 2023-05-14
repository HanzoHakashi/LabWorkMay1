package com.example.LabWorkMay1.controller;

import com.example.LabWorkMay1.dto.ProductDto;
import com.example.LabWorkMay1.entity.Product;
import com.example.LabWorkMay1.repositories.ProductRepository;
import com.example.LabWorkMay1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productService.getProducts(page, size);
    }

    @GetMapping("/search")
    public Page<ProductDto> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productService.searchProducts(name, description, minPrice, maxPrice, page, size);
    }
}


