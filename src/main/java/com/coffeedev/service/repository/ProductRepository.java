package com.coffeedev.service.repository;

import com.coffeedev.service.entity.Product;
import com.coffeedev.service.model.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository {
    List<Product> getProducts(Integer pageSize, Integer pageNumber);
    Product getProduct(Integer id);
    Product save(ProductDTO productDTO);
    Product update(Integer productId, ProductDTO productDTO);
}