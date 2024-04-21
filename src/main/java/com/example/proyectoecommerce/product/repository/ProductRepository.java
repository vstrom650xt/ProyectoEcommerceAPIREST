package com.example.proyectoecommerce.product.repository;

import com.example.proyectoecommerce.product.dto.DTOProduct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Repository
public interface ProductRepository {
    DTOProduct createProduct(DTOProduct product);

    List<DTOProduct> getAllProduct() throws InterruptedException, ExecutionException;
    DTOProduct getProductById(String id) throws InterruptedException, ExecutionException;
    DTOProduct updateProduct(String id, DTOProduct user) throws InterruptedException, ExecutionException;
    void deleteProduct(String id) throws InterruptedException, ExecutionException;

    Set<DTOProduct>getAllBrench() throws  InterruptedException,ExecutionException;
}