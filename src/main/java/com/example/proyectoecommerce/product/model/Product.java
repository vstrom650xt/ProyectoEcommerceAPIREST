package com.example.proyectoecommerce.product.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    
    private String nombre;
    private String imageUrl;
    private double precio;
    private String descripcion;
    private boolean esMasVendido;
    private String status;
    private String marca;


}

