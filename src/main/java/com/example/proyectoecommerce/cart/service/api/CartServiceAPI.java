package com.example.proyectoecommerce.cart.service.api;

import com.example.proyectoecommerce.cart.dto.DTOCart;
import com.example.proyectoecommerce.cart.model.Cart;
import com.example.proyectoecommerce.commons.GenericServiceAPI;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface CartServiceAPI extends GenericServiceAPI<Cart, DTOCart> {

    List<DTOCart> addProduct() throws InterruptedException, ExecutionException;

}