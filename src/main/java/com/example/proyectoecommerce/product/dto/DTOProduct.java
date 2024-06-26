package com.example.proyectoecommerce.product.dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DTOProduct {

    private String id;
    private String nombre;
    private String url;
    private double precio;
    private String descripcion;
    private boolean masVendido;
    private String marca;
    private String categoria;

    public DTOProduct(String marca) {
        this.marca= marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTOProduct that = (DTOProduct) o;
        return Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }
}
