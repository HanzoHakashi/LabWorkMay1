package com.example.LabWorkMay1.controller;

import com.example.LabWorkMay1.dto.ProductDto;
import com.example.LabWorkMay1.entity.Product;
import com.example.LabWorkMay1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final ProductService productService;
    @GetMapping("/")
    public String index(ModelMap model) {
        Page<ProductDto> productsPage = productService.getProducts(0, 10);

        model.put("products", productsPage);
        return "index";
    }



}