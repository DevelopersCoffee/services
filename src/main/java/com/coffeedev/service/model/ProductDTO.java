package com.coffeedev.service.model;

import com.coffeedev.service.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long id;
    private String foodName;
    private String foodCategory;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String description;
    private String currency;
    private String price;
    private Integer stock;
    private float average_rating;

    public Product _toConvertProductEntity(){
        Product entity = new Product();
        entity.getFoodName();
        return entity ;
    }
}