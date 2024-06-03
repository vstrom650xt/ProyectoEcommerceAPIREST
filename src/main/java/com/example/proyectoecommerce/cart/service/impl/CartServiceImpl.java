package com.example.proyectoecommerce.cart.service.impl;

import com.example.proyectoecommerce.cart.dto.DTOCart;
import com.example.proyectoecommerce.cart.model.Cart;
import com.example.proyectoecommerce.cart.service.api.CartServiceAPI;
import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CartServiceImpl extends GenericServiceImpl<Cart, DTOCart> implements CartServiceAPI {


   @Autowired
   private Firestore firestore;

    public CartServiceImpl() {
        super(DTOCart.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("cart");
    }


    @Override
    public List<DTOCart> addProduct() throws InterruptedException, ExecutionException {
        return null;
    }
}
