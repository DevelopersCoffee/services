package com.coffeedev.service.entity;

import com.coffeedev.service.model.FoodType;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private String foodCategory;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String description;
    private String currency;
    private String price;
    private Integer stock;
    private float average_rating;
}