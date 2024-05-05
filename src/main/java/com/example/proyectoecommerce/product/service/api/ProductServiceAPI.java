package com.example.proyectoecommerce.product.service.api;

import com.example.proyectoecommerce.commons.GenericServiceAPI;
import com.example.proyectoecommerce.product.dto.DTOProduct;
import com.example.proyectoecommerce.product.model.Product;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;


public interface ProductServiceAPI extends GenericServiceAPI<Product, DTOProduct> {

    Set<DTOProduct> getBrench() throws ExecutionException, InterruptedException;

    List<DTOProduct> getMostSold()  throws ExecutionException, InterruptedException;

    List<Product> getProductsByCategory(String id)  throws ExecutionException, InterruptedException;

    List<Product> getProductsByBrand(String brand);
}