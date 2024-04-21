package com.example.proyectoecommerce.product.service.impl;

import com.example.proyectoecommerce.commons.GenericServiceImpl;
import com.example.proyectoecommerce.product.dto.DTOProduct;
import com.example.proyectoecommerce.product.model.Product;
import com.example.proyectoecommerce.product.service.api.ProductServiceAPI;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, DTOProduct> implements ProductServiceAPI {


    @Autowired
    private Firestore firestore;

    public ProductServiceImpl() {
        super(DTOProduct.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("productos");
    }

    @Override
    public Set<DTOProduct> getBrench() throws ExecutionException, InterruptedException {
        CollectionReference collection = firestore.collection("productos");
        ApiFuture<QuerySnapshot> querySnapshot = collection.get();
        QuerySnapshot snapshot = querySnapshot.get();
        Set<DTOProduct> products = new HashSet<>();

        for (DocumentSnapshot document : snapshot.getDocuments()) {
            String marca = document.getString("marca");
            DTOProduct dtoProduct = new DTOProduct(marca);
            products.add(dtoProduct);
        }

        return products;
    }


}
