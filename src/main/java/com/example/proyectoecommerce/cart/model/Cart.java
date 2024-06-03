package com.example.proyectoecommerce.cart.model;

import com.example.proyectoecommerce.product.model.Product;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    private List <Product> productList;



}
