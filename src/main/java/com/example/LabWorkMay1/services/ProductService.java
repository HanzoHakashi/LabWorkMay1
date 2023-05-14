package com.example.LabWorkMay1.services;

import com.example.LabWorkMay1.dto.ProductDto;
import com.example.LabWorkMay1.entity.Product;
import com.example.LabWorkMay1.mapper.ProductMapper;
import com.example.LabWorkMay1.repositories.ProductRepository;
import com.example.LabWorkMay1.utils.ProductSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Page<ProductDto> getProducts(int page, int size) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, size));
        Page<ProductDto> productDtos = products.map(ProductMapper::fromProduct);
        return productDtos;
    }




    public Page<ProductDto> searchProducts(String name, String description, Double minPrice, Double maxPrice, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Specification<Product> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(ProductSpecifications.nameContains(name));
        }
        if (description != null && !description.isEmpty()) {
            spec = spec.and(ProductSpecifications.descriptionContains(description));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.priceGreaterThanOrEqual(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceLessThanOrEqual(maxPrice));
        }

        Page<Product> productPage = productRepository.findAll(spec, pageable);

        List<ProductDto> productDtos = productPage.getContent().stream()
                .map(p->productMapper.fromProduct(p))
                .collect(Collectors.toList());

        return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
    }



}

