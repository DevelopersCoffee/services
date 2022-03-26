package com.coffeedev.service;

import com.coffeedev.service.entity.Product;
import com.coffeedev.service.model.ProductDTO;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.junit.jupiter.api.Test;

import static com.googlecode.jmapper.api.JMapperAPI.global;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DTOEntityMapperTest {

    @Test
    public void givenUser_whenUseApiGlobal_thenConverted() {
        JMapperAPI jmapperApi = new JMapperAPI()
                .add(mappedClass(ProductDTO.class).add(global())) ;
        JMapper<ProductDTO, Product> userMapper1 = new JMapper<>
                (ProductDTO.class, Product.class,jmapperApi);
        Product product = new Product();
        ProductDTO result = userMapper1.getDestination(product);

        assertEquals(product.getId(), result.getId());
       // assertEquals(product.getEmail(), result.getEmail());
    }
}

/*

{
    "id": "11",
    "foodName": "Product 11",
    "foodCategory": null,
    "foodType": null,
    "description": "Product 11 description",
    "currency": "Product 11 currency",
    "price": "3",
    "stock": 10,
    "average_rating": 0.0
}
* */
