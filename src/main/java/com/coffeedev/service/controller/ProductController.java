package com.coffeedev.service.controller;

import com.coffeedev.service.entity.Product;
import com.coffeedev.service.model.ProductDTO;
import com.coffeedev.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts(Pageable pageable){
        return productService.getProducts(pageable);
    }

    @GetMapping("/{product-id}")
    public Product getProducts(@PathVariable("product-id") Integer productId){
        return productService.getProducts(productId);
    }

    @PostMapping
    public Product save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/{product-id}")
    public Product update(@PathVariable("product-id") Integer productId, @RequestBody ProductDTO productDTO){
        return productService.update(productId, productDTO);
    }
}