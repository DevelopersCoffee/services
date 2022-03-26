package com.coffeedev.service.service;

import com.coffeedev.service.entity.Product;
import com.coffeedev.service.model.ProductDTO;
import com.coffeedev.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    private static List<ProductDTO> productList = new ArrayList<>();

    public List<Product> getProducts(Pageable pageable) {
        return productRepository.getProducts(pageable.getPageSize(), pageable.getPageNumber());
    }

    public Product getProducts(Integer productId) {
        return productRepository.getProduct(productId);
    }

    public Product save(@RequestBody ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }

    public Product update(Integer productId, ProductDTO productDTO) {
        return productRepository.update(productId, productDTO);
    }
}
