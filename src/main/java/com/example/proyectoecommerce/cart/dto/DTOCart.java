package com.example.proyectoecommerce.cart.dto;

import com.example.proyectoecommerce.product.model.Product;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class DTOCart {

    private String id;
    private List<Product> productList;





}
