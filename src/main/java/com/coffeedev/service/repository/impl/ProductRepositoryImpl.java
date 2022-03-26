package com.coffeedev.service.repository.impl;

import com.coffeedev.service.entity.Product;
import com.coffeedev.service.model.ProductDTO;
import com.coffeedev.service.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> productList = new ArrayList<>();

    public ProductRepositoryImpl() {
        for (int i = 1; i <= 10; i++){
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setFoodName(String.format("Product %d", i));
            product.setDescription(String.format("Product %d description", i));
            product.setCurrency(String.format("Product %d currency", i));
            product.setPrice(String.valueOf(i^2));
            product.setStock(10);
            product.setAverage_rating(0F);
            productList.add(product);
        }
    }

    @Override
    public List<Product> getProducts(Integer pageSize, Integer pageNumber) {
        return productList.stream().skip(pageSize*pageNumber).limit(pageSize).collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Integer id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product save(ProductDTO productDTO) {
        Product product = new Product();
        productList.add(product);
        return product;
    }

    @Override
    public Product update(Integer productId, ProductDTO productDTO) {
        Product product =  getProduct(productId);
        if (product != null){
            update(product, productDTO);
        }
        return product;
    }

    private void update(Product product, ProductDTO productDTO){
        if (productDTO != null) {
            System.out.println(productDTO.toString());
            Optional.ofNullable(productDTO.getFoodName()).ifPresent(product::setFoodName);
            Optional.ofNullable(productDTO.getDescription()).ifPresent(product::setDescription);
            Optional.ofNullable(productDTO.getCurrency()).ifPresent(product::setCurrency);
            Optional.ofNullable(productDTO.getStock()).ifPresent(product::setStock);
            Optional.ofNullable(productDTO.getPrice()).ifPresent(product::setPrice);
        }
    }
}