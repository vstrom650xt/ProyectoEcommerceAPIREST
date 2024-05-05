package com.example.proyectoecommerce.product.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    
    private String nombre;
    private String url;
    private double precio;
    private String descripcion;
    private boolean masVendido;
    private String marca;
    private String categoria;


}

