package com.example.LabWorkMay1.repositories;

import com.example.LabWorkMay1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContaining(String name);
    List<Product> findByDescriptionContaining(String description);
    List<Product> findByPriceGreaterThanEqual(double price);
    List<Product> findByPriceLessThanEqual(double price);
}
